/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package guasca.dao;

import guasca.modelo.Professor;
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
public class ProfessorDao implements ProfessorInterface {

    @Override
    public void cadastrarProfessor(Professor nova) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void atualizarProfessor(int idProfessor) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void deletarProfessor(int idProfessor) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Professor> buscarProfessores() throws Exception {
        List<Professor> lista = new ArrayList<Professor>();

        Connection conexao   = null;
        PreparedStatement ps = null;
        ResultSet rs         = null;

        try {
            conexao = Conexao.abrirConexao();
            ps = conexao.prepareStatement("select * from professor");
            rs = ps.executeQuery();
            
            Professor professor;
            
            while(rs.next()){
                professor = new Professor(
                          rs.getInt("id_professor")
                        , rs.getString("nome"));
                lista.add(professor);
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
