package DAO;

import com.ifsc.teste_integracao.Pessoa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PessoaDAO {
    Connection conexao;
    
    public PessoaDAO(Connection con){
        conexao = con;
    }
    
    public void insert(Pessoa p){
        String sqlInstrucao = "INSERT INTO pessoa("
                + " id,"
                + " nome,"
                + " data_nascimento,"
                + " )"
                + " VALUES (?,?,?)";
        PreparedStatement pstm = null;
        try {
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setInt(1, p.getId());
            pstm.setString(2, p.getNome());
            pstm.setDate(3, java.sql.Date.valueOf(p.getDataNasc()));
            pstm.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public Pessoa get(Pessoa p){
        String sqlInstrucao = "SELECT"
                + " id,"
                + " nome,"
                + " data_nascimento"
                + " FROM pessoa WHERE id=?";
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet rst = null;
        try {
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setInt(1, p.getId());
            rst = pstm.executeQuery();
            if(rst.next()) {
                return new Pessoa(
                    rst.getInt("id"),
                    rst.getString("nome"),
                    rst.getDate("data_nascimento").toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate()
                );
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public void update(Pessoa p){
        String sqlInstrucao = "UPDATE pessoa "
                + " SET"
                + " id =?,"
                + " nome =?,"
                + " data_nascimento =?"
                + " WHERE id =?";
        PreparedStatement pstm = null;
        try {
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setInt(1, p.getId());
            pstm.setString(2, p.getNome());
            pstm.setDate(3, java.sql.Date.valueOf(p.getDataNasc()));
            pstm.execute();
        }catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            return;
        }
    }
    
    public void delete(int id){
        String sqlInstrucao = "DELETE FROM pessoa "
                + "WHERE "
                + " id=?";
        PreparedStatement pstm = null;
        try{
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setInt(1, id);
            pstm.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public List<Pessoa> list(){
        String sqlInstrucao = "SELECT"
                + " id,"
                + " nome,"
                + " data_nascimento"
                + " FROM pessoa";
        PreparedStatement pstm = null;
        ResultSet rst = null;
        List<Pessoa> lista = new ArrayList<>();
        try {
            pstm = conexao.prepareStatement(sqlInstrucao);
            rst = pstm.executeQuery();
            while (rst.next()) {
                Pessoa pessoa = new Pessoa(
                        rst.getInt("id"),
                        rst.getString("nome"),
                        rst.getDate("data_nascimento").toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate()
                );
                lista.add(pessoa);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            return lista;
        }
    }
    
    public void save(Pessoa p){//caso o objeto tenha id (persistente) chame o update, caso contrário(transiente) chame o insert
        if(p.getId() >= 0)
            update(p);
        else
            insert(p);
    }
}
/*
PessoaDao:
construtor:
+PessoaDao(Connection con)
métodos:
+void insert(Pessoa p)
+Pessoa get(int id)
+void update(Pessoa p)
+void delete(int id)
+List<Pessoa> list()
+void save(Pessoa p) //caso o objeto tenha id (persistente) chame o update, caso contrário (transiente) chame o insert
*/