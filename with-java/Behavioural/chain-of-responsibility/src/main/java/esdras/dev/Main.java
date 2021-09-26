package esdras.dev;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Digite o texto: ");
        String texto = input.nextLine();

        // O texto é passado como argumento do construtor, pois, dessa forma, cada processador pode ter os seus próprios atributos para processar
        Processador processador = new ProcessadorDeEspacos(texto);

        processador
                .setSucessor(new ProcessadorDeLetrasA(texto))
                .setSucessor(new ProcessadorDePontos(texto));
        // Se aparecesse outros Processadores sucessores amanhã, era só setar o próximo, e depois o próximo, e assim por diante...
        // Dessa forma a ordem de processamento também é flexibilizada, podendo ser alterada

        processador.processarRequisicao();
    }
}
