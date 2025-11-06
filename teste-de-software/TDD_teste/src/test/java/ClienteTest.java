import com.ifsc.tdd_teste.Cliente;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ClienteTest {
        
    @Test
    @DisplayName("Classe de teste criada antes de Cliente.")
    public void testaClienteAntesDeCrialo(){
        //CPF
        Cliente cliente = null;
        //cpf valido
        assertDoesNotThrow(() -> {
            cliente = new Cliente("nome", "123.456.789-09", "01/01/2000");
        });
        // Verifica que o cliente foi criado com sucesso
        assertNotNull(cliente);
        //cpf no formato errado
        RuntimeException excecaoCPF = assertThrows(RuntimeException.class, () -> {
            cliente = new Cliente("cliente 1", "123456.78.909", "01/01/2000");
        });
        Assertions.assertEquals("cpf deve ser no formato XXX.YYY.ZZZ-WW.", excecaoCPF.getMessage());
        
        //NOME
        
        //DATA DE NASCIMENTO
    }
}
/*
Construa uma classe Cliente. Para tanto primeiro programe um caso de teste que deve falhar e
após programe como corrigir cada falha de teste para que o código funcione e assim
sucessivamente. Comece programando a classe ClienteTest.

1) todo cliente deve ter nome, cpf e data de nascimento
Ao se criar um cliente deve-se validar seu nome, cpf e data de nascimento com as seguintes regras:
1.1) cpf deve ser no formato XXX.YYY.ZZZ-WW. Caso contrário uma exception não verificada do
tipo ClienteException deve ser lançada – crie essa classe)
1.2) nome não deve ter caracteres não alfabéticos. Caso contrário uma exception não verificada do
tipo ClienteException deve ser lançada)
1.3) cpf deve ser válido. Caso contrário uma exception não verificada do tipo ClienteException
deve ser lançada)
1.4) data nascimento deve ser maior que 1900 e menor que a data atual. Caso contrário uma
exception não verificada do tipo ClienteException deve ser lançada)
*/