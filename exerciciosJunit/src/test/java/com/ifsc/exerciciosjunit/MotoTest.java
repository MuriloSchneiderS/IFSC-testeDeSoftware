package com.ifsc.exerciciosjunit;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MotoTest {
    private Moto moto;
    
    @BeforeAll
    public static void fazAntes() {
        System.out.println("-inicio testes-");
    }
    @AfterAll
    public static void fazDepois() {
        System.out.println("-fim testes-");
    }
    @BeforeEach
    public void fazAntesCada() {
        moto = new Moto("Yamaha");
        System.out.println("===inicio novo teste===");
    }
    @AfterEach
    public void fazDepoisCada() {
        System.out.println("===fim teste===");
    }
    
    @Test
    @DisplayName("Teste do metodo acelera()")
    @Order(0)
    void testaAceleraEFreia() {
        //acelera sem combustivel
        moto.acelera(Moto.getVEL_FINAL());
        double velocidade0 = moto.getVelocidade();
        
        //garante tanque cheio
        moto.abastecer(moto.getTAMANHO_TANQUE());
        
        //acelera ate 50
        moto.acelera(50);
        double velocidade50 = moto.getVelocidade();
        
        //acelera ate 100
        moto.acelera(50);
        double velocidade100 = moto.getVelocidade();
        
        //acelera mais que o maximo
        moto.acelera(Moto.getVEL_FINAL()+100);
        double velocidadeMaxima = moto.getVelocidade();//150
        
        //freia para 70
        moto.freia(80);
        double freaPara70 = moto.getVelocidade();
        
        //freia para 0
        moto.freia(150);
        double freioMaximo = moto.getVelocidade();
        
        Assertions.assertAll(
                () -> assertEquals(0.0, velocidade0),
                () -> assertEquals(50.0, velocidade50),
                () -> assertEquals(100.0, velocidade100),
                () -> assertEquals(Moto.getVEL_FINAL(), velocidadeMaxima),
                () -> assertEquals(70.0, freaPara70),
                () -> assertEquals(0.0, freioMaximo)
        );
    }

    @Test
    @DisplayName("Teste Acelera com velocidade negativa.")
    @Order(1)
    void testaAceleraComVelocidadeNegativa() {
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            moto.acelera(-10);
        });//guarda mensagem de erro de acelerar com valor negativo
        assertEquals("vel deve ser positiva", exception.getMessage());
    }

    @Test
    @DisplayName("Teste Freia mais que velocidade atual")
    @Order(2)
    void testaFreiaMaisQueVelocidadeAtual() {
        moto.acelera(30);
        moto.freia(40);//tenta freiar mais do que a velocidade atual
        assertEquals(0.0, moto.getVelocidade(), 0.01);//deve parar
    }
    
    @Test
    @DisplayName("Teste do metodo abastecer()")
    @Order(3)
    void testaAbastecer(){
        //abastece negativo
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                ()->{
                    moto.abastecer(-50);
                }
        );//guarda a mensagem de erro de abastecer negativo
        
        //esvazia o tanque
        moto.abastecer(1);
        moto.acelera(100);
        double tanque0 = moto.getTanque();
        
        //abastece 25
        moto.abastecer(25);
        double tanque25 = moto.getTanque();
        
        //gasta 1L
        moto.acelera(100);//100*0.01 = 1
        double tanque24 = moto.getTanque();
        
        //abastece mais do que o maximo(TAMANHO_TANQUE=30)
        moto.abastecer(5000);
        double abasteceMaisQueTanque = moto.getTanque();
        
        Assertions.assertAll(
                () -> assertEquals("A quantidade de combustivel não pode ser negativa.", exception.getMessage()),
                () -> assertEquals(0.0, tanque0),
                () -> assertEquals(25.0, tanque25),
                () -> assertEquals(24.0, tanque24),
                () -> assertEquals(moto.getTAMANHO_TANQUE(), abasteceMaisQueTanque)
        );
    }
}
/*
Implemente um conjunto de testes usando Junit5 (classe MotoTest) que valide 
os métodos acelera() e freia()

Implemente um método que inicializa um objeto de Moto que deve ser utilizado antes de cada teste

Faça os testes para os métodos abastecer e acelerar

Parte2: Considerando os exercícios sobre revisão de POO (item 2.2) 
faça uma classe de teste (Junit5) para cada grupo de teste do arquivo passado como parâmetro, 
garanta que os testes executem na mesma ordem do arquivo TestaApp
*/