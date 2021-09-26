package esdras.dev;

public class ProcessadorDePontos implements Processador {

    protected Processador sucessor;

    @Override
    public Processador setSucessor(Processador sucessor) {
        this.sucessor = sucessor;
        return sucessor;
    }

    private String texto;

    public ProcessadorDePontos(String texto) {
        this.texto = texto;
    }

    @Override
    public Processador processarRequisicao() {
        System.out.println("| Processador de Pontos |");

        int countPontos = 0;
        for (int c = 0; c < texto.length(); c++) {
            if (texto.charAt(c) == '.') {
                System.out.printf("Ponto encontrado no caracter %d\n", c);
                countPontos++;
            }
        }

        System.out.println("Processador de Pontos finalizado!");
        System.out.println("\t> Total de Pontos encontrados: " + countPontos);
        System.out.println("---");

        return this.sucessor != null ? this.sucessor.processarRequisicao() : this.sucessor;
    }
}
