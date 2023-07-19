package model;

public enum Cor {
    VERDE(0, 0), 
    AMARELO(1, 13), 
    AZUL(2, 26), 
    VERMELHO(3, 39);

    private final int valor;
    private final int casaDeSaida;
    private int peoesFinalizados;


    Cor(int valor, int casaDeSaida) {
        this.valor = valor;
        this.casaDeSaida = casaDeSaida;
        this.peoesFinalizados = 0;
    }

    public int getValor() {
        return valor;
    }

    public int getCasaDeSaida() {
        return casaDeSaida;
    }
    
    public void adicionarPeaoFinalizado() {
    	peoesFinalizados++;
    }
    
    public boolean ganhouPartida() {
    	return peoesFinalizados == 4;
    }
    
    public int getPeoesFinalizados() {
    	return peoesFinalizados;
    }
}
