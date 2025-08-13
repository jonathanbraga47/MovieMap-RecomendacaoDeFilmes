package model;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Arquivo {
    private int nVertices;
    private int nArestas;
    ArrayList<String> arrayVertices = new ArrayList<>();
    ArrayList<String> arrayArestas = new ArrayList<>();


    public Arquivo(String caminhoArquivo) {
        try {
            FileReader arquivo = new FileReader(caminhoArquivo);
            BufferedReader buffer = new BufferedReader(arquivo);
            nVertices = Integer.parseInt(buffer.readLine());
            nArestas = Integer.parseInt(buffer.readLine());

            for(int i = 0; i < nVertices; i++) {
                arrayVertices.add(buffer.readLine());
            }

            for(int i = 0; i < nArestas; i++) {
                arrayArestas.add(buffer.readLine());
            }

            buffer.close();

        } catch (IOException e) {
            System.out.println("Erro ao abrir o arquivo: " + e.getMessage());
        }
    }

    public int getnArestas() {
        return nArestas;
    }

    public int getnVertices() {
        return nVertices;
    }

    public ArrayList<String> getArrayVertices() {
        return arrayVertices;
    }

    public ArrayList<String> getArrayArestas() {
        return arrayArestas;
    }
}
