package model;

public class Livro {
    public String titulo;
    public String autor;
    public int anoPublicacao;

    public void exibirDetalhes() {
        System.out.println(titulo + " — " + autor + " (" + anoPublicacao + ")");
    }
}
