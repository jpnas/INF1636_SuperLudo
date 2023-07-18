package model;

/**
 * Este enum representa as cores dos peões no jogo de Ludo.
 */
public enum Cor {
    VERDE(0, 0), 
    AMARELO(1, 13), 
    AZUL(2, 26), 
    VERMELHO(3, 39);

    private final int valor;
    private final int casaDeSaida;

    /**
     * Constrói uma nova cor com o valor e a casa de saída especificados.
     * @param valor O valor da cor.
     * @param casaDeSaida A casa de saída para a cor.
     */
    Cor(int valor, int casaDeSaida) {
        this.valor = valor;
        this.casaDeSaida = casaDeSaida;
    }

    /**
     * Retorna o valor da cor.
     * @return O valor da cor.
     */
    public int getValor() {
        return valor;
    }

    /**
     * Retorna a casa de saída para a cor.
     * @return A casa de saída para a cor.
     */
    public int getCasaDeSaida() {
        return casaDeSaida;
    }
}
