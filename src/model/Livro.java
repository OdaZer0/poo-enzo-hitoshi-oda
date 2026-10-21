package model;

public class Livro extends ItemAcervo {
    private final String autor;
    private final int quantidadePaginas;

    public Livro(String codigo, String titulo, int anoPublicacao,
                 String autor, int quantidadePaginas) {
        super(codigo, titulo, anoPublicacao);
        if (autor == null || autor.trim().isEmpty()) {
            throw new IllegalArgumentException("O autor é obrigatório.");
        }
        if (quantidadePaginas <= 0) {
            throw new IllegalArgumentException("A quantidade de páginas deve ser positiva.");
        }
        this.autor = autor.trim();
        this.quantidadePaginas = quantidadePaginas;
    }

    public String getAutor() {
        return autor;
    }

    public int getQuantidadePaginas() {
        return quantidadePaginas;
    }

    @Override
    public int getPrazoEmprestimoDias() {
        return 14;
    }

    @Override
    public String getTipo() {
        return "Livro";
    }
}
