package com.ifsc.tdd_teste;

public class Conta {
    private double saldo, limite;
    public Conta(double saldo, double limite){
        this.saldo = saldo;
        this.limite = limite;
    }
    
    public double sacar(double quantia){
        if(quantia<0)
            throw new ContaException("quantia deve ser positiva.");
        if(quantia>saldo+limite)
            return 0;
        this.saldo -= quantia;
        return quantia;
    }
    public double depositar(double quantia){
        if(quantia<0)
            throw new ContaException("deposito deve ser positivo.");
        return this.saldo += quantia;
    }
    public Conta transferir(Conta destino, double quantia){
        if(destino==null)
            throw new ContaException("conta destino nao pode ser nula.");
        if(quantia<0)
            throw new ContaException("transferencia deve ser positiva.");
        if(quantia>saldo+limite)
            throw new ContaException("saldo da conta de origem insuficiente.");
        
        this.saldo -= quantia;
        destino.saldo += quantia;
        
        return new Conta(destino.saldo, destino.limite);
    }

    public double getSaldo() {
        return saldo;
    }
    public void setLimite(double quantia){
        if(quantia<0)
            throw new ContaException("limite deve ser positivo.");
        this.limite = quantia;
    }
}
/*
1) deve ser possível sacar uma determinada quantia da conta, o método retorna o valor sacado.
1.1) Essa quantia deve ser sempre positiva, do contrario exception não verificada deve ser lançada(ContaException)
1.2) Essa quantia deve ser menor que o saldo + o limite da conta para que o saque seja possível,
caso o saque não seja possível o valor retornado será 0.

2) deve ser possível depositar um valor positivo na conta. Será retornado o saldo final após o depósito.
2.1) Caso o valor não seja positivo, deve-se lançar uma ContaException.

3) deve ser possível alterar o limite de uma conta para um novo valor que não seja negativo.
3.1)caso valor negativo deve ser lançada uma ContaException

4) deve ser possível transferir uma determinada quantidade positiva da conta de um cliente para a conta de outro cliente.
4.1) a quantidade deve ser positiva
4.2) a conta não deve ser nula
4.3) somando-se o saldo com o limite da conta de origem, não se pode obter um valor negativo
4.4) caso algum desses casos aconteça gere uma ContaException)
*/