package model;

import java.util.Random;

public class Dado {
    
    private Random random = new Random();
    private int dadoValor = 0;
    
    private static Dado dado = null;
    
    private Dado() {};

    public int rolarDado() {
        dadoValor =  random.nextInt(6) + 1;
        return dadoValor;
    }

    public int getDadoValor() {
        return dadoValor;
    }
    
    public static Dado getDado() {
        if (dado==null) {
            dado = new Dado();
        }
        
        return dado;
    }
}
