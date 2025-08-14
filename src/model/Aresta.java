package model;

import java.util.ArrayList;

public class Aresta {
    private ArrayList<Filme> relacionadosPorGenero = new ArrayList<>();
    private ArrayList<Filme> relacionadosPorAtor = new ArrayList<>();;
    private Filme destino;
    private int peso;

    public Aresta(Filme Destino, int fatorDeRelacao, int peso) {
        if (fatorDeRelacao == 0) {
            this.relacionadosPorGenero.add(Destino);
        } else if (fatorDeRelacao == 1) {
            this.relacionadosPorAtor.add(Destino);
        }
    }

    //setters:

    public void setRelacionadosPorGenero(Filme relacionadosPorGenero) {
        this.relacionadosPorGenero.add(relacionadosPorGenero);
    }

    public void setRelacionadosPorAtor(Filme relacionadosPorAtor) {
        this.relacionadosPorAtor.add(relacionadosPorAtor);
    }

    public void setRelacionadosPorAtor(ArrayList<Filme> relacionadosPorAtor) {
        this.relacionadosPorAtor = relacionadosPorAtor;
    }
    //getters:

    public ArrayList<Filme> getGeneros() {
        return relacionadosPorGenero;
    }

    public ArrayList<Filme> getFilmeatores() {
        return relacionadosPorAtor;
    }

    public Filme getDestino() {
        return destino;
    }
}
