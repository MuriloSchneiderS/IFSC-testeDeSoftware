import com.mycompany.exerciciosjunit.Moto;
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
        //Acelera até 50
        moto.acelera(50);
        double velocidade50 = moto.getVelocidade();
        
        //Acelera até 100
        moto.acelera(50);
        double velocidade100 = moto.getVelocidade();
        
        //Freia para 70
        moto.freia(30);
        double velocidade70 = moto.getVelocidade();
        
        //Freia para 0
        moto.freia(100);
        double velocidade0 = moto.getVelocidade();
        
        Assertions.assertAll(
                () -> assertEquals(50.0, velocidade50),
                () -> assertEquals(100.0, velocidade100),
                () -> assertEquals(70.0, velocidade70),
                () -> assertEquals(0.0, velocidade0)
        );
    }

    @Test
    @DisplayName("Teste Acelera com velocidade negativa.")
    @Order(1)
    void testaAceleraComVelocidadeNegativa() {
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            moto.acelera(-10);
        });//Guarda mensagem de erro disparada ao acelerar com valor negativo
        assertEquals("vel deve ser positiva", exception.getMessage());
    }

    @Test
    @DisplayName("Teste Freia mais que velocidade atual")
    @Order(2)
    void testaFreiaMaisQueVelocidadeAtual() {
        moto.acelera(30);
        moto.freia(40);//Tenta freiar mais do que a velocidade atual
        assertEquals(0.0, moto.getVelocidade(), 0.01);//Deve parar
    }
}
/*
    Implemente um conjunto de testes usando Junit5 (classe MotoTest) que valide os métodos acelera() e freia()

    Implemente um método que inicializa um objeto de Moto que deve ser utilizado antes de cada teste

    Na classe Moto, Crie dois atributos, uma constante TAMANHO_TAQUE com valor de 30 e outro com a quantidade de gasolina no tanque.

    Na classe Moto, Implemente o método abastecer que recebe um double e incrementa a gasolina no tanque. Gere uma excection não verificada caso o parâmetro seja negativo.

    Altere o método acelerar para gastar 0.01L de gasolina para cada km/h acelerado. Caso a gasolina acabe deve parar de acelerar.

    Faça os testes para os métodos abastecer e acelerar

    Parte2: Considerando os exercícios sobre revisão de POO (item 2.2) 
    faça uma classe de teste (Junit5) para cada grupo de teste do arquivo passado como parâmetro, 
    garanta que os testes executem na mesma ordem do arquivo TestaApp
*/