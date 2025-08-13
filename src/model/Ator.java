package model;

import java.util.ArrayList;

public class Ator {
    String nome;
    ArrayList<Filme> filmes;

    public Ator(String nome){
        this.nome = nome;
        this.filmes = new ArrayList<>();
    }
}
