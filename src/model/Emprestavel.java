package model;

public interface Emprestavel {
    int PRAZO_MINIMO_DIAS = 1;

    boolean emprestar();

    boolean devolver();

    boolean isDisponivel();

    int getPrazoEmprestimoDias();
}
