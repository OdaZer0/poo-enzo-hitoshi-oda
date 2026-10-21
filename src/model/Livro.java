package model;

public class Livro {
    public String titulo;
    public String autor;
    public int anoPublicacao;
    public boolean disponivel = true;

    public void exibirDetalhes() {
        System.out.println(titulo + " - " + autor + " (" + anoPublicacao + ") | "
                + (disponivel ? "disponível" : "emprestado"));
    }

    public boolean emprestar() {
        if (!disponivel) {
            return false;
        }
        disponivel = false;
        return true;
    }

    public boolean devolver() {
        if (disponivel) {
            return false;
        }
        disponivel = true;
        return true;
    }
}
