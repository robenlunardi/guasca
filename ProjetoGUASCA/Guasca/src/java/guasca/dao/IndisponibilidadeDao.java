/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package guasca.dao;

import guasca.controle.ferramentas.Utilidades;
import guasca.modelo.Indisponibilidade;
import guasca.modelo.Professor;
import guasca.util.Conexao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Douglas
 */
public class IndisponibilidadeDao implements IndisponibilidadeInterface {
    /** Método para cadastro da indisponibilidade de um professor no banco de dados.
     * 
     * @param id Id do professor para cadastro da indisponibilidade.
     * @param lista Lista com os turnos/dias em que o professor possui indisponibilidade.
     * @throws Exception Mostra uma menssagem com o errou que ocorreu.
     */
    @Override
    public void cadastrarInds(int id, List<Indisponibilidade> lista) throws Exception {
        Connection conexao = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conexao = Conexao.abrirConexao();
            List<Integer> listaId = new ArrayList<Integer>();
            ps = conexao.prepareStatement("insert into indisponibilidade (dia, turno, valor) values (?,?,?)", Statement.RETURN_GENERATED_KEYS);

            for (int i = 0; i < lista.size(); i++) {
                ps.setInt(1, lista.get(i).getDia());
                ps.setInt(2, lista.get(i).getTurno());
                ps.setInt(3, lista.get(i).getValor());

                ps.executeUpdate();
                rs = ps.getGeneratedKeys();

                if (rs.next()) {
                    listaId.add(rs.getInt(1));
                }
                rs = null;
            }

            ps = null;

            ps = conexao.prepareStatement("insert into professor_has_ind (id_ind, id_professor, ano, periodo, datetime) values (?,?,?,?,?)");
            
            for (int i = 0; i < listaId.size(); i++) {
                ps.setInt(1, listaId.get(i));
                ps.setInt(2, id);
                ps.setInt(3, lista.get(0).getAno());
                ps.setInt(4, lista.get(0).getPeriodo());
                ps.setTimestamp(5, Utilidades.getTimesTampNow());
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
    /** Método para buscar professores que possuem alguma indisponibilidade.
     * 
     * @return lista dos professores que possuem alguma indisponibilidade.
     * @throws Exception Mostra uma menssagem com o errou que ocorreu.
     */
    public List<Professor> buscarIndisponibilidade() throws Exception {
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
                        rs.getInt("id_professor"), rs.getString("nome"));
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
    public List<Professor> buscarIndisponibilidades() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    
}
