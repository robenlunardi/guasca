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

    public List<Indisponibilidade> buscarIndisponibilidades() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
