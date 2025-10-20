package com.mycompany.exerciciosjunit;

public class Moto {
    //atributos
    private final String modelo;
    private double velocidade;
    private static final int VEL_FINAL = 150;
    
    public Moto(String modelo) {
        this.modelo = modelo;
        this.velocidade = 0;
    }
    public String getModelo() {
        return this.modelo;
    }
    public double getVelocidade() {
        return this.velocidade;
    }
    //aumenta a velocidade até a velocidade máxima
    public void acelera(int vel) {
        if(vel<0) throw new RuntimeException("vel deve ser positiva");
        if(this.velocidade+vel> VEL_FINAL) this.velocidade=VEL_FINAL; 
        else this.velocidade+=vel;
    }
    //diminui velocidade até parar
    public void freia(int vel) {
        if(this.velocidade-vel<0) this.velocidade = 0;
        else this.velocidade-=vel;
    }
}