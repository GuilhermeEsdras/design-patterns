package esdras.dev;

public interface Processador {
    Processador processarRequisicao();
    Processador setSucessor(Processador sucessor);
}
