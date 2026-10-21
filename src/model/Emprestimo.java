package model;

import java.time.LocalDate;

public class Emprestimo {
    private final Leitor leitor;
    private final ItemAcervo item;
    private final LocalDate dataEmprestimo;
    private final LocalDate dataDevolucaoPrevista;
    private boolean ativo;

    public Emprestimo(Leitor leitor, ItemAcervo item) {
        if (leitor == null || item == null) {
            throw new IllegalArgumentException("Leitor e item são obrigatórios.");
        }
        if (!item.emprestar()) {
            throw new IllegalStateException("O item já está emprestado.");
        }
        this.leitor = leitor;
        this.item = item;
        this.dataEmprestimo = LocalDate.now();
        this.dataDevolucaoPrevista = dataEmprestimo.plusDays(14);
        this.ativo = true;
    }

    public Leitor getLeitor() {
        return leitor;
    }

    public ItemAcervo getItem() {
        return item;
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
        item.devolver();
        ativo = false;
    }
}
