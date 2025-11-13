import DAO.PessoaDAO;
import com.ifsc.teste_integracao.Pessoa;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class PessoaDAOTest {
    private Connection conexao;
    private PessoaDAO pessoaDAO;

    @BeforeEach
    public void antesDeCadaTesteDao() throws SQLException {
        conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/teste_integracao", "root", "ifsc");
        pessoaDAO = new PessoaDAO(conexao);
        conexao.setAutoCommit(false);
    }
    @AfterEach
    public void aposCadaTesteDao() throws SQLException{
        conexao.rollback();
        conexao.setAutoCommit(true);
        conexao.close();
    }

    @Test
    public void testInsertPessoa() throws SQLException{
        Pessoa p = new Pessoa(1, "João", LocalDate.of(2000, 1, 25));

        pessoaDAO.insert(p);

        assertTrue(pessoaDAO.list().contains(p));
    }
    
    @Test
    public void testGetPessoa() throws SQLException{
        
    }
    
    @Test
    public void testUpdatePessoa() throws SQLException{
        
    }
    
    @Test
    public void testDeletePessoa() throws SQLException{
        
    }
    
    @Test
    public void testListPessoa() throws SQLException{
        
    }
    
    @Test
    public void testSavePessoa() throws SQLException{
        
    }
}
/*
Testa cada um dos métodos do DAO, para isso, faça com que cada teste seja um uma transação no
banco que não será efetivada (rollback). Cada teste deve ser independente dos outros. Se necessário
crie métodos auxiliares privados para uma melhor organização dos testes.
*/