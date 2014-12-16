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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.jdt.internal.compiler.lookup.TypeConstants;

/**
 *
 * @author Paula
 */
public class ProfessorDao implements ProfessorInterface {
    /** Método para cadastrar um professor no banco de dados.
     * 
     * @param prof Objeto para cadastrado.
     * @throws Exception Mostra uma menssagem com o errou que ocorreu.
     */
    @Override
    public void cadastrarProfessor(Professor prof) throws Exception {
        Connection conexao = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conexao = Conexao.abrirConexao();
            ps = conexao.prepareStatement("insert into professor (matricula, nome, email) values (?,?,?)", Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, prof.getMatricula());
            ps.setString(2, prof.getNome());
            ps.setString(3, prof.getEmail());

            ps.executeUpdate();
            rs = ps.getGeneratedKeys();

            if (rs.next()) {
                prof.setIdProfessor(rs.getInt(1));
            }

            rs.close();
            ps = null;

            ps = conexao.prepareStatement("insert into professor_has_area (id_area, id_professor) values (?,?)");

            for (int i = 0; i < prof.getListaArea().size(); i++) {
                ps.setInt(1, prof.getListaArea().get(i).getIdArea());
                ps.setInt(2, prof.getIdProfessor());
                ps.execute();
            }

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            throw new Exception(e.getMessage());
        } finally {
            ps.close();
            conexao.close();
        }
    }

    @Override
    public void atualizarProfessor(int idProfessor) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void deletarProfessor(int idProfessor) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    /** Método para buscar professores cadastrados no banco de dados.
     * 
     * @return Lista com o id, o nome, a matrícula e o email dos professores cadastrados no banco.
     * @throws Exception Mostra uma menssagem com o errou que ocorreu.
     */
    @Override
    public List<Professor> buscarProfessores() throws Exception {
        List<Professor> lista = new ArrayList<Professor>();

        Connection conexao = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conexao = Conexao.abrirConexao();
            ps = conexao.prepareStatement("select * from professor");
            rs = ps.executeQuery();

            Professor professor;

            while (rs.next()) {
                professor = new Professor(
                        rs.getInt("id_professor"), rs.getString("nome"), rs.getString("matricula"), rs.getString("email"));
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
    /** Método para buscar professorem que não possuem nenhuma indisponibilidade.
     * 
     * @return Lista com o id, o nome, a matrícula e o email dos professores cadastrados no banco.
     * @throws Exception Mostra uma menssagem com o errou que ocorreu.
     */
    @Override
    public List<Professor> buscarProfessoresSemProfHasInd() throws Exception {
        List<Professor> lista = new ArrayList<Professor>();

        Connection conexao = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conexao = Conexao.abrirConexao();
            ps = conexao.prepareStatement("select p.* from professor p where not exists(select phi.id_professor from professor_has_ind phi where phi.id_professor = p.id_professor)");
            rs = ps.executeQuery();

            Professor professor;

            while (rs.next()) {
                professor = new Professor(
                        rs.getInt("id_professor"), rs.getString("matricula"), rs.getString("nome"), rs.getString("email"));
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
    /** Método para buscar um professor no banco de dados pelo id.
     * 
     * @param id Id do professor para realização da busca.
     * @return Objeto Professor com o id e o nome do professor.
     * @throws Exception Mostra uma menssagem com o errou que ocorreu.
     */
    @Override
    public Professor buscarProfessoresId(int id) throws Exception {
        Professor retorno = null;

        Connection conexao = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conexao = Conexao.abrirConexao();
            ps = conexao.prepareStatement("select * from professor where id_professor = ?");
            ps.setInt(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {
                retorno = new Professor(
                        rs.getInt("id_professor"), rs.getString("nome"));
            }
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            throw new Exception(e.getMessage());
        } finally {
            ps.close();
            conexao.close();
        }
        return retorno;
    }
    /** Método para buscar o id de um professor.
     * 
     * @param matricula matricula do professor para busca do id do mesmo.
     * @return id do professor.
     * @throws Exception Mostra uma menssagem com o errou que ocorreu.
     */
     @Override
    public int buscarProfessor(String matricula) throws Exception {
        /* @@@ implementar @@@*/

        Connection conexao   = null;
        PreparedStatement p = null;
        

        int aux = 0;
        try {
            
            conexao = Conexao.abrirConexao();
            p = conexao.prepareStatement("select id_professor from professor where matricula = ?");
            p.setString(1, matricula);
            
            ResultSet rs;
            rs = p.executeQuery();
            
            if (rs.next()) {
                      aux = rs.getInt("id_professor");
            }
            
            p.close();
            rs.close();
            conexao.close();            
            
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            throw new Exception(e.getMessage());
        } finally {
            p.close();
            conexao.close();
        }
        
        return aux;
    }
    /** Método para buscar professores por área de atuação.
     * 
     * @param idArea id da área para pesquisa dos professores.
     * @return Lista dos professores respectivos a área.
     * @throws Exception Mostra uma menssagem com o errou que ocorreu.
     */
    @Override
    public List<Professor> buscarProfessoresPorArea(int idArea) throws Exception {
        List<Professor> lista = new ArrayList<Professor>();

        Connection conexao = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            StringBuilder query = new StringBuilder();
            query.append("select p.id_professor, p.nome")
                    .append(" from professor p ")
                    .append(" inner join professor_has_area pha on pha.id_professor = p.id_professor ")
                    .append(" where pha.id_area = ? ");

            conexao = Conexao.abrirConexao();
            ps = conexao.prepareStatement(query.toString());
            ps.setInt(1, idArea);
            rs = ps.executeQuery();

            Professor professor;

            while (rs.next()) {
                professor = new Professor(
                        rs.getInt("p.id_professor"), rs.getString("p.nome"));
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
