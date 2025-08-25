package service;
import enums.TipoAresta;
import model.*;

import java.util.*;
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

    public boolean mostrarFilmes(ArrayList<Filme> filmes){
        int amostras = 5;
        if(filmes == null || filmes.isEmpty()){
            return false;
        }

        if(indiceAtual >= filmes.size()){
            return false;
        }

        System.out.println("\n===== Recomendações =====");
        for(int i = indiceAtual; i < indiceAtual + amostras && i<filmes.size() ; i++){
            System.out.println(filmes.get(i));
        }
        indiceAtual += amostras;
        return true;
    }

    public void resetIndiceAtual(){
        this.indiceAtual = 0;
    }

    public ArrayList<Filme> recomendarPorTipo(Filme origem, TipoAresta tipo){
        return grafo.buscaEmLarguraTipo(origem, tipo);
    }
}
