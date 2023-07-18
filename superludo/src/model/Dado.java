package model;

import java.util.Random;

/**
 * Esta classe representa um dado de Ludo. Ela usa o padrão Singleton para garantir que apenas uma instância do dado seja criada.
 */
public class Dado {
    
    private Random random = new Random();
    private int dadoValor = 0;
    
    private static Dado dado = null;
    
    private Dado() {};

    /**
     * Rola o dado e retorna o valor obtido.
     * @return O valor do dado, de 1 a 6.
     */
    public int rolarDado() {
        dadoValor =  random.nextInt(6) + 1;
        return dadoValor;
    }

    /**
     * Retorna o valor do dado.
     * @return O valor do dado, de 1 a 6.
     */
    public int getDadoValor() {
        return dadoValor;
    }
    
    /**
     * Retorna a instância do dado.
     * @return A instância do dado.
     */
    public static Dado getDado() {
        if (dado==null) {
            dado = new Dado();
        }
        
        return dado;
    }
}
