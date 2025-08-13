package model;

import java.util.ArrayList;

public class Filme {
    private String nome;
    private int ano;
    private ArrayList<String> generos;
    private ArrayList<Ator> atores;

    public Filme(ArrayList<Ator> atores, String nome, int ano, ArrayList<String> generos) {
        this.atores = atores;
        this.nome = nome;
        this.ano = ano;
        this.generos = generos;
    }


}
