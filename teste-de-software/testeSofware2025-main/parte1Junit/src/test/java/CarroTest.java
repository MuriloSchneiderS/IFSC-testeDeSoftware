import br.edu.ifsc.Carro;
import br.edu.ifsc.CarroException;
import org.junit.jupiter.api.*;

//necessario para utilizar a ordem dos testes que vao executar com o order
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CarroTest {
    private Carro car;

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
        car = new Carro("Opalao");
        System.out.println("===inicio novo teste===");
    }

    @AfterEach
    public void fazDepoisCada() {
        System.out.println("===fim teste===");
    }

    @Test
	@DisplayName("Testa frear com valor negativo")
    @Order(1)
	public void testaFreioNegativo() {
		Assertions.assertThrows(CarroException.class, () -> {
			car.freia(-5);
		});
	}
    //exemplo de teste com mais de uma assertiva
	@Test
	@DisplayName("teste de subida de marcha")
    @Order(0)
    public void testaUpMarcha() {
		car.upMarcha();
		Assertions.assertEquals('1', car.getMarcha());
		
		car.upMarcha();
		car.upMarcha();
		Assertions.assertEquals('3', car.getMarcha());

		car.upMarcha();
		car.upMarcha();
		car.upMarcha();
        Assertions.assertEquals('5', car.getMarcha());
	}
    //exemplo de teste com mais de uma assertiva com o assertAll
	@Test
    @DisplayName("teste de subida de marcha2")
    @Order(3)
    public void testaUpMarcha2() {
        car.upMarcha();
        char gear1 = car.getMarcha();

        car.upMarcha();
        car.upMarcha();
        char gear3 = car.getMarcha();

        car.upMarcha();
        car.upMarcha();
        car.upMarcha();
        char gear5 = car.getMarcha();

        Assertions.assertAll(
                ()-> Assertions.assertEquals('1', gear1),
                ()-> Assertions.assertEquals('3', gear3),
                ()-> Assertions.assertEquals('5', gear5));
    }

}
