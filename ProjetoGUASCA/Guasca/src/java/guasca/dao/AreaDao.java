/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package guasca.dao;

import guasca.modelo.Area;
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
public class AreaDao implements AreaInterface {

    @Override
    public void cadastrarArea(Area nova) throws Exception {
        /* @@@ implementar @@@*/
        Connection conexao = null;
        PreparedStatement ps = null;

        try {

            conexao = Conexao.abrirConexao();
            ps = conexao.prepareStatement("insert into area (nome) values (?)");

            ps.setString(1, nova.getDescricao());
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
    public void atualizarArea(int idArea) throws Exception {
        /* @@@ implementar @@@*/
    }

    @Override
    public void deletarArea(int idArea) throws Exception {
        /* @@@ implementar @@@*/
    }

    @Override
    public List<Area> buscarAreas() throws Exception {
        /* @@@ implementar @@@*/

        List<Area> lista = new ArrayList<Area>();

        Connection conexao   = null;
        PreparedStatement ps = null;
        ResultSet rs         = null;

        try {
            
            conexao = Conexao.abrirConexao();
            ps = conexao.prepareStatement("select * from area");
            rs = ps.executeQuery();
            
            Area area;
            
            while(rs.next()){
                area = new Area(
                          rs.getInt("id_area")
                        , rs.getString("nome"));
                lista.add(area);
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
