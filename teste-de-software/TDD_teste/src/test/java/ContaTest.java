import com.ifsc.tdd_teste.Conta;
import com.ifsc.tdd_teste.ContaException;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ContaTest {
    final Conta[] conta = new Conta[5];
    
    @BeforeEach
    @Test
    public void testaContaValida(){
        assertDoesNotThrow(()->{
            conta[0] = new Conta(1000, 10000);
        });
        Assertions.assertNotNull(conta[0]);
    }
    //1) deve ser possível sacar uma determinada quantia da conta, o método retorna o valor sacado.
    //1.1) Essa quantia deve ser sempre positiva, do contrario exception não verificada deve ser lançada(ContaException)
    //1.2) Essa quantia deve ser menor que o saldo + o limite da conta para que o saque seja possível, caso o saque não seja possível o valor retornado será 0.
    @Test
    public void testaSaque(){
        assertDoesNotThrow(() -> {
            conta[0].sacar(500);
        });
        Assertions.assertEquals("quantia deve ser positiva.", assertThrows(ContaException.class, ()->{
            conta[0].sacar(-500);
        }).getMessage());
        assertEquals(500, conta[0].sacar(500));//Saque válido
        assertEquals(0, conta[0].sacar(200000));//Saque inválido, deve retornar 0
    }
    //2) deve ser possível depositar um valor positivo na conta. Será retornado o saldo final após o depósito.
    //2.1) Caso o valor não seja positivo, deve-se lançar uma ContaException.
    @Test
    public void testaDeposito(){
        assertDoesNotThrow(() -> {
            conta[0].depositar(500);
            conta[0].sacar(500);
        });
        assertEquals(1500, conta[0].depositar(500));//Testa retorno de deposito valido
        ContaException excecaoDeposito = assertThrows(ContaException.class, ()->{
            conta[0].depositar(-500);//Deposito invalido, excecao guardada
        });
        Assertions.assertEquals("deposito deve ser positivo.", excecaoDeposito.getMessage());
    }
    //3) deve ser possível alterar o limite de uma conta para um novo valor que não seja negativo.
    //3.1)caso valor negativo deve ser lançada uma ContaException
    @Test
    public void testaLimite(){
        assertDoesNotThrow(() -> {
            conta[0].setLimite(15000);
        });
        Assertions.assertEquals("limite deve ser positivo.", assertThrows(ContaException.class, ()->{
            conta[0].setLimite(-15000);
        }).getMessage());
    }
    //4) deve ser possível transferir uma determinada quantidade positiva da conta de um cliente para a conta de outro cliente.
    //4.1) a quantidade deve ser positiva
    //4.2) a conta não deve ser nula
    //4.3) somando-se o saldo com o limite da conta de origem, não se pode obter um valor negativo
    //4.4) caso algum desses casos aconteça gere uma ContaException)
    @Test
    public void testaTransferencia(){
        conta[1] = new Conta(5000, 50000);
        assertDoesNotThrow(()->{
            conta[0] = conta[1].transferir(conta[0], 1000);//conta[1] transfere 1000 para conta[0]
            Assertions.assertEquals(2000, conta[0].getSaldo());//Testa se a transferencia alterou o saldo da conta[0] de acordo
        });
        
        Assertions.assertEquals("transferencia deve ser positiva.", assertThrows(ContaException.class, ()->{
            conta[0] = conta[1].transferir(conta[0], -1000);
        }).getMessage());
        
        Assertions.assertEquals("saldo da conta de origem insuficiente.", assertThrows(ContaException.class, ()->{
            conta[0] = conta[1].transferir(conta[0], 800000);
        }).getMessage());
        
        Assertions.assertEquals("conta destino nao pode ser nula.", assertThrows(ContaException.class, ()->{
            conta[0]=null;
            conta[0] = conta[1].transferir(conta[0], -1000);
        }).getMessage());
        
    }
}
/*
Construa uma classe Conta. Para tanto primeiro programe um caso de teste que deve falhar e
após programe como corrigir cada falha de teste para que o código funcione e assim
sucessivamente. Comece programando a classe ContaTest.
*/