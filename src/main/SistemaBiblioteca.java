package main;

import model.Livro;
import model.Leitor;
import model.Emprestimo;

public class SistemaBiblioteca {
    public static void main(String[] args) {
        Livro livro = new Livro("Introdução à astronomia", "Ana Martins", 2022);
        Leitor leitor = new Leitor("L001", "Maria Silva");

        livro.exibirDetalhes();
        Emprestimo emprestimo = new Emprestimo(leitor, livro);
        System.out.println("Empréstimo de " + emprestimo.getLivro().getTitulo()
                + " para " + emprestimo.getLeitor().getNome()
                + ". Devolução prevista: "
                + emprestimo.getDataDevolucaoPrevista() + ".");
        livro.exibirDetalhes();
        emprestimo.finalizar();
        System.out.println("Empréstimo finalizado.");
        livro.exibirDetalhes();
    }
}
