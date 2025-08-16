package model;
import enums.TipoAresta;

import java.net.StandardSocketOptions;
import java.util.*;

public class Grafo {
    private Map<String, Filme> adjacencia;

    public Grafo(){
        this.adjacencia = new HashMap<>();
    }
    // Adiciona um vértice (se ainda não existir)
    public void adicionarVertice(Filme filme) {
        adjacencia.putIfAbsent(filme.getNome(), filme);
    }

    // Adiciona uma aresta (não direcionada por padrão)
    public void adicionarAresta(Filme origem, Filme destino, TipoAresta tipo, int peso ) {
        adicionarVertice(origem);
        adicionarVertice(destino);


        // Adiciona origem → destino
        if (!existeAresta(origem, destino, tipo)) {
            Aresta aresta = new Aresta(destino, tipo, peso);
            adjacencia.get(origem.getNome()).addAresta(aresta, tipo);
        }

        // Adiciona destino → origem (não direcionado)
        if (!existeAresta(destino, origem, tipo)) {
            Aresta aresta2 = new Aresta(origem, tipo, peso);
            adjacencia.get(destino.getNome()).addAresta(aresta2, tipo); //ajeitar
        }
    }

    public boolean existeAresta(Filme origem, Filme destino, TipoAresta tipo) {
        if(adjacencia.get(origem.getNome()) == null) {
            return false;
        }
        return adjacencia.get(origem.getNome())
                .getRelacionados(tipo)
                .stream()
                .anyMatch(a -> a.getDestino().equals(destino));
    }

    public void imprimirGrafo() {
        /*for(int i = 0; i < adjacencia.size(); i++){
            System.out.println("vertice: " + adjacencia.get("a").getNome());
           // System.out.println("arestas: " + adjacencia.get("a").);
        }*/
        for(Filme vertice : adjacencia.values()){
            System.out.println(vertice.getNome());
            System.out.println("Arestas de ator:");
            for(Aresta a: vertice.getRelacionados(TipoAresta.ARESTA_ATOR)){
                System.out.println(a.getDestino());
            }
            System.out.println("Arestas de genero:");
            for(Aresta a: vertice.getRelacionados(TipoAresta.ARESTA_GENERO)){
                System.out.println(a.getDestino());
            }

        }
    }
}

