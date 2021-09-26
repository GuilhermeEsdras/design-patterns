package esdras.dev;

public class ProcessadorDeEspacos implements Processador {

    protected Processador sucessor;

    @Override
    public Processador setSucessor(Processador sucessor) {
        this.sucessor = sucessor;
        return sucessor;
    }

    private String texto;

    public ProcessadorDeEspacos(String texto) {
        this.texto = texto;
    }

    @Override
    public Processador processarRequisicao() {
        System.out.println("| Processador de Espaços |");

        int countEspacos = 0;
        for (int c = 0; c < texto.length(); c++) {
            if (texto.charAt(c) == ' ') {
                System.out.printf("Espaço encontrado no caracter %d\n", c);
                countEspacos++;
            }
        }

        System.out.println("Processador de Espaços finalizado!");
        System.out.println("\t> Total de Espaços encontrados: " + countEspacos);
        System.out.println("---");

        return this.sucessor != null ? this.sucessor.processarRequisicao() : this.sucessor;
    }
}
