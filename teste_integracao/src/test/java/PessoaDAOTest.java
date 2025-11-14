import DAO.ConnectionFactory;
import DAO.PessoaDAO;
import com.ifsc.teste_integracao.Pessoa;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PessoaDAOTest {
    private Connection conexao;
    private PessoaDAO pessoaDAO;
    private Pessoa p;

    @BeforeEach
    public void antesDeCadaTesteDao() throws SQLException {
        conexao = ConnectionFactory.getConnection();
        conexao.setAutoCommit(false);
        pessoaDAO = new PessoaDAO(conexao);
        p = new Pessoa(1, "João", LocalDate.of(2000, 1, 25));
    }
    @AfterEach
    public void aposCadaTesteDao() throws SQLException{
        conexao.rollback();
        conexao.setAutoCommit(true);
        conexao.close();
    }

    @Test
    @Order(0)
    @DisplayName("Testa insert e get")
    public void testInsertPessoa() throws SQLException{
        pessoaDAO.insert(p);
        assertEquals(pessoaDAO.get(p), p);
    }
    
    /*@Test
    @Order(1)
    public void testGetPessoa() throws SQLException{
        pessoaDAO.insert(p);
        assertTrue(pessoaDAO.get(p).equals(p));
    }*/
    
    @Test
    @Order(1)
    public void testUpdatePessoa() throws SQLException{
        pessoaDAO.insert(p);
        p.setNome("nome alterado");
        pessoaDAO.update(p);
        
        assertEquals(pessoaDAO.get(p), p);
    }
    
    @Test
    @Order(2)
    public void testDeletePessoa() throws SQLException{
        pessoaDAO.delete(p.getId());
        
        assertTrue(!pessoaDAO.list().contains(p));
    }
    
    @Test
    @Order(3)
    public void testListPessoa() throws SQLException{
        Pessoa p2 = new Pessoa(2, "pessoa 2", LocalDate.of(2000, 2, 25));
        Pessoa p3 = new Pessoa(3, "pessoa 3", LocalDate.of(2000, 3, 25));

        pessoaDAO.insert(p);
        pessoaDAO.insert(p2);
        pessoaDAO.insert(p3);

        List<Pessoa> lista = pessoaDAO.list();

        assertTrue(lista.containsAll(Arrays.asList(p, p2, p3)), "Lista deve conter todas as pessoas inseridas");
    }
    
    @Test
    @Order(4)
    public void testSavePessoa() throws SQLException{
        pessoaDAO.insert(p);
        p.setNome("nome alterado para update");
        Pessoa pNoBanco = pessoaDAO.get(p);//Busca por id no banco
        
        assertTrue(pNoBanco != p);
        pessoaDAO.save(p);//Update
        pNoBanco = pessoaDAO.get(p);
        assertEquals(pNoBanco, p);
        
        Pessoa p4 = new Pessoa(4, "pessoa 4", LocalDate.of(2000, 4, 25));
        pessoaDAO.insert(p4);//Insert
        assertTrue(pessoaDAO.list().contains(p4));
    }
}
/*
Testa cada um dos métodos do DAO, para isso, faça com que cada teste seja um uma transação no
banco que não será efetivada (rollback). Cada teste deve ser independente dos outros. Se necessário
crie métodos auxiliares privados para uma melhor organização dos testes.
*/