package model;

import java.util.ArrayList;

public class Arestas {
    private ArrayList<Filme> filmes = new ArrayList<>();
    private ArrayList<Ator>  Atores = new ArrayList<>();
    private int peso;


    public Arestas(ArrayList<Filme> filmes, ArrayList<Ator> atores) {

        this.filmes = filmes;
        this.Atores = atores;
        //this.peso = (filmes.size()* x )+(Atores.size()* y);
    }
}
