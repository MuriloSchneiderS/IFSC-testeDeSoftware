package com.ifsc.tdd_teste;

public class ClienteException extends RuntimeException{
    //Construtor com mensagem
    public ClienteException(String mensagem) {
        super(mensagem);
    }

    //Construtor com mensagem e causa
    public ClienteException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}
