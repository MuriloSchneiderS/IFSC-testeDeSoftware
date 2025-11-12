package com.ifsc.tdd_teste;

public class ContaException extends RuntimeException{
    //Construtor com mensagem
    public ContaException(String mensagem) {
        super(mensagem);
    }
}
