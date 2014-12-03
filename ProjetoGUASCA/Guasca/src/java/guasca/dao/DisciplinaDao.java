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

            if (nova.getId_curso() > 0) {
                ps = conexao.prepareStatement("insert into curso_has_disciplina (id_disciplina, id_curso) values (?,?)");
                ps.setInt(1, id_disciplina);
                ps.setInt(2, nova.getId_curso());
                ps.execute();
                ps = null;
            }

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
        List<Disciplina> lista = new ArrayList<Disciplina>();

        Connection conexao = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {

            conexao = Conexao.abrirConexao();
            ps = conexao.prepareStatement("select * from disciplina");
            rs = ps.executeQuery();

            Disciplina disciplina;

            while (rs.next()) {
                disciplina = new Disciplina(rs.getInt("id_disciplina"), rs.getString("nome"));
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
    
    @Override
    public List<Disciplina> buscarDisciplinasPorCurso(int idCurso) throws Exception{
        List<Disciplina> lista = new ArrayList<Disciplina>();

        Connection conexao = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        StringBuilder sql = new StringBuilder();

        try {
            
            sql.append("select d.id_disciplina, d.nome, c.id_credito, c.valor from disciplina d ")
                 .append("inner join curso_has_disciplina chd on chd.id_disciplina = d.id_disciplina ")
                 .append("inner join disciplina_has_credito dhc on dhc.id_disciplina = chd.id_disciplina ")
                 .append("inner join credito c on c.id_credito = dhc.id_credito ")
                 .append("where chd.id_curso = ? order by 1");
            conexao = Conexao.abrirConexao();
            ps = conexao.prepareStatement(sql.toString());
            ps.setInt(1, idCurso);
            rs = ps.executeQuery();

            Disciplina disciplina;
            int[] creditos = new int[2];
            int anterior = 0;
            while (rs.next()) {
                    if (anterior != 0 && rs.getInt("id_disciplina") == anterior) {
                        lista.get(lista.size() - 1).setId_credito2(rs.getInt("id_credito"));
                        lista.get(lista.size() - 1).setQtd_creditos2(rs.getInt("valor"));
                    }else{
                        disciplina = new Disciplina(rs.getInt("id_disciplina"), rs.getString("nome"), rs.getInt("id_credito"), rs.getInt("valor"));
                        anterior = disciplina.getId_disciplina();
                        lista.add(disciplina);                        
                    }
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
