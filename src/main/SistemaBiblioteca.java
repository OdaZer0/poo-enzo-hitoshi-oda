package main;

import java.util.Scanner;
import model.Emprestimo;
import model.ItemAcervo;
import model.Leitor;
import model.Livro;
import model.Revista;
import service.Biblioteca;

public class SistemaBiblioteca {
    public static void main(String[] args) {
        Biblioteca biblioteca = criarBibliotecaExemplo();
        try (Scanner scanner = new Scanner(System.in)) {
            executarMenu(scanner, biblioteca);
        }
    }

    private static Biblioteca criarBibliotecaExemplo() {
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.cadastrarItem(new Livro(
                "L001", "Introdução à astronomia", 2022, "Ana Martins", 240));
        biblioteca.cadastrarItem(new Revista(
                "R001", "Ciência para todos", 2025, 18));
        return biblioteca;
    }

    private static void executarMenu(Scanner scanner, Biblioteca biblioteca) {
        boolean executando = true;
        while (executando) {
            System.out.println("\n=== Biblioteca Comunitária ===");
            System.out.println("1. Listar acervo");
            System.out.println("2. Registrar empréstimo");
            System.out.println("3. Devolver item");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");

            if (!scanner.hasNextLine()) {
                break;
            }
            String entrada = scanner.nextLine().trim();
            try {
                switch (Integer.parseInt(entrada)) {
                    case 1:
                        listarAcervo(biblioteca);
                        break;
                    case 2:
                        registrarEmprestimo(scanner, biblioteca);
                        break;
                    case 3:
                        devolverItem(scanner, biblioteca);
                        break;
                    case 4:
                        executando = false;
                        break;
                    default:
                        System.out.println("Opção inválida.");
                }
            } catch (NumberFormatException exception) {
                System.out.println("Digite o número de uma opção.");
            }
        }
        System.out.println("Até logo!");
    }

    private static void listarAcervo(Biblioteca biblioteca) {
        if (biblioteca.listarItens().isEmpty()) {
            System.out.println("O acervo está vazio.");
            return;
        }
        for (ItemAcervo item : biblioteca.listarItens()) {
            System.out.printf("%s | %s | %s (%d) | %s | prazo: %d dias%n",
                    item.getCodigo(),
                    item.getTipo(),
                    item.getTitulo(),
                    item.getAnoPublicacao(),
                    item.isDisponivel() ? "disponível" : "emprestado",
                    item.getPrazoEmprestimoDias());
        }
    }

    private static void registrarEmprestimo(
            Scanner scanner, Biblioteca biblioteca) {
        System.out.print("Código do item: ");
        String codigoItem = scanner.nextLine().trim();
        System.out.print("Matrícula do leitor: ");
        String matricula = scanner.nextLine().trim();
        System.out.print("Nome do leitor: ");
        String nome = scanner.nextLine().trim();

        try {
            Leitor leitor = new Leitor(matricula, nome);
            Emprestimo emprestimo = biblioteca.emprestar(codigoItem, leitor);
            System.out.println("Empréstimo registrado para "
                    + emprestimo.getLeitor().getNome()
                    + ". Devolução prevista: "
                    + emprestimo.getDataDevolucaoPrevista() + ".");
        } catch (IllegalArgumentException | IllegalStateException exception) {
            System.out.println("Não foi possível registrar: " + exception.getMessage());
        }
    }

    private static void devolverItem(Scanner scanner, Biblioteca biblioteca) {
        System.out.print("Código do item: ");
        String codigoItem = scanner.nextLine().trim();
        try {
            Emprestimo emprestimo = biblioteca.devolver(codigoItem);
            System.out.println("Item devolvido por "
                    + emprestimo.getLeitor().getNome() + ".");
        } catch (IllegalArgumentException | IllegalStateException exception) {
            System.out.println("Não foi possível devolver: " + exception.getMessage());
        }
    }
}
