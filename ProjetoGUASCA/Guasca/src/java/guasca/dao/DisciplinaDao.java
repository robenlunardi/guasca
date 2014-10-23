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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Paula
 */
public class DisciplinaDao implements DisciplinaInterface{
 
    @Override
    public void cadastrarDisciplina(Disciplina nova) throws Exception {
        Connection conexao = null;
        PreparedStatement ps = null;

        try {

//            conexao = Conexao.abrirConexao();
//            ps = conexao.prepareStatement("insert into disciplina (nome) values (?)");
//
//            ps.setString(1, nova.getNome());
//            ps.execute();

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            throw new Exception(e.getMessage());
        } finally {
            ps.close();
            conexao.close();
        }
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
        List<Disciplina> lista = new ArrayList<Disciplina>();

        Connection conexao   = null;
        PreparedStatement ps = null;
        ResultSet rs         = null;

        try {
            
            conexao = Conexao.abrirConexao();
            ps = conexao.prepareStatement("select * from disciplina");
            rs = ps.executeQuery();
            
            Disciplina disciplina;
            
            while(rs.next()){
                disciplina = new Disciplina(
                          rs.getInt("id_disciplina")
                        , rs.getString("nome"));
                lista.add(disciplina);
            }
            
            
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            throw new Exception(e.getMessage());
        } finally {
            ps.close();
            conexao.close();
        }

        return lista;
    }
}
