package esdras.dev;

public class ProcessadorDeLetrasA implements Processador {

    protected Processador sucessor;

    @Override
    public Processador setSucessor(Processador sucessor) {
        this.sucessor = sucessor;
        return sucessor;
    }

    private String texto;

    public ProcessadorDeLetrasA(String texto) {
        this.texto = texto;
    }

    @Override
    public Processador processarRequisicao() {
        System.out.println("| Processador de Letras A |");

        int countLetrasA = 0;
        String textoLower = texto.toLowerCase();
        for (int c = 0; c < texto.length(); c++) {
            if (textoLower.charAt(c) == 'a') {
                System.out.printf("Letra A encontrada no caracter %d\n", c);
                countLetrasA++;
            }
        }

        System.out.println("Processador de Letras A finalizado!");
        System.out.println("\t> Total de Letras A encontradas: " + countLetrasA);
        System.out.println("---");

        return this.sucessor != null ? this.sucessor.processarRequisicao() : this.sucessor;
    }
}
