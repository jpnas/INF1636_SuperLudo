package view;

import javax.swing.*;
import controller.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaInicial extends JFrame implements ActionListener { 
	private static final long serialVersionUID = 1L;
	final int ALTURA = 250;
	final int COMPRIMENTO = 250;
	final int ESPACO = 20;
	private JLabel load_error;
    private JButton botaoNovaPartida;
    private Dimension gap;
    Color backgroundColor = new Color(100, 100, 100);

	public TelaInicial() {
		
		setTitle("Super Ludo");
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize();
		int x = (screenSize.width - COMPRIMENTO) / 2;
		int y = (screenSize.height - ALTURA) / 2;
        setBounds(x, y, COMPRIMENTO, ALTURA);    
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(backgroundColor);
        
        gap = new Dimension(0,80);
        
        load_error = new JLabel("Erro ao carregar partida", SwingConstants.CENTER);
        load_error.setForeground(new Color(189, 68, 28));
        load_error.setAlignmentX(Component.CENTER_ALIGNMENT);
        load_error.setVisible(false);
        
        botaoNovaPartida = new JButton("Jogar");
        botaoNovaPartida.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	Controller.getController().iniciarNovaPartida();
            }
        });
        botaoNovaPartida.addActionListener(this);
        botaoNovaPartida.setAlignmentX(Component.CENTER_ALIGNMENT);

       
        
        
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        add(Box.createRigidArea(gap));
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(botaoNovaPartida);

        add(load_error);
	}
    
    public void exibeErroCarregar() { load_error.setVisible(true); }
    
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();

        if (obj.equals(botaoNovaPartida)) { 
            Controller.getController().iniciarNovaPartida();
        }
    }
    
}
