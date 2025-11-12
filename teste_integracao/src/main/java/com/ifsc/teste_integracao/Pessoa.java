package com.ifsc.teste_integracao;

import java.time.LocalDate;

public class Pessoa{
    private int id;
    private String nome;
    private LocalDate dataNasc;

    public Pessoa(int id, String nome, LocalDate dataNasc) {
        this.nome = nome;
        this.id = id;
        this.dataNasc = dataNasc;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public LocalDate getDataNasc(){
        return dataNasc;
    }

    public void setDataNasc(LocalDate dataNasc){
        this.dataNasc = dataNasc;
    }
}
//Pessoa: atributos: nome, id, dataNasc (LocalDate). Faça getters e setters e Construtor