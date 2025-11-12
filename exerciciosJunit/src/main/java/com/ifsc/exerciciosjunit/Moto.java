package com.ifsc.exerciciosjunit;

public class Moto {
    //atributos
    private final String modelo;
    private double velocidade;
    private static final int VEL_FINAL = 150;
    
    private final int TAMANHO_TANQUE = 30;
    private double tanque;
    
    public Moto(String modelo) {
        this.modelo = modelo;
        this.velocidade = 0;
        this.tanque = 0;
    }
    public String getModelo() {
        return this.modelo;
    }
    public static int getVEL_FINAL() {
        return VEL_FINAL;
    }
    public double getVelocidade() {
        return this.velocidade;
    }
    public int getTAMANHO_TANQUE() {
        return TAMANHO_TANQUE;
    }
    public double getTanque() {
        return tanque;
    }
    //aumenta a velocidade até a velocidade máxima
    //~Altere o método acelerar para gastar 0.01L de gasolina para cada km/h acelerado. Caso a gasolina acabe deve parar de acelerar.
    public void acelera(int vel) {
        if(vel<0) 
            throw new RuntimeException("vel deve ser positiva");
        
        this.tanque -= 0.01*vel;
        
        if(this.velocidade+vel> VEL_FINAL) 
            this.velocidade=VEL_FINAL; 
        else 
            this.velocidade+=vel;
        
        if(tanque <= 0){
            tanque = 0;
            this.velocidade = 0;
        }
    }
    //diminui velocidade até parar
    public void freia(int vel) {
        if(this.velocidade-vel<0) 
            this.velocidade = 0;
        else 
            this.velocidade-=vel;
    }
    //~abastecer que recebe um double e incrementa a gasolina no tanque.
    //~~Gere uma exception não verificada caso o parametro seja negativo.
    public void abastecer(double combustivel) {
        if(combustivel < 0)
            throw new IllegalArgumentException("A quantidade de combustivel não pode ser negativa.");
        
        if(combustivel+this.tanque>TAMANHO_TANQUE)
            this.tanque = TAMANHO_TANQUE;
        else
            this.tanque += combustivel;
    }
}
/*
Na classe Moto, Crie dois atributos, uma constante TAMANHO_TAQUE com valor de 30
e outro com a quantidade de gasolina no tanque.

Na classe Moto, Implemente o método abastecer que recebe um double e incrementa 
a gasolina no tanque. Gere uma excection não verificada caso o parâmetro seja negativo.

Altere o método acelerar para gastar 0.01L de gasolina para cada km/h acelerado. 
Caso a gasolina acabe deve parar de acelerar.
*/