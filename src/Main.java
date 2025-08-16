import enums.TipoAresta;
import model.*;
import java.util.*;
public class Main {
    public static void main(String[] args) {

        Grafo grafo = new Grafo();
        ArrayList <String> atores = new ArrayList<>();
        atores.add( "jonathan protagonista");
        atores.add("miria");
        Filme aaa = new Filme("b" , 78378 , "fdjjfd" , "filme muito bom haha", atores);
        Filme destino = new Filme("a",21212 , "dhdhdh" , "dddjsdhjkdkdkj" , atores);

        grafo.adicionarAresta(aaa, destino, TipoAresta.ARESTA_ATOR, 23);

        if(grafo.existeAresta(aaa, destino, TipoAresta.ARESTA_ATOR)) {
            System.out.println("Aresta ator existe");
        }else {
            System.out.println("Aresta ator não existe");
        }
        if(grafo.existeAresta(aaa, destino, TipoAresta.ARESTA_GENERO))
            System.out.println("Aresta genero existe");
        else {
            System.out.println("Aresta genero não existe");
        }
        //grafo.imprimirGrafo();
        }

    }