package service;
import enums.TipoAresta;
import model.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;

public class Recomendador {
    private Grafo grafo;
    private int indiceAtual;
    public Recomendador(Grafo grafo){
        this.grafo = grafo;
    }

    public ArrayList<Filme> recomendarPorDijkstra(Filme origem) {
        Map<Filme, Integer> distancias = grafo.dijkstra(origem);
        // Ordena por menor distância (mais similaridade)
        return  distancias.entrySet().stream()
                .filter(e -> !e.getKey().equals(origem))
                .sorted(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
