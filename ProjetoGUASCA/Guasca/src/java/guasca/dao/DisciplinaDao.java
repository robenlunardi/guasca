/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package guasca.dao;

import guasca.modelo.Disciplina;
import guasca.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Paula
 */
public class DisciplinaDao implements DisciplinaInterface{
    private int id_credito;
    private int id_disciplina;
    
 
    @Override
    public boolean cadastrarDisciplina(Disciplina nova) throws Exception {
        Connection conexao = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean retorno = false;

        try {

            conexao = Conexao.abrirConexao();
            ps = conexao.prepareStatement("insert into disciplina (nome, qtdAlunos, turno, id_area) values (?,?,?,?)", Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, nova.getNome());
            ps.setInt(2, nova.getQtd_alunos());
            ps.setInt(3, nova.getTurno());
            ps.setInt(4, nova.getId_area());
            ps.executeUpdate();
            
            ps.executeUpdate();
            
            rs = ps.getGeneratedKeys();
            
            if(rs.next()){
                id_disciplina = rs.getInt(1);
            }
            
            
            
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            throw new Exception(e.getMessage());
        } finally {
            ps.close();
            conexao.close();
            retorno = true;
        }
        return retorno;
    }
    
    public void cadastrarCreditos(Disciplina nova) throws Exception{
        Connection conexao = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        nova.getQtd_creditos1();
        nova.getQtd_creditos2();

        try {

            conexao = Conexao.abrirConexao();
            ps = conexao.prepareStatement("insert into credito (valor) values()",Statement.RETURN_GENERATED_KEYS);

            
            
            ps.setInt(1, nova.getTurno());
            ps.setInt(2, nova.getQtd_alunos());
            ps.executeUpdate();
            
            rs = ps.getGeneratedKeys();
            
            if(rs.next()){
                id_credito = rs.getInt(1);
            }
            
            cadastrarDisciplina_has_Creditos(id_credito, id_disciplina);

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            throw new Exception(e.getMessage());
        } finally {
            ps.close();
            conexao.close();
        }
    }
    
     private void cadastrarDisciplina_has_Creditos(int id_credito, int id_disciplina) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void atualizarDisciplina(int idDisciplina) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void deletarDisciplina(int idDisciplina) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Disciplina> buscarDisciplinas() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
