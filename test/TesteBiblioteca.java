package test;

import java.time.temporal.ChronoUnit;
import model.Emprestimo;
import model.Livro;
import model.Leitor;
import model.Revista;
import service.Biblioteca;

public class TesteBiblioteca {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Livro livro = new Livro("L001", "Livro de teste", 2024, "Autor", 100);
        Revista revista = new Revista("R001", "Revista de teste", 2025, 1);
        Leitor leitor = new Leitor("M001", "Leitor de teste");
        biblioteca.cadastrarItem(livro);
        biblioteca.cadastrarItem(revista);

        Emprestimo emprestimoLivro = biblioteca.emprestar("L001", leitor);
        assert !livro.isDisponivel();
        assert emprestimoLivro.getLeitor() == leitor;
        assert ChronoUnit.DAYS.between(
                emprestimoLivro.getDataEmprestimo(),
                emprestimoLivro.getDataDevolucaoPrevista()) == 14;
        assert biblioteca.listarEmprestimosAtivos().size() == 1;
        esperarFalha(() -> biblioteca.emprestar("L001", leitor));

        biblioteca.devolver("L001");
        assert livro.isDisponivel();
        assert biblioteca.listarEmprestimosAtivos().isEmpty();
        esperarFalha(() -> biblioteca.devolver("L001"));

        Emprestimo emprestimoRevista = biblioteca.emprestar("R001", leitor);
        assert ChronoUnit.DAYS.between(
                emprestimoRevista.getDataEmprestimo(),
                emprestimoRevista.getDataDevolucaoPrevista()) == 7;
        esperarFalha(() -> biblioteca.cadastrarItem(
                new Revista("R001", "Código duplicado", 2025, 2)));
        esperarFalha(() -> new Leitor("", "Nome sem matrícula"));

        System.out.println("Testes da biblioteca concluídos com sucesso.");
    }

    private static void esperarFalha(Runnable acao) {
        boolean falhou = false;
        try {
            acao.run();
        } catch (IllegalArgumentException | IllegalStateException exception) {
            falhou = true;
        }
        assert falhou : "Era esperado que a operação inválida falhasse.";
    }
}
