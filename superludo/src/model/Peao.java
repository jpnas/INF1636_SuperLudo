package model;

import javax.swing.*;

public class Peao {
    private Cor cor;
    private Tile posicao; 
    private JLabel imagem;
    
    
    public Peao(Cor cor, Tile posicao, JLabel imagem) {
        this.cor = cor;
        this.posicao = posicao;
        this.imagem = imagem;
        
    }

    public Cor getCor() {
        return cor;
    }

    public Tile getPosicao() {
        return posicao;
    }
    
    public JLabel getImagem() {
        return imagem;
    }

    public void setPosicao(Tile posicao) {
        this.posicao = posicao;
    }
}
