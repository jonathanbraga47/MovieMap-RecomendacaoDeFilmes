package model;

import java.util.*;

public class Grafo {
    private Map<Filme, List<Aresta>> adjacencia;

    public Grafo() {
        adjacencia = new HashMap<>();
    }

    // Adiciona um vértice (se ainda não existir)
    public void adicionarVertice(String vertice) {
        adjacencia.putIfAbsent(vertice, new ArrayList<>());
    }

    // Adiciona uma aresta (não direcionada por padrão)
    public void adicionarAresta(String origem, String destino, double peso) {
        adicionarVertice(origem);
        adicionarVertice(destino);

        // Adiciona origem → destino
        if (!existeAresta(origem, destino)) {
            adjacencia.get(origem).add(new Aresta(destino, peso));
        }

        // Adiciona destino → origem (não direcionado)
        if (!existeAresta(destino, origem)) {
            adjacencia.get(destino).add(new Aresta(origem, peso));
        }
    }

    // Verifica se já existe uma aresta entre dois vértices
    private boolean existeAresta(String origem, String destino) {
        return adjacencia.getOrDefault(origem, new ArrayList<>())
                .stream()
                .anyMatch(a -> a.getDestino().equals(destino));
    }

    // Obtém vizinhos de um vértice
    public List<Aresta> getAdjacentes(String vertice) {
        return adjacencia.getOrDefault(vertice, new ArrayList<>());
    }

    // Exibe o grafo
    public void imprimirGrafo() {
        for (String vertice : adjacencia.keySet()) {
            System.out.print(vertice + " -> ");
            System.out.println(adjacencia.get(vertice));
        }
    }
}
