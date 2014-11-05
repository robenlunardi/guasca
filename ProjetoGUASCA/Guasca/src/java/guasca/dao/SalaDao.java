/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package guasca.dao;

import guasca.modelo.Sala;
import guasca.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 4DS
 */
public class SalaDao implements SalaInterface{
    
     @Override
    public void cadastrarSala(Sala nova) throws Exception {
        /* @@@ implementar @@@*/
        Connection conexao = null;
        PreparedStatement ps = null;

        try {

            conexao = Conexao.abrirConexao();
            ps = conexao.prepareStatement("insert into sala (qtdAlunos, nome, id_tipo_sala) values (?,?,?)");
            
            
            ps.setInt(1, nova.getQuantAlunos());
            ps.setString(2, nova.getNome());
            ps.setInt(3, nova.getIdTipoSala());
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
    public void atualizarSala(int idSala) throws Exception {
        /* @@@ implementar @@@*/
    }

    @Override
    public void deletarSala(int idSala) throws Exception {
        /* @@@ implementar @@@*/
    }

    @Override
    public List<Sala> buscarSalas() throws Exception {
        /* @@@ implementar @@@*/

        List<Sala> lista = new ArrayList<Sala>();

        Connection conexao   = null;
        PreparedStatement ps = null;
        ResultSet rs         = null;

        try {
            
            conexao = Conexao.abrirConexao();
            ps = conexao.prepareStatement("select * from sala");
            rs = ps.executeQuery();
            
            Sala sala;
            
             while (rs.next()) {
                sala = new Sala(
                        rs.getInt("id_sala"), rs.getString("nome"), rs.getInt("id_tipo_sala"), rs.getInt("qtdAlunos"));
                lista.add(sala);
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
