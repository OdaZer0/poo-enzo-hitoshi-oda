package model;

public class Revista extends ItemAcervo {
    private final int edicao;

    public Revista(String codigo, String titulo, int anoPublicacao, int edicao) {
        super(codigo, titulo, anoPublicacao);
        if (edicao <= 0) {
            throw new IllegalArgumentException("A edição deve ser positiva.");
        }
        this.edicao = edicao;
    }

    public int getEdicao() {
        return edicao;
    }

    @Override
    public String getTipo() {
        return "Revista";
    }
}
