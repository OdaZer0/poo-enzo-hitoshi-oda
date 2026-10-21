package model;

public class Livro {
    private final String titulo;
    private final String autor;
    private final int anoPublicacao;
    private boolean disponivel;

    public Livro(String titulo, String autor, int anoPublicacao) {
        if (titulo == null || titulo.trim().isEmpty()) {
            throw new IllegalArgumentException("O título é obrigatório.");
        }
        if (autor == null || autor.trim().isEmpty()) {
            throw new IllegalArgumentException("O autor é obrigatório.");
        }
        if (anoPublicacao <= 0) {
            throw new IllegalArgumentException("O ano de publicação deve ser positivo.");
        }
        this.titulo = titulo.trim();
        this.autor = autor.trim();
        this.anoPublicacao = anoPublicacao;
        this.disponivel = true;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

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
