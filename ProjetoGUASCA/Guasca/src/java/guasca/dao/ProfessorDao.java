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
