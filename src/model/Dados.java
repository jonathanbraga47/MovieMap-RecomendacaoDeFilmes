package model;
import model.Grafo;
import java.util.ArrayList;
import java.util.*;

public class Dados {
    ArrayList<Filme> filmes = new ArrayList<>();

    public Dados() {}

    public void adicionarFilmes() {
        ArrayList <String> atores = new ArrayList<>();
        atores.add( "jonathan protagonista");
        atores.add("miria");
        Filme aaa = new Filme("b" , 78378 , "fdjjfd" , "filme muito bom haha", atores);
        Filme destino = new Filme("a",21212 , "dhdhdh" , "dddjsdhjkdkdkj" , atores);
    }

}
