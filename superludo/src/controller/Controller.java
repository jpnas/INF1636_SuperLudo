package controller;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.image.BufferedImage;
import model.*;
import view.*;

public class Controller {
    private static Controller controller = null;
    private TelaTabuleiro telaTabuleiro;
    private TelaInicial telaInicial;
    private Dado dado;
    private Tabuleiro tabuleiro;
    private Peao[] peoes;
    private Cor vez;

    public Controller() {
    	 dado = Dado.getDado();
         tabuleiro = new Tabuleiro();
         Coordenada.load();
         vez = Cor.VERDE;
         peoes = new Peao[16];
         
         ImagemPeao imagemPeao = new ImagemPeao();
         BufferedImage peaoVerde = imagemPeao.createImage(Color.GREEN);
         BufferedImage peaoAmarelo = imagemPeao.createImage(Color.YELLOW);
         BufferedImage peaoAzul = imagemPeao.createImage(Color.BLUE);
         BufferedImage peaoVermelho = imagemPeao.createImage(Color.RED);
         
         for (int i = 0; i < 16; i++) {
        	 BufferedImage peaoImg = null;
             Cor cor = Cor.values()[i / 4];
             switch (cor) {
                 case VERDE:
                     peaoImg = peaoVerde;
                     break;
                 case AMARELO:
                	 peaoImg = peaoAmarelo;
                	 break;
                 case AZUL:
                     peaoImg = peaoAzul;
                     break;
                 case VERMELHO:
                	 peaoImg = peaoVermelho;
                	 break;
             }

             ImageIcon peaoIcon = new ImageIcon(peaoImg);
             JLabel peaoLabel = new JLabel(peaoIcon);
             peoes[i] = new Peao(cor, tabuleiro.getInicio(cor)[i%4], peaoLabel);
         }
         
    }

    public static Controller getController() {
        if (controller == null) {
            controller = new Controller();
        }
        return controller;
    }
    
	public void init() {
		telaInicial = new TelaInicial();
		telaInicial.setVisible(true);
	}

	public void iniciarNovaPartida() {
	    telaInicial.setVisible(false);
	    if (telaTabuleiro == null) {
	        telaTabuleiro = new TelaTabuleiro();
	    }
	    telaTabuleiro.setVisible(true);
	}

    
    public Peao[] getPeoes() {
        return peoes;
    }

    public int rolarDado() {
        return dado.rolarDado();
    }

    public boolean moverPeao(Peao peao, int numeroCasas) {
        Tile posicaoAtual = peao.getPosicao();
                

        if (tabuleiro.isMovimentoValido(peao, posicaoAtual, numeroCasas)) {
        	Tile novaPosicao = tabuleiro.getNovaPosicao(posicaoAtual, numeroCasas, peao.getCor());
        	
        	// Captura
        	if (novaPosicao.possuiPeaoDeOutraCor(peao.getCor()) && !novaPosicao.getTipo().equals("abrigo")) {
        		Peao peaoCapturado = novaPosicao.getPrimeiroPeao();     		
        		novaPosicao.removePeao(novaPosicao.getPrimeiroPeao());
        		Tile casaInicial = getPrimeiraCasaInicialVazia(peaoCapturado.getCor());
        		casaInicial.adicionaPeao(peaoCapturado);
        		
        		JLabel peaoCapturadoLabel = peaoCapturado.getImagem();
        	    int coordenadaX, coordenadaY;
        	    coordenadaX = Coordenada.getXInicio(peaoCapturado.getCor(), casaInicial.getIndice());
        	    coordenadaY = Coordenada.getYInicio(peaoCapturado.getCor(), casaInicial.getIndice());
        	    peaoCapturadoLabel.setBounds(coordenadaX, coordenadaY, 15, 15);
        	}
        	
            // Realiza o movimento
            peao.setPosicao(novaPosicao);
            posicaoAtual.removePeao(peao);
            novaPosicao.adicionaPeao(peao);
            

            // Verifica se o peão chegou à posição final
            if (tabuleiro.isFinal(novaPosicao, peao.getCor())) {
                peao.getCor().adicionarPeaoFinalizado();             
                if (peao.getCor().ganhouPartida()) {
                	JOptionPane.showMessageDialog(telaTabuleiro, vez.toString() + " ganhou!");
                	System.exit(0);
                }
            }
            return true;
        } else {
            return false;
        }
    }

    public Tile getPrimeiraCasaInicialVazia(Cor cor) {
        Tile[] inicio = tabuleiro.getInicio(cor);

        for (int i = 0; i < inicio.length; i++) {
            if (inicio[i].getPeoes().isEmpty()) {
                return inicio[i];
            }
        }
        return null;
    }
    
    
    public void proximoJogador() {
    	if (vez.equals(Cor.VERDE)) {
    		vez = Cor.AMARELO;
    	} else if (vez.equals(Cor.AMARELO)) {
    		vez = Cor.AZUL;
    	} else if (vez.equals(Cor.AZUL)) {
    		vez = Cor.VERMELHO;
    	} else {
    		vez = Cor.VERDE;
    	}
    }
    
    public Cor getVez() {
    	return vez;
    }
}
