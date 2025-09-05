package service;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

import enums.TipoAresta;
import model.Aresta;
import model.Filme;
import model.Grafo;

public class Recomendador {
    private final Grafo grafo;
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
        ArrayList<Filme> recomendados = new ArrayList<>();

            for(Aresta a : grafo.getArestasTipo(origem, TipoAresta.ARESTA_DUPLA)){
                recomendados.add(a.getDestino());
            }
            for(Aresta a : grafo.getArestasTipo(origem, tipo)){
                recomendados.add(a.getDestino());
            }
        return recomendados;
    }

    public void executarRecomendacao(Scanner input, TipoAresta tipo) {
        System.out.println("Digite o nome do filme: ");
        Filme filmeEscolhido = grafo.buscaFilme(input.nextLine());
            if(filmeEscolhido == null){ // caso não ache o filme
                System.out.println("\u001B[31mERRO: [Nome inválido / Filme não encontrado].\u001B[0m");
                System.out.println("1. Tentar novamente");
                System.out.println("2. Voltar ao menu");
                    Scanner escolhido = new Scanner(System.in);
                        int escolha = escolhido.nextInt();
                        escolhido.nextLine();
                            if(escolha == 1) {
                                executarRecomendacao(input, tipo);
                                return;
                            }else if(escolha == 2)
                                return;
                        executarRecomendacao(input, tipo);
                            return;
            }
        resetIndiceAtual();

        ArrayList<Filme> recomendados =
                (tipo == null)
                        ? recomendarPorDijkstra(filmeEscolhido)
                        : recomendarPorTipo(filmeEscolhido, tipo);

        int opcao;
        do {
            if (!mostrarFilmes(recomendados)) {
                System.out.println("Não há mais filmes a serem exibidos com este filtro!");
                break;
            } else {
                System.out.println("\n1. Ver mais recomendações");
                System.out.println("2. Voltar ao menu");
                opcao = input.nextInt();
                input.nextLine();
                if (opcao == 2) System.out.println("Voltando ao menu...");
            }
        } while (opcao != 2);
    }

}
