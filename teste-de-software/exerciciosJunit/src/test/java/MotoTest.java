import com.mycompany.exerciciosjunit.Moto;
import org.junit.jupiter.api.*;

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
        moto = new Moto("motoTeste");
        System.out.println("===inicio novo teste===");
    }
    @AfterEach
    public void fazDepoisCada() {
        System.out.println("===fim teste===");
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