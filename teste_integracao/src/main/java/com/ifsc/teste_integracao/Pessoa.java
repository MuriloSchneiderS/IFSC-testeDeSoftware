package com.ifsc.teste_integracao;

import java.time.LocalDate;
import java.util.Objects;

public class Pessoa{
    private int id;
    private String nome;
    private LocalDate dataNasc;

    public Pessoa(int id, String nome, LocalDate dataNasc) {
        this.id = id;
        this.nome = nome;
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
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return id == pessoa.id;
    }
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
//Pessoa: atributos: nome, id, dataNasc (LocalDate). Faça getters e setters e Construtor