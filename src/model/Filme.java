package model;

import java.util.ArrayList;

public class Filme {
    private String nome;
    private int ano;
    private String genero;
    private String descricao;
    private ArrayList<String> atores;


    public Filme(String nome, int ano, String genero, String descricao, ArrayList<String> atores) {
        this.atores = atores;
        this.nome = nome;
        this.ano = ano;
        this.genero = genero;
        this.descricao = descricao;
    }


}
