package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Biblioteca {
    private final Map<String, ItemAcervo> catalogo;
    private final List<Emprestimo> emprestimos;

    public Biblioteca() {
        this.catalogo = new LinkedHashMap<String, ItemAcervo>();
        this.emprestimos = new ArrayList<Emprestimo>();
    }

    public void cadastrarItem(ItemAcervo item) {
        if (item == null) {
            throw new IllegalArgumentException("O item é obrigatório.");
        }
        if (catalogo.containsKey(item.getCodigo())) {
            throw new IllegalArgumentException("Já existe um item com esse código.");
        }
        catalogo.put(item.getCodigo(), item);
    }

    public List<ItemAcervo> listarItens() {
        return Collections.unmodifiableList(
                new ArrayList<ItemAcervo>(catalogo.values()));
    }

    public List<Emprestimo> listarEmprestimosAtivos() {
        List<Emprestimo> ativos = new ArrayList<Emprestimo>();
        for (Emprestimo emprestimo : emprestimos) {
            if (emprestimo.isAtivo()) {
                ativos.add(emprestimo);
            }
        }
        return Collections.unmodifiableList(ativos);
    }

    public Emprestimo emprestar(String codigoItem, Leitor leitor) {
        if (leitor == null) {
            throw new IllegalArgumentException("O leitor é obrigatório.");
        }
        ItemAcervo item = buscarItem(codigoItem);
        Emprestimo emprestimo = new Emprestimo(leitor, item);
        emprestimos.add(emprestimo);
        return emprestimo;
    }

    public Emprestimo devolver(String codigoItem) {
        for (Emprestimo emprestimo : emprestimos) {
            if (emprestimo.isAtivo()
                    && emprestimo.getItem().getCodigo().equals(codigoItem)) {
                emprestimo.finalizar();
                return emprestimo;
            }
        }
        throw new IllegalArgumentException(
                "Não há empréstimo ativo para esse código de item.");
    }

    private ItemAcervo buscarItem(String codigoItem) {
        if (codigoItem == null || codigoItem.trim().isEmpty()) {
            throw new IllegalArgumentException("O código do item é obrigatório.");
        }
        ItemAcervo item = catalogo.get(codigoItem.trim());
        if (item == null) {
            throw new IllegalArgumentException("Item não encontrado no catálogo.");
        }
        return item;
    }
}
