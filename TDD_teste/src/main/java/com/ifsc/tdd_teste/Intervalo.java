package com.ifsc.tdd_teste;

public class Intervalo {
    int segundos;
    public Intervalo(int horas, int minutos, int segundos){
        if (horas < 0 || minutos < 0 || segundos < 0)
            throw new IllegalArgumentException("Valores negativos não são permitidos.");
        this.segundos = segundos + minutos*60 + horas*3600;
    }
    
    public int horas(){
        return this.segundos/3600;
    }
    public int minutos(){
        return (this.segundos%3600)/60;
    }
    public int totalMinutos(){
        return this.segundos/60;
    }
    public int segundos(){
        return this.segundos%60;
    }
    
    public Intervalo somaIntervalos(Intervalo outro){
        return new Intervalo(0, 0, this.segundos+outro.segundos);//Retorna um novo Intervalo com o total de segundos
    }
    public Intervalo subtraiIntervalo(Intervalo outro){
        int totalSegundos = this.segundos - outro.segundos;
        if (totalSegundos<0)
            throw new RuntimeException("Resultado negativo.");
        return new Intervalo(0, 0, totalSegundos);
    }
    @Override
    public boolean equals(Object obj){
        if (this == obj)//Se são o mesmo objeto
            return true;
        if (!(obj instanceof Intervalo))//Se o objeto não é da classe Intervalo
            return false;
        Intervalo outro = (Intervalo) obj;//Cast Object->Intervalo
        return this.segundos == outro.segundos;//Compara os segundos
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d:%02d", horas(), minutos(), segundos());
    }
}
/*Programe a Classe Intervalo (que representa um intervalo de tempo em horas, minutos e segundos).
1) deve ser possível criar um objeto passando 3 valores inteiros referentes as horas, minutos e
segundos, porém pode-se passar, por exemplo, mais que 59 segundos e 59 minutos.
2) deve ser possível consultar quantas horas possui o intervalo. 
O valor inteiro que representa as horas
3) deve ser possível consultar quantos minutos possui o intervalo
(por exemplo 2h40min10s possui 40 min – retornar 40). De 0 a 59.
4) deve ser possível consultar o total de minutos que o intervalo possui
(por exemplo 2h40min10s possui 160 min – retornar 160).
5) deve ser possível consultar quantos segundos possui o intervalo
(por exemplo, 2h40min10s possui 10s – retorna 10). De 0 a 59.
6) deve ser possível consultar o total de segundos que o intervalo possui 
(por exemplo, 2h40min10 possui 9610s – retorna 9610)
7) deve ser possível somar um novo intervalo ao intervalo e como ele é imutável o resultado deve
ser retornado. Exemplo: um intervalo de 10s somado a um intervalo de 15s deve retornar um
intervalo de 25s.
8) deve ser possível diminuir um intervalo de outro e o resultado deverá ser retornado. Considere
que um intervalo não pode ser negativo e portanto uma IntervaloException deve ser lançada.
*perceba que talvez faça sentido refatorar o seu construtor...
8) deve ser possível verificar se dois intervalos são iguais ou não
9) deve ser possível retornar um texto no seguinte formato “HH:MM:SS” para cada intervalo.

OBS: Dica, utilize um único atributo para guardar o tempo em segundos. Por exemplo: para 1:32:24
pode ser armazenado pela quantidade de segundos: 1h*60*60 + 32min*60+24s. Caso não tenha
implementado assim considere refatorar e rodar os testes novamente, os comportamentos não
podem mudar.
*/