package model;

import java.time.LocalDate;

public class Emprestimo {
    private final Leitor leitor;
    private final Livro livro;
    private final LocalDate dataEmprestimo;
    private final LocalDate dataDevolucaoPrevista;
    private boolean ativo;

    public Emprestimo(Leitor leitor, Livro livro) {
        if (leitor == null || livro == null) {
            throw new IllegalArgumentException("Leitor e livro são obrigatórios.");
        }
        if (!livro.emprestar()) {
            throw new IllegalStateException("O livro já está emprestado.");
        }
        this.leitor = leitor;
        this.livro = livro;
        this.dataEmprestimo = LocalDate.now();
        this.dataDevolucaoPrevista = dataEmprestimo.plusDays(14);
        this.ativo = true;
    }

    public Leitor getLeitor() {
        return leitor;
    }

    public Livro getLivro() {
        return livro;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public LocalDate getDataDevolucaoPrevista() {
        return dataDevolucaoPrevista;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void finalizar() {
        if (!ativo) {
            throw new IllegalStateException("O empréstimo já foi finalizado.");
        }
        livro.devolver();
        ativo = false;
    }
}
