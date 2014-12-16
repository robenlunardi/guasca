/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package guasca.dao;

import guasca.modelo.TipoSala;
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
public class TipoSalaDao implements TipoSalaInterface{
    /** Método para inserir um tipo de sala no banco de dados.
     * 
     * @param tpSala tipo de sala para insersão.
     * @throws Exception Mostra uma menssagem com o errou que ocorreu.
     */
    @Override
    public void inserirTipoSala(TipoSala tpSala) throws Exception{
        Connection conexao = null;
        PreparedStatement ps = null;

        try {

            conexao = Conexao.abrirConexao();
            ps = conexao.prepareStatement("insert into tipo_sala (nome) values (?)");

            ps.setString(1, tpSala.getDescricao());
            ps.execute();

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            throw new Exception(e.getMessage());
        } finally {
            ps.close();
            conexao.close();
        }
    }
    /** Método para buscar os tipos de sala cadastrados no banco de dados.
     * 
     * @return Lista com o id e o nome do tipo de sala.
     * @throws Exception Mostra uma menssagem com o errou que ocorreu.
     */
    @Override
    public List<TipoSala> buscarTiposSalas() throws Exception {
        List<TipoSala> lista = new ArrayList<TipoSala>();

        Connection conexao   = null;
        PreparedStatement ps = null;
        ResultSet rs         = null;

        try {
            
            conexao = Conexao.abrirConexao();
            ps = conexao.prepareStatement("select * from tipo_sala");
            rs = ps.executeQuery();
            
            TipoSala tpSala = null;
            
            while(rs.next()){
                tpSala = new TipoSala(
                          rs.getInt("id_tipo_sala")
                        , rs.getString("nome"));
                lista.add(tpSala);
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
