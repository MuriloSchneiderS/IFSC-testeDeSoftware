import org.junit.jupiter.api.*;
import com.ifsc.tdd_teste.Intervalo;

public class IntervaloTeste {
    private final Intervalo intervalo = new Intervalo(3,4,5);
    
    @Test
    @DisplayName("intervalos")
    public void testaIntervalos(){
        Intervalo intervalo = new Intervalo(3,4,5);
        Intervalo intervalo2 = new Intervalo(6,7,8);
        
        Assertions.assertEquals(3, intervalo.horas());
        Assertions.assertEquals(4, intervalo.minutos());
        Assertions.assertEquals(5, intervalo.segundos());
    }
    @Test
    @DisplayName("Total de minutos do intervalo.")
    public void testaTotalMinutos(){
        Assertions.assertEquals(180, intervalo.totalMinutos());
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