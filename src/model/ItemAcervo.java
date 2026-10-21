package model;

public abstract class ItemAcervo {
    private final String codigo;
    private final String titulo;
    private final int anoPublicacao;
    private boolean disponivel;

    protected ItemAcervo(String codigo, String titulo, int anoPublicacao) {
        if (codigo == null || codigo.trim().isEmpty()) {
            throw new IllegalArgumentException("O código é obrigatório.");
        }
        if (titulo == null || titulo.trim().isEmpty()) {
            throw new IllegalArgumentException("O título é obrigatório.");
        }
        if (anoPublicacao <= 0) {
            throw new IllegalArgumentException("O ano de publicação deve ser positivo.");
        }
        this.codigo = codigo.trim();
        this.titulo = titulo.trim();
        this.anoPublicacao = anoPublicacao;
        this.disponivel = true;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public boolean isDisponivel() {
        return disponivel;
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

    public abstract String getTipo();
}
