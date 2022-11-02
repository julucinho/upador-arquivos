package org.julucin.upador_arquivo_core.entities.impl.exceptions;

public class NoSuchFileRuntimeException extends RuntimeException{
    public NoSuchFileRuntimeException(String path) {
        super("No such file was found in the following path: '".concat(path).concat("'"));
    }
}
