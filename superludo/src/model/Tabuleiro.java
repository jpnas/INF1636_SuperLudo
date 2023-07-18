package model;

import java.util.Map;
import java.util.HashMap;

/**
 * Esta classe representa o tabuleiro do jogo de Ludo.
 */
public class Tabuleiro {
    private static final int TAMANHO_TABULEIRO = 52;
    private static final int TAMANHO_RETA_FINAL = 6;

    private final Tile[] tabuleiroBasico;
    private final Tile[] inicioVerde;
    private final Tile[] inicioAmarelo;
    private final Tile[] inicioAzul;
    private final Tile[] inicioVermelho;
    private final Tile[] retaFinalVerde;
    private final Tile[] retaFinalAmarela;
    private final Tile[] retaFinalAzul;
    private final Tile[] retaFinalVermelha;

    // Mapa de cores para os arrays iniciais
    private final Map<Cor, Tile[]> iniciosPorCor;

    public Tabuleiro() {
        this.tabuleiroBasico = new Tile[TAMANHO_TABULEIRO];
        this.inicioVerde = new Tile[4];
        this.inicioAmarelo = new Tile[4];
        this.inicioAzul = new Tile[4];
        this.inicioVermelho = new Tile[4];
        this.retaFinalVerde = new Tile[TAMANHO_RETA_FINAL];
        this.retaFinalAmarela = new Tile[TAMANHO_RETA_FINAL];
        this.retaFinalAzul = new Tile[TAMANHO_RETA_FINAL];
        this.retaFinalVermelha = new Tile[TAMANHO_RETA_FINAL];
        povoaTabuleiro();
        conectaTilesTabuleiro();

        // Preenche o mapa de cores para os arrays iniciais
        this.iniciosPorCor = new HashMap<>();
        this.iniciosPorCor.put(Cor.VERDE, inicioVerde);
        this.iniciosPorCor.put(Cor.AMARELO, inicioAmarelo);
        this.iniciosPorCor.put(Cor.AZUL, inicioAzul);
        this.iniciosPorCor.put(Cor.VERMELHO, inicioVermelho);
    }

    private void povoaTabuleiro() {
        for (int i = 0; i < 4; i++) {
            inicioVerde[i] = new Tile("inicial", i);
            inicioAmarelo[i] = new Tile("inicial", i);
            inicioAzul[i] = new Tile("inicial", i);
            inicioVermelho[i] = new Tile("inicial", i);
        }

        int index = 0;
        for (int i = 0; i < 4; i++) {
            tabuleiroBasico[index] = new Tile("saida", index);
            index++;
            for (int j = 0; j < 8; j++) {
                tabuleiroBasico[index] = new Tile("comum", index);
                index++;
            }
            tabuleiroBasico[index] = new Tile("abrigo", index);
            index++;
            for (int j = 0; j < 3; j++) {
                tabuleiroBasico[index] = new Tile("comum", index);
                index++;
            }
        }

        for (int i = 0; i < TAMANHO_RETA_FINAL - 1; i++) {
            retaFinalVerde[i] = new Tile("retaFinal", i);
            retaFinalAmarela[i] = new Tile("retaFinal", i);
            retaFinalAzul[i] = new Tile("retaFinal", i);
            retaFinalVermelha[i] = new Tile("retaFinal", i);
        }
    }

    private void conectaTilesTabuleiro() {
        for (int i = 0; i < 3; i++) {
            inicioVerde[i].setProximo(inicioVerde[i + 1]);
            inicioAmarelo[i].setProximo(inicioAmarelo[i + 1]);
            inicioAzul[i].setProximo(inicioAzul[i + 1]);
            inicioVermelho[i].setProximo(inicioVermelho[i + 1]);
        }
        inicioVerde[3].setProximo(null);
        inicioAmarelo[3].setProximo(null);
        inicioAzul[3].setProximo(null);
        inicioVermelho[3].setProximo(null);

        for(int i = 0; i < TAMANHO_TABULEIRO - 1; i++) {
            tabuleiroBasico[i].setProximo(tabuleiroBasico[i + 1]);
        }
        tabuleiroBasico[TAMANHO_TABULEIRO - 1].setProximo(tabuleiroBasico[0]);

        for(int i = 0; i < TAMANHO_RETA_FINAL - 1; i++) {
            retaFinalVerde[i].setProximo(retaFinalVerde[i + 1]);
            retaFinalAmarela[i].setProximo(retaFinalAmarela[i + 1]);
            retaFinalAzul[i].setProximo(retaFinalAzul[i + 1]);
            retaFinalVermelha[i].setProximo(retaFinalVermelha[i + 1]);
        }


        tabuleiroBasico[0].setProximo(inicioVerde[0]);
        tabuleiroBasico[13].setProximo(inicioAmarelo[0]);
        tabuleiroBasico[26].setProximo(inicioAzul[0]);
        tabuleiroBasico[39].setProximo(inicioVermelho[0]);

        tabuleiroBasico[8].setProximo(retaFinalVerde[0]);
        tabuleiroBasico[21].setProximo(retaFinalAmarela[0]);
        tabuleiroBasico[34].setProximo(retaFinalAzul[0]);
        tabuleiroBasico[47].setProximo(retaFinalVermelha[0]);
    }

    public void soltaPeao(Peao peao) {
        Cor cor = peao.getCor();
        Tile[] inicio = iniciosPorCor.get(cor);
        inicio[3].adicionaPeao(peao);
        peao.setPosicao(inicio[3]);
    }

    public void voltaPeaoInicio(Peao peao) {
        Cor cor = peao.getCor();
        Tile[] inicio = iniciosPorCor.get(cor);

        for (int i = 3; i >= 0; i--) {
            if (inicio[i].isEmpty()) {
                inicio[i].adicionaPeao(peao);
                break;
            }
        }
    }
    
    public Tile getInicio(Cor cor) {
        return iniciosPorCor.get(cor)[3];
    }

}
