package com.ifsc.tdd_teste;

public class Intervalo {
    int segundos;
    public Intervalo(int horas, int minutos, int segundos){
        this.segundos = segundos + minutos*60 + horas*3600;    
    }
    
    public int horas(){
        return this.segundos/3600;
    }
    public int minutos(){
        return this.segundos%3600/60;
    }
    public int totalMinutos(){
        return this.segundos/60;
    }
    public int segundos(){
        return this.segundos%60;
    }
}
