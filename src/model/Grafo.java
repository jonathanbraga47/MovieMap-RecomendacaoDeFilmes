package model;
import java.util.ArrayList;

public class Grafo {
    private ArrayList<Filme> vertices;
    private ArrayList<Arestas> arestas;

    public Grafo(){
        this.vertices = new ArrayList<>();
        this.arestas = new ArrayList<>();
    }


    public void adicionarAresta(String origem, String destino, double peso) {
        adjacencia.computeIfAbsent(origem, k -> new ArrayList<>())
                .add(new Aresta(destino, peso));
    }

    public List<Aresta> getAdjacentes(String vertice) {
        return adjacencia.getOrDefault(vertice, new ArrayList<>());
    }
}
