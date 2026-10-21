package main;

import model.Livro;
import model.Leitor;
import model.Emprestimo;
import model.ItemAcervo;
import model.Revista;

public class SistemaBiblioteca {
    public static void main(String[] args) {
        ItemAcervo livro = new Livro(
                "L001", "Introdução à astronomia", 2022, "Ana Martins", 240);
        ItemAcervo revista = new Revista(
                "R001", "Ciência para todos", 2025, 18);
        Leitor leitor = new Leitor("L001", "Maria Silva");

        System.out.println(livro.getTipo() + ": " + livro.getTitulo());
        System.out.println(revista.getTipo() + ": " + revista.getTitulo());
        Emprestimo emprestimo = new Emprestimo(leitor, livro);
        System.out.println("Empréstimo de " + emprestimo.getItem().getTitulo()
                + " para " + emprestimo.getLeitor().getNome()
                + ". Devolução prevista: "
                + emprestimo.getDataDevolucaoPrevista() + ".");
        System.out.println("Disponível? " + livro.isDisponivel());
        emprestimo.finalizar();
        System.out.println("Empréstimo finalizado.");
        System.out.println("Disponível? " + livro.isDisponivel());
    }
}
