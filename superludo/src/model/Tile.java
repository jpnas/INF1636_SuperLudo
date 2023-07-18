package model;

import java.util.List;
import java.util.ArrayList;

public class Tile {
    private List<Peao> peoes = new ArrayList<Peao>();
    private Tile proximo;
    private int indice;
    private String tipo;

    public Tile(String tipo, int indice) {
        this.tipo = tipo;
        this.indice = indice;
    }

    public boolean isEmpty() {
        return peoes.isEmpty();
    }

    public int getNumeroDePeoes() {
        return peoes.size();
    }

    public boolean isBarreira() {
        if (tipo.equals("comum") && !peoes.isEmpty()) {
            Cor cor = peoes.get(0).getCor();

            if (peoes.size() == 2) {
                for (Peao peao: peoes) {
                    if (!peao.getCor().equals(cor)) {
                        return false;
                    }
                }
                return true;
            }
        } 
        return false;
    }

    public boolean possuiUmPeao() {
        return peoes.size() == 1;
    }

    public void adicionaPeao(Peao peao) {
        peoes.add(peao);
    }

    public void removePeao(Peao peao) {
        peoes.remove(peao);
    }

    public void setProximo(Tile proximo) {
        this.proximo = proximo;
    }

    public Tile getProximo() {
        return this.proximo;
    }

    public String getTipo() {
        return this.tipo;
    }

    public int getIndice() {
        return this.indice;
    }

    public boolean possuiPeaoDeOutraCor(Cor cor) {
        if (!peoes.isEmpty() && peoes.get(0).getCor().equals(cor)) {
            return true;
        } else {
            return false;
        }
    }

    public Peao primeiroPeao() {
        if (!peoes.isEmpty()) {
            return peoes.get(0);
        } else {
            return null;
        }
    }
}
