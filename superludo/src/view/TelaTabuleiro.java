package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

import controller.*;
import model.*;

public class TelaTabuleiro extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
	private Controller controller;
    private JLabel diceImageLabel, cartesianReference;
    private JLabel turnLabel;
    private JButton rollDiceButton;
    private Peao peoes[];
    private int diceResult;
    private boolean dadoRolado;
	
    public TelaTabuleiro() {
    	
    		
    	setTitle("Super Ludo");
    	 this.setResizable(false);
    	this.dadoRolado = false;
    	this.controller = new Controller();
        this.setSize(1280, 720);
        this.setLocationRelativeTo(null);  // adicionado aqui para centralizar a janela

        
        URL tabuleiroUrl = getClass().getResource("/images/TabuleiroLudo.jpg");
        ImageIcon boardImage = new ImageIcon(tabuleiroUrl);
        
        JLabel boardLabel = new JLabel(boardImage);
        
        this.add(boardLabel, BorderLayout.CENTER);
        
        JPanel infoPanel = new JPanel(new GridBagLayout());
        Dimension preferredSize = new Dimension(250, boardLabel.getMaximumSize().height);
        infoPanel.setPreferredSize(preferredSize);
        GridBagConstraints gbc = new GridBagConstraints();
        
        
        gbc.gridx = 0;
        gbc.gridy = GridBagConstraints.RELATIVE;
        gbc.anchor = GridBagConstraints.CENTER;
        
        turnLabel = new JLabel("Vez de jogar: " + controller.getVez().name());
        turnLabel.setFont(new Font("Arial", Font.BOLD, 16));
        
        rollDiceButton = new JButton("Jogar dado");
        rollDiceButton.addActionListener(this);
        
        URL imageUrl = getClass().getResource("");
        ImageIcon diceIcon = new ImageIcon(imageUrl);
        diceImageLabel = new JLabel(diceIcon);
        
        infoPanel.add(turnLabel, gbc);
        infoPanel.add(Box.createVerticalStrut(40));
        infoPanel.add(rollDiceButton, gbc);
        infoPanel.add(Box.createVerticalStrut(60));
        infoPanel.add(diceImageLabel, gbc);
        
        
        // Adiciona os peões no tabuleiro
        peoes = controller.getPeoes();
        for (int i = 0; i < peoes.length; i++) {
        	int peaoIndex = i % 4;
            JLabel peaoImageLabel = peoes[i].getImagem();
            peaoImageLabel.setBounds(Coordenada.getXInicio(peoes[i].getCor(), peaoIndex), Coordenada.getYInicio(peoes[i].getCor(), peaoIndex), 15, 15);
            boardLabel.add(peaoImageLabel);
        }
        
        // Adiciona MouseListener nos peões
        for (int i = 0; i < peoes.length; i++) {
            final Peao peaoAtual = peoes[i];
            JLabel peaoImageLabel = peaoAtual.getImagem();
            
 
            peaoImageLabel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                	if (dadoRolado == false) {
                		return;
                	}
                	if (peaoAtual.getCor() != controller.getVez()) {
                		return;
                	}
                    boolean movimentoValido = controller.moverPeao(peaoAtual, diceResult);
                    
                    if (movimentoValido) {
                    	int coordenadaX, coordenadaY;
                    	if (peaoAtual.getPosicao().getTipo().equals("retaFinal")) {
                    		coordenadaX = Coordenada.getXRetaFinal(peaoAtual.getCor(), peaoAtual.getPosicao().getIndice(), peaoAtual.getPosicao().isEmpty());
                    		coordenadaY = Coordenada.getYRetaFinal(peaoAtual.getCor(), peaoAtual.getPosicao().getIndice(), peaoAtual.getPosicao().isEmpty());
                    	} else { 
                    		coordenadaX = Coordenada.getXTabuleiro(peaoAtual.getPosicao().getIndice(), peaoAtual.getPosicao().isEmpty());
                    		coordenadaY = Coordenada.getYTabuleiro(peaoAtual.getPosicao().getIndice(), peaoAtual.getPosicao().isEmpty()); 
                    	}
                    	peaoImageLabel.setBounds(coordenadaX, coordenadaY, 15, 15);
                    	rollDiceButton.setEnabled(true);
                    	if (diceResult < 6) {                    		
                    		controller.proximoJogador();
                    	}
                        turnLabel.setText("Vez de jogar: " + controller.getVez().name());
                        dadoRolado = false;
                    } else {
                        showErrorMessage("Movimento inválido!");
                        if (peaoAtual.getCor().getPeoesFinalizados() == 3) {
                        	controller.proximoJogador();
                        }
                       
                    }
                    
                }
            });
        }
        
        
        cartesianReference = new JLabel("x");
        cartesianReference.setBounds(7,1,15,15);
        boardLabel.add(cartesianReference);

        this.add(infoPanel, BorderLayout.EAST);
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
    }
    
    
    public void showErrorMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
    
    public void setDiceImage(int value) {
        URL imageUrl = getClass().getResource("/images/Dado" + value + ".png");
        ImageIcon diceIcon = new ImageIcon(imageUrl);
        diceImageLabel.setIcon(diceIcon);
    }
    
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();

        if (obj.equals(rollDiceButton)) { 
        	   diceResult = controller.rolarDado();
               setDiceImage(diceResult);
               rollDiceButton.setEnabled(false);
               dadoRolado = true;
        } 
    }
}
