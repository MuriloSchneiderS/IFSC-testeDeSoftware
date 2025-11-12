import org.junit.jupiter.api.*;
import com.ifsc.tdd_teste.Intervalo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class IntervaloTest {
    private final Intervalo intervalo = new Intervalo(3,4,5);
    private final Intervalo intervalo2 = new Intervalo(6,7,8);
    
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
        System.out.println("===inicio novo teste===");
    }
    @AfterEach
    public void fazDepoisCada() {
        System.out.println("===fim teste===");
    }
    //Testes
    @Test
    @DisplayName("Testes de interação entre intervalos.")
    public void testaIntervalos(){
        //Soma +
        Assertions.assertEquals("09:11:13" , intervalo.somaIntervalos(intervalo2).toString());
        //Subtracao >-<
        Assertions.assertEquals("03:03:03", intervalo2.subtraiIntervalo(intervalo).toString());
        //Subtracao <->
        RuntimeException exception = assertThrows(RuntimeException.class, ()->{
            intervalo.subtraiIntervalo(intervalo2);
        });//guarda mensagem de erro de subtrair intervalo maior do menor
        assertEquals("Resultado negativo.", exception.getMessage());
        //Comparacao ==
        Assertions.assertEquals(false, intervalo.equals(intervalo2));
    }
    @Test
    @DisplayName("Testa criação de intervalo com valor negativo.")
    void testValoresNegativos() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, ()->{
            new Intervalo(-1, 0, 10);
        });
        assertEquals("Valores negativos não são permitidos.", exception.getMessage());
    }
    @Test
    @DisplayName("Testes das funções de retorno de horas, minutos e segundos do intervalo.")
    public void testaGetters(){
        Assertions.assertEquals(3, intervalo.horas());
        Assertions.assertEquals(4, intervalo.minutos());
        Assertions.assertEquals(5, intervalo.segundos());
        Assertions.assertEquals("03:04:05", intervalo.toString());
    }
    @Test
    @DisplayName("Total de minutos do intervalo.")
    public void testaTotalMinutos(){
        Assertions.assertEquals(184, intervalo.totalMinutos());
    }
}
/*
Para os exercícios considere boas práticas de programação, principalmente para codar os testes.
Considere a possibilidade utilizar atributos na classe de teste, métodos separados que não são testes
(com as annotations) caso necessário e os recursos da biblioteca Junit5.

Para Implementar os exercícios considere a prática do TDD
1º – Falhar: Criar o teste (que deve falhar)
2º – Passar: Criar a solução mais simples (lembre-se dos baby steps)
3º – Refatorar: Altere o código, mas não a funcionalidade: eliminar redundâncias,
boas práticas de programação, organizar o código

Repita para o próximo baby step (no início se permita realizar passos simples, mesmo que você já
saiba a solução na sua cabeça). A refatoração vai se tornando mais importante na medida que você
for iterando com cada ciclo do TDD.

1) Considerando o exercício 1.4. Implemente os testes para os métodos públicos das classes
implementadas no exercício, teste inclusive as situações que os métodos devem lançar alguma
exceção. Não é necessário testar os métodos getters e setters sem lógica.
*/