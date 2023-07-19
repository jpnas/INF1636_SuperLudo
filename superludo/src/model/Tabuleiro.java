package model;

import java.util.Map;
import java.util.HashMap;

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

    private final Map<Cor, Tile[]> iniciosPorCor, retasFinaisPorCor;

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

        this.iniciosPorCor = new HashMap<>();
        this.iniciosPorCor.put(Cor.VERDE, inicioVerde);
        this.iniciosPorCor.put(Cor.AMARELO, inicioAmarelo);
        this.iniciosPorCor.put(Cor.AZUL, inicioAzul);
        this.iniciosPorCor.put(Cor.VERMELHO, inicioVermelho);
        
        
        this.retasFinaisPorCor = new HashMap<>();
        this.retasFinaisPorCor.put(Cor.VERDE, retaFinalVerde);
        this.retasFinaisPorCor.put(Cor.AMARELO, retaFinalAmarela);
        this.retasFinaisPorCor.put(Cor.AZUL, retaFinalAzul);
        this.retasFinaisPorCor.put(Cor.VERMELHO, retaFinalVermelha);
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

        for (int i = 0; i < TAMANHO_RETA_FINAL; i++) {
            retaFinalVerde[i] = new Tile("retaFinal", i);
            retaFinalAmarela[i] = new Tile("retaFinal", i);
            retaFinalAzul[i] = new Tile("retaFinal", i);
            retaFinalVermelha[i] = new Tile("retaFinal", i);
        }
    }

    private void conectaTilesTabuleiro() {
        for (int i = 0; i < 4; i++) {
            inicioVerde[i].setProximo(tabuleiroBasico[Cor.VERDE.getCasaDeSaida()]);
            inicioAmarelo[i].setProximo(tabuleiroBasico[Cor.AMARELO.getCasaDeSaida()]);
            inicioAzul[i].setProximo(tabuleiroBasico[Cor.AZUL.getCasaDeSaida()]);
            inicioVermelho[i].setProximo(tabuleiroBasico[Cor.VERMELHO.getCasaDeSaida()]);
        }

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
            if (inicio[i].isEmpty() == 0) {
                inicio[i].adicionaPeao(peao);
                break;
            }
        }
    }
    
    public Tile[] getInicio(Cor cor) {
        return iniciosPorCor.get(cor);
    }
    
    public Tile[] getRetaFinal(Cor cor) {
        return retasFinaisPorCor.get(cor);
    }
    
    public Tile getNovaPosicao(Tile posicaoAtual, int numeroCasas, Cor cor) {
    	Tile novaPosicao = posicaoAtual;
    	
    	for (int i = 0; i < numeroCasas; i++) {
    		if (novaPosicao.getIndex() == 50 && cor.equals(Cor.VERDE)) {
    			novaPosicao = retaFinalVerde[0];
    			System.out.println(novaPosicao.getTipo());
    		} else if (novaPosicao.getIndex() == 11 && cor.equals(Cor.AMARELO)) {
    			novaPosicao = retaFinalAmarela[0];
    		} else if (novaPosicao.getIndex() == 24 && cor.equals(Cor.AZUL)) {
    			novaPosicao = retaFinalAzul[0];
    		} else if (novaPosicao.getIndex() == 37 && cor.equals(Cor.VERMELHO)) {
    			novaPosicao = retaFinalVermelha[0];
    		} else {    			
    		novaPosicao = novaPosicao.getProximo();
    		}
    	}
        
        int novaPosicaoIndex = novaPosicao.getIndex();
        
        
        if (novaPosicao.getTipo().equals("retaFinal")) {
        	return getRetaFinal(cor)[novaPosicaoIndex];
        }
        return tabuleiroBasico[novaPosicaoIndex % tabuleiroBasico.length];
    }


    public boolean isMovimentoValido(Peao peao, Tile posicaoAtual, int numeroCasas) {
       
    	Tile novaPosicao = posicaoAtual;
    	
    	if (posicaoAtual.getTipo().equals("inicial") && tabuleiroBasico[peao.getCor().getCasaDeSaida()].possuiPeaoDaMesmaCor(peao.getCor())) {
    		return false;
    	}
    	
    	if (posicaoAtual.getTipo().equals("retaFinal")) {
    		for (int i = 0; i < numeroCasas; i++) {
        		novaPosicao = novaPosicao.getProximo();
        		
        		if (novaPosicao == null) {
        			return false;
        		}
        	}
    	}
    	
    	novaPosicao = posicaoAtual;
    	
    	for (int i = 0; i < numeroCasas; i++) {
    		novaPosicao = novaPosicao.getProximo();
    		if (novaPosicao.isBarreira()) {
    			return false;
    		}
    	}
    	
    	
        
        return true;
    }

    public boolean isFinal(Tile posicao, Cor cor) {
        if (cor == Cor.VERDE && posicao == retaFinalVerde[TAMANHO_RETA_FINAL - 1]) {
            return true;
        } else if (cor == Cor.AMARELO && posicao == retaFinalAmarela[TAMANHO_RETA_FINAL - 1]) {
            return true;
        } else if (cor == Cor.AZUL && posicao == retaFinalAzul[TAMANHO_RETA_FINAL - 1]) {
            return true;
        } else if (cor == Cor.VERMELHO && posicao == retaFinalVermelha[TAMANHO_RETA_FINAL - 1]) {
            return true;
        }
        return false;
    }

    

}
