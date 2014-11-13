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
public class DisciplinaDao implements DisciplinaInterface {

    private int id_credito1;
    private int id_credito2;
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

            rs = ps.getGeneratedKeys();

            if (rs.next()) {
                this.id_disciplina = rs.getInt(1);
            }
            ps = null;
            rs = null;
            if (nova.getId_professor1() > 0) {
                ps = conexao.prepareStatement("insert into disciplina_has_professor (id_disciplina, id_professor) values (?,?)");
                ps.setInt(1, id_disciplina);
                ps.setInt(2, nova.getId_professor1());
                ps.execute();
                ps = null;
            }

            if (nova.getId_professor2() > 0) {
                ps = conexao.prepareStatement("insert into disciplina_has_professor (id_disciplina, id_professor) values (?,?)");
                ps.setInt(1, id_disciplina);
                ps.setInt(2, nova.getId_professor2());
                ps.execute();
                ps = null;
            }

            ps = conexao.prepareStatement("insert into credito (valor) values (?)", Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, nova.getQtd_creditos1());
            ps.executeUpdate();

            rs = ps.getGeneratedKeys();

            if (rs.next()) {
                this.id_credito1 = rs.getInt(1);
            }
            ps = null;
            rs = null;

            ps = conexao.prepareStatement("insert into disciplina_has_credito (id_credito, id_disciplina, id_tipo_sala) values (?,?,?)");
            ps.setInt(1, this.id_credito1);
            ps.setInt(2, id_disciplina);
            ps.setInt(3, nova.getTipo_sala1());
            ps.execute();

            ps = null;

            if (nova.getQtd_creditos2() > 0) {
                ps = conexao.prepareStatement("insert into credito (valor) values (?)", Statement.RETURN_GENERATED_KEYS);

                ps.setInt(1, nova.getQtd_creditos2());
                ps.executeUpdate();

                ps.executeUpdate();

                rs = ps.getGeneratedKeys();

                if (rs.next()) {
                    this.id_credito2 = rs.getInt(1);
                }
                ps = null;
                rs = null;
                
                ps = conexao.prepareStatement("insert into disciplina_has_credito (id_credito, id_disciplina, id_tipo_sala) values (?,?,?)");
                ps.setInt(1, this.id_credito2);
                ps.setInt(2, id_disciplina);
                ps.setInt(3, nova.getTipo_sala2());
                ps.execute();
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

    public void cadastrarCreditos(Disciplina nova) throws Exception {
        throw new UnsupportedOperationException("Not yet implemented");
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
