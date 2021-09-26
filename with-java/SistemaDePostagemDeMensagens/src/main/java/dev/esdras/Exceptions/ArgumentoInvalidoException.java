package dev.esdras.Exceptions;

import java.io.IOException;

public class ArgumentoInvalidoException extends RuntimeException {
    public ArgumentoInvalidoException() {
        this("Erro! Argumento inválido!");
    }

    public ArgumentoInvalidoException(String msg) {
        super(msg);
    }
}
