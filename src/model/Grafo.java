package model;

import java.util.*;

public class Grafo {
    private Map<Filme, List<Aresta>> adjacencia = new HashMap<>();

    // Adiciona um vértice (se ainda não existir)
    public void adicionarVertice(Filme vertice) {
        adjacencia.putIfAbsent(vertice, new ArrayList<>());
    }

    // Adiciona uma aresta (não direcionada por padrão)
    public void adicionarAresta(Filme origem, Filme destino, int fator, int peso) {
        adicionarVertice(origem);
        adicionarVertice(destino);

        // Adiciona origem → destino
        if (!existeAresta(origem, destino)) {
            adjacencia.get(origem).add(new Aresta(destino, fator, peso));
        }

        // Adiciona destino → origem (não direcionado)
        if (!existeAresta(destino, origem)) {
            adjacencia.get(destino).add(new Aresta(origem, fator ,peso));
        }
    }

    // Verifica se já existe uma aresta entre dois vértices
    private boolean existeAresta(Filme origem, Filme destino) {
        return adjacencia.getOrDefault(origem, new ArrayList<>())
                .stream()
                .anyMatch(a -> a.getDestino().equals(destino));
    }

    // Obtém vizinhos de um vértice
    public List<Aresta> getAdjacentes(Filme vertice) {
        return adjacencia.getOrDefault(vertice, new ArrayList<>());
    }

    // Exibe o grafo
    public void imprimirGrafo() {
        for (Filme vertice : adjacencia.keySet()) {
            System.out.print(vertice + " -> ");
            System.out.println(adjacencia.get(vertice));
        }
    }
}
