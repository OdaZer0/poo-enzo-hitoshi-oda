package main;

import model.Livro;

public class SistemaBiblioteca {
    public static void main(String[] args) {
        Livro livro = new Livro();
        livro.titulo = "Introdução à astronomia";
        livro.autor = "Ana Martins";
        livro.anoPublicacao = 2022;

        livro.exibirDetalhes();
        if (livro.emprestar()) {
            System.out.println("Livro emprestado.");
        }
        livro.exibirDetalhes();
        if (livro.devolver()) {
            System.out.println("Livro devolvido.");
        }
    }
}
