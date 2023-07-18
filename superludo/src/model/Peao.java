package model;

/**
 * Esta classe representa um peão no jogo de Ludo.
 */
public class Peao {
    private Cor cor;
    private Tile posicao; 

    /**
     * Constrói um novo peão com a cor e posição especificadas.
     * @param cor A cor do peão.
     * @param posicao A posição inicial do peão.
     */
    public Peao(Cor cor, Tile posicao) {
        this.cor = cor;
        this.posicao = posicao;
    }

    /**
     * Retorna a cor do peão.
     * @return A cor do peão.
     */
    public Cor getCor() {
        return cor;
    }

    /**
     * Retorna a posição do peão.
     * @return A posição do peão.
     */
    public Tile getPosicao() {
        return posicao;
    }

    /**
     * Define a posição do peão.
     * @param posicao A nova posição do peão.
     */
    public void setPosicao(Tile posicao) {
        this.posicao = posicao;
    }
}
