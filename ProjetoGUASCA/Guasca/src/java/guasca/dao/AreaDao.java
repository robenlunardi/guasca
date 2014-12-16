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
    /**Método para cadastro de uma nova área no banco de dados.
     * 
     * @param nova Objeto para ser cadastrado.
     * @throws Exception Mostra uma menssagem com o errou que ocorreu.
     */
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
    /** Método para buscar as áreas cadastradas no banco de dados.
     * 
     * @return Retorna uma lista com o id e o nome das áreas cadastradas no banco  de dados.
     * @throws Exception Mostra uma menssagem com o errou que ocorreu.
     */
    @Override
    public List<Area> buscarAreas() throws Exception {
        /* @@@ implementar @@@*/

        List<Area> lista = new ArrayList<Area>();

        Connection conexao   = null;
        PreparedStatement ps = null;
        ResultSet rs         = null;

        try {
            
            conexao = Conexao.abrirConexao();
            ps = conexao.prepareStatement("select * from area use index (idx_area_nome)");
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
    /** Método para buscar as áreas de atuação de um professor.
     * 
     * @param idProf Id do professor para busca das áreas de atuação.
     * @return Retorna uma lista com as áreas de atuação do professor.
     * @throws Exception Mostra uma menssagem com o errou que ocorreu.
     */
    @Override
    public List<Area> buscarAreasProfessor(int idProf) throws Exception {
        List<Area> lista = new ArrayList<Area>();

        Connection conexao   = null;
        PreparedStatement ps = null;
        ResultSet rs         = null;

        try {
            StringBuilder sql = new StringBuilder();
            sql.append("select a.* from area a")
                .append(" join professor_has_area pha on pha.id_area = a.id_area")
                .append(" join professor p on p.id_professor = pha.id_area")
                .append(" where p.id_professor = ?");
               
            conexao = Conexao.abrirConexao();
            ps = conexao.prepareStatement(sql.toString());
            ps.setInt(1, idProf);
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
