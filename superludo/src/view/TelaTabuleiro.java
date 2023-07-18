package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import controller.*;

public class TelaTabuleiro extends JFrame implements ActionListener {
    private Controller controller;
    private JLabel diceImageLabel;
    private JLabel turnLabel;
    private JButton rollDiceButton;
	
    public TelaTabuleiro() {
    	
    	setTitle("Super Ludo");
        // Configura o layout do JFrame para BorderLayout
        //this.setLayout(new BorderLayout());
        this.setSize(1280, 720);
        this.setLocationRelativeTo(null);  // adicionado aqui para centralizar a janela

        
        URL tabuleiroUrl = getClass().getResource("/images/TabuleiroLudo.jpg");
        // Carrega a imagem do tabuleiro
        ImageIcon boardImage = new ImageIcon(tabuleiroUrl);
        
        // Cria um JLabel para mostrar a imagem
        JLabel boardLabel = new JLabel(boardImage);
        
        // Adiciona o JLabel ao centro do JFrame
        this.add(boardLabel, BorderLayout.CENTER);
        
        // Cria um JPanel para as informações e botões
        JPanel infoPanel = new JPanel();
        
        turnLabel = new JLabel("Vez de jogar: Verde");
        turnLabel.setFont(new Font("Arial", Font.BOLD, 16));
        
        rollDiceButton = new JButton("Jogar dado");
        rollDiceButton.addActionListener(this);
        rollDiceButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        URL imageUrl = getClass().getResource("/images/Dado1.png");
        ImageIcon diceIcon = new ImageIcon(imageUrl);
        diceImageLabel = new JLabel(diceIcon);
        
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
        infoPanel.add(turnLabel);
        infoPanel.add(Box.createVerticalStrut(20));
        infoPanel.add(rollDiceButton);
        infoPanel.add(Box.createVerticalStrut(40)); // Adiciona 40 pixels de espaço
        infoPanel.add(diceImageLabel);
        
        // Adiciona o JPanel ao lado direito do JFrame
        this.add(infoPanel, BorderLayout.EAST);
        
        // Configura o JFrame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new TelaTabuleiro();
    }
    
    
    public void showErrorMessage(String message) {
        // Mostra uma caixa de diálogo com uma mensagem de erro.
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
        	   int diceResult = controller.getController().handleRolarDado(); // Rola o dado
               setDiceImage(diceResult); // Atualiza a exibição do resultado do dado
               System.out.print("Oi");
        } 
    }
}
