package model;

import java.util.ArrayList;
import java.util.List;

public class Aresta {
    private List<Filme> FilmesGenero;
    private List<Filme> FilmeAtor;
    private Filme destino;
    private int peso;

    public Aresta() {
        this.FilmesGenero = new ArrayList<>();
        this.FilmeAtor = new ArrayList<>();
    }

    public List<Filme> getGeneros() {
        return FilmesGenero;
    }

    public List<Filme> getFilmeatores() {
        return FilmeAtor;
    }

    }
