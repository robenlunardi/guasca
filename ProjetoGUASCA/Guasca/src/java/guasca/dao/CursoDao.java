/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package guasca.dao;

import guasca.modelo.Curso;
import guasca.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Douglas
 */
public class CursoDao implements CursoInterface {
    /** Método para cadastro de um curso no banco de dados.
     * 
     * @param novo Objeto para ser cadastrado.
     * @throws Exception Mostra uma menssagem com o errou que ocorreu.
     */
    @Override
    public void cadastrarCurso(Curso novo) throws Exception {
        Connection conexao = null;
        PreparedStatement ps = null;

        try {

            conexao = Conexao.abrirConexao();
            ps = conexao.prepareStatement("insert into curso (nome) values (?)");

            ps.setString(1, novo.getNome());
            ps.execute();

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            throw new Exception(e.getMessage());
        } finally {
            ps.close();
            conexao.close();
        }
    }

    @Override
    public void atualizarCurso(int idCurso) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void deletarCurso(int idCurso) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    /** Método para buscar os cursos cadastrados no banco de dados.
     * 
     * @return Retorna uma lista com o id e o nome dos cursos cadastrados banco de dados. 
     * @throws Exception Mostra uma menssagem com o errou que ocorreu.
     */
    @Override
    public List<Curso> buscarCursos() throws Exception {
        List<Curso> lista = new ArrayList<Curso>();

        Connection conexao = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {

            conexao = Conexao.abrirConexao();
            ps = conexao.prepareStatement("select * from curso");
            rs = ps.executeQuery();

            Curso curso;

            while (rs.next()) {
                curso = new Curso(rs.getInt("id_curso"), rs.getString("nome"));
                lista.add(curso);
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
