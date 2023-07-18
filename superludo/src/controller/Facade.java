package controller;

import model.*;

public class Facade {
    private Dado dado;
    private Tabuleiro tabuleiro;
    private Peao[] peoes;
    private Cor vez;

    public Facade() {
        dado = Dado.getDado();
        tabuleiro = new Tabuleiro();
        vez = Cor.VERDE;
        peoes = new Peao[16];
        for (int i = 0; i < 16; i++) {
            Cor cor = Cor.values()[i / 4];
            peoes[i] = new Peao(cor, tabuleiro.getInicio(cor));
        }
    }

    public int rolarDado() {
        return dado.rolarDado();
    }

    public boolean movePeao(int index, int passos) {
        Peao peao = peoes[index];
        if (peao.getCor() != vez) {
            return false;
        }

        // Lógica para mover o peão 'passos' casas, considerando as regras do jogo.

        vez = Cor.values()[(vez.getValor() + 1) % 4];
        return true;
    }

    public Cor getVez() {
        return vez;
    }
    
    public boolean moverPeao(int index) {
        // Você precisa implementar a lógica para mover o peão aqui.
        // Por enquanto, vamos supor que o movimento é sempre bem sucedido.
        return true;
    }

    public void proximaVez() {
        // Você precisa implementar a lógica para passar a vez para o próximo jogador aqui.
    }

    // Métodos adicionais conforme necessário.
}
