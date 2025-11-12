import com.ifsc.tdd_teste.Cliente;
import com.ifsc.tdd_teste.ClienteException;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ClienteTest {
    final Cliente[] cliente = {null};
    
    //1) todo cliente deve ter nome, cpf e data de nascimento
    //Ao se criar um cliente deve-se validar seu nome, cpf e data de nascimento com as seguintes regras:
    @Test
    @DisplayName("Testa criacao de um cliente valido.")
    @Order(0)
    public void testaClienteValido(){
        assertDoesNotThrow(() -> {
            cliente[0] = new Cliente("cliente teste", "123.456.789-09", "01/01/2000");
        });
        //Verifica que o cliente foi criado com sucesso
        assertNotNull(cliente[0]);
    }
    //1.1) cpf deve ser no formato XXX.YYY.ZZZ-WW.
    //Caso contrário uma exception não verificada do tipo ClienteException deve ser lançada – crie essa classe)
    //1.3) cpf deve ser válido. Caso contrário uma exception não verificada do tipo ClienteException
    //deve ser lançada)
    @Test
    @DisplayName("Testa CPF.")
    @Order(1)
    public void testaCpfCliente(){
        //CPF no formato errado
        ClienteException excecaoCPFformato = assertThrows(ClienteException.class, () -> {
            cliente[1] = new Cliente("cliente teste", "123456.78.909", "01/01/2000");
        });
        Assertions.assertEquals("cpf deve ser no formato XXX.YYY.ZZZ-WW.", excecaoCPFformato.getMessage());
        //CPF invalido
        ClienteException excecaoCPFinvalido = assertThrows(ClienteException.class, () -> {
            cliente[1] = new Cliente("cliente teste", "123.456.789-00", "01/01/2000");
        });
        Assertions.assertEquals("cpf invalido.", excecaoCPFinvalido.getMessage());
        
    }
    //1.2) nome não deve ter caracteres não alfabéticos. 
    //Caso contrário uma exception não verificada do tipo ClienteException deve ser lançada)
    @Test
    @DisplayName("Testa Nome.")
    @Order(2)
    public void testaNomeCliente(){
        //Nome com caracteres nao alfabeticos
        ClienteException excecaoNome = assertThrows(ClienteException.class, () -> {
            cliente[2] = new Cliente("123;'.", "123.456.789-09", "01/01/2000");
        });
        Assertions.assertEquals("nome não deve ter caracteres não alfabéticos.", excecaoNome.getMessage());
    }
    //1.4) data nascimento deve ser maior que 1900 e menor que a data atual. 
    //Caso contrário uma exception não verificada do tipo ClienteException deve ser lançada)
    @Test
    @DisplayName("Testa Data de nascimento.")
    @Order(3)
    public void testaDataDeNascimento(){
        //Data de nascimento no formato errado
        ClienteException excecaoDataInvalida = assertThrows(ClienteException.class, () -> {
            cliente[3] = new Cliente("cliente teste", "123.456.789-09", "99/13/0");
        });
        Assertions.assertEquals("data invalida.", excecaoDataInvalida.getMessage());
        
        //Data de nascimento menor que 1900
        ClienteException excecaoDataMenor = assertThrows(ClienteException.class, () -> {
            cliente[4] = new Cliente("cliente teste", "123.456.789-09", "01/01/1800");
        });
        Assertions.assertEquals("data de nascimento deve ser maior que 1900.", excecaoDataMenor.getMessage());
        
        //Data de nascimento menor que data atual
        ClienteException excecaoDataMaior = assertThrows(ClienteException.class, () -> {
            cliente[5] = new Cliente("cliente teste", "123.456.789-09", "01/01/3000");
        });
        Assertions.assertEquals("data de nascimento deve ser menor que a data atual.", excecaoDataMaior.getMessage());
    }
}
/*
Construa uma classe Cliente. Para tanto primeiro programe um caso de teste que deve falhar e
após programe como corrigir cada falha de teste para que o código funcione e assim
sucessivamente. Comece programando a classe ClienteTest.
*/