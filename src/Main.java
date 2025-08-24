import model.*;
import service.Recomendador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner input = new Scanner(System.in);
        LerArquivo dados = new LerArquivo("/resources/filmes_brasileiros.csv"); // lê o arquivo csv
        Grafo grafo = dados.getDados(); // cria o grafo
        Recomendador recomendador = new Recomendador(grafo);
        //System.out.println(grafo);
        int opcao;
        do {
            System.out.println("1. Recomendar filmes similares");
            System.out.println("2. Recomendar filmes de mesmo gênero");
            System.out.println("3. Recomendar filmes de mesmos atores");
                opcao = input.nextInt();
                input.nextLine();
            switch (opcao) {
                case 1: {
                    System.out.println("Digite o nome do filme: ");
                    Filme filmeEscolhido = grafo.buscaFilme(input.nextLine());
                    ArrayList<Filme> recomendados = recomendador.recomendarPorDijkstra(filmeEscolhido);
                        for (int j = 0; j < 5; j++) {
                            System.out.println("============================================\n");
                            System.out.println(recomendados.get(j));
                        }
                        int op;
                        do {
                            System.out.println("1.Ver mais recomendações");
                            System.out.println("2. Voltar ao menu");
                            op = input.nextInt();
                            input.nextLine();
                            switch (op) {
                                case 1:
                                    //funcao mostrar mais 5
                                    break;
                                case 2:
                                    break;//volta ao menu
                            }
                        } while (op != 2);
                    break;
                }
                case 2:{
                    System.out.println("Digite o nome do filme: ");
                    Filme filmeEscolhido = grafo.buscaFilme(input.nextLine());
                    break;
                } case 3:{
                    System.out.println("Digite o nome do filme: ");
                    Filme filmeEscolhido = grafo.buscaFilme(input.nextLine());
                    break;
                }
            }
        }while (opcao != 0);
    }
}