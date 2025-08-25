import enums.TipoAresta;
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
            System.out.println("1. ============ MENU ============");
            System.out.println("1. Recomendar filmes similares");
            System.out.println("2. Recomendar filmes de mesmo gênero");
            System.out.println("3. Recomendar filmes de mesmos atores");
            System.out.println("4. Vizualizar filmes disponíveis");
            System.out.println("5. Vizualizar Grafo");
            System.out.println("0. Fechar programa");
                opcao = input.nextInt();
                input.nextLine();
            switch (opcao) {
                case 1: {
                    System.out.println("Digite o nome do filme: ");
                    Filme filmeEscolhido = grafo.buscaFilme(input.nextLine());
                    recomendador.resetIndiceAtual();
                    ArrayList<Filme> recomendados = recomendador.recomendarPorDijkstra(filmeEscolhido);
                        int op;
                        do {
                            if(!recomendador.mostrarFilmes(recomendados)){
                                System.out.println("Não há mais filmes a serem exibidos!");
                                break;
                            }else {
                                System.out.println("\n1.Ver mais recomendações");
                                System.out.println("2. Voltar ao menu");
                                op = input.nextInt();
                                input.nextLine();
                                switch (op) {
                                    case 1:
                                        //não precisa por a função aqui porque a próxima iteração
                                        //já vai fazer com que o mostrarFilmes exiba os próximos 5
                                        break;
                                    case 2:
                                        System.out.println("Voltando ao menu...");
                                        break;//volta ao menu
                                    default:
                                        System.out.println("Opção inválida!");
                                        break;
                                }
                            }
                        } while (op != 2);
                    break;
                }
                case 2:{
                    System.out.println("Digite o nome do filme: ");
                    Filme filmeEscolhido = grafo.buscaFilme(input.nextLine());
                    recomendador.resetIndiceAtual();
                    ArrayList<Filme> recomendadosPorGenero = recomendador.recomendarPorTipo(filmeEscolhido, TipoAresta.ARESTA_GENERO);
                    int op1;
                    do {
                        if(!recomendador.mostrarFilmes(recomendadosPorGenero)){
                            System.out.println("Não há mais filmes a serem exibidos deste mesmo genero!\n");
                            break;
                        }else {
                            System.out.println("\n1.Ver mais recomendações");
                            System.out.println("2. Voltar ao menu");
                            op1 = input.nextInt();
                            input.nextLine();
                            switch (op1) {
                                case 1:
                                    //não precisa por a função aqui porque a próxima iteração
                                    //já vai fazer com que o mostrarFilmes exiba os próximos 5
                                    break;
                                case 2:
                                    System.out.println("Voltando ao menu...");
                                    break;//volta ao menu
                                default:
                                    System.out.println("Opção inválida!");
                                    break;
                            }
                        }
                    } while (op1 != 2);
                    break;
                } case 3:{
                    System.out.println("Digite o nome do filme: ");
                    Filme filmeEscolhido = grafo.buscaFilme(input.nextLine());
                    recomendador.resetIndiceAtual();
                    ArrayList<Filme> recomendadosPorAtor = recomendador.recomendarPorTipo(filmeEscolhido, TipoAresta.ARESTA_ATOR);
                    int op2;
                    do {
                        if(!recomendador.mostrarFilmes(recomendadosPorAtor)){
                            System.out.println("Não há mais filmes a serem exibidos com atores em comum!");
                            break;
                        }else {
                            System.out.println("\n1.Ver mais recomendações");
                            System.out.println("2. Voltar ao menu");
                            op2 = input.nextInt();
                            input.nextLine();
                            switch (op2) {
                                case 1:
                                    //não precisa por a função aqui porque a próxima iteração
                                    //já vai fazer com que o mostrarFilmes exiba os próximos 5
                                    break;
                                case 2:
                                    System.out.println("Voltando ao menu...");
                                    break;//volta ao menu
                                default:
                                    System.out.println("Opção inválida!");
                                    break;
                            }
                        }
                    } while (op2 != 2);
                    break;
                }
                case 4:
                    System.out.println("\n======= FILME =======");
                    grafo.listarFilmes();
                    break;
                case 5:
                    System.out.println(grafo);
                    break;
                case 0:
                    System.out.println("Encerrando porgrama...");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }while (opcao != 0);
    }
}