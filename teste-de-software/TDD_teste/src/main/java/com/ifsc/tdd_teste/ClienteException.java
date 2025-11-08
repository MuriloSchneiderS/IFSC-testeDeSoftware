package com.ifsc.tdd_teste;

public class ClienteException extends RuntimeException{
    //Construtor com mensagem
    public ClienteException(String mensagem) {
        super(mensagem);
    }
}