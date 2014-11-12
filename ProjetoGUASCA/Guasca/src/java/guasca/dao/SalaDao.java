/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guasca.dao;

import guasca.modelo.Sala;
import guasca.modelo.TipoSala;
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
public class SalaDao implements SalaInterface {

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
            ps.setInt(3, nova.getTpSala().getIdTipoSala());
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
    public void atualizarSala (String nome, int quantAlunos, int id_tipo_sala, int idSala) throws Exception {
        /* @@@ implementar @@@*/
        
        try {
            Connection con = Conexao.abrirConexao();
            
            PreparedStatement p;
            p = con.prepareStatement ("update sala set nome = ?, qtdAlunos = ?, id_tipo_sala = ? where id_sala = ?");
            p.setString(1, nome);
            p.setInt(2, quantAlunos);
            p.setInt(3, id_tipo_sala);
            p.setInt(4, idSala);
            
            p.execute();
            
            p.close();
            con.close();
        } catch (Exception ex) {
            throw new Exception ("Erro: "+ex.getMessage());
        }
    }

    @Override
    public void deletarSala(int idSala) throws Exception {
        /* @@@ implementar @@@*/
        
        try {
            Connection con = Conexao.abrirConexao();
            
            PreparedStatement p;
            
            p = con.prepareStatement("delete from sala where id_sala = ?");
            p.setInt(1, idSala);
            p.execute();
   
            
            p.close();
            con.close();
        } catch (Exception ex) {
            throw new Exception ("Falha no banco: "+ex.getMessage());
        }
        
    }

    @Override
    public List<Sala> buscarSalas() throws Exception {
        /* @@@ implementar @@@*/

        List<Sala> lista = new ArrayList<Sala>();

        Connection conexao = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {

            conexao = Conexao.abrirConexao();
            ps = conexao.prepareStatement("select * from sala");
            rs = ps.executeQuery();

            Sala sala;
            TipoSala tpSala;
            while (rs.next()) {
                tpSala = new TipoSala(rs.getInt("id_tipo_sala"));
                sala = new Sala(
                        rs.getInt("id_sala"), rs.getString("nome"), tpSala, rs.getInt("qtdAlunos"));
                lista.add(sala);
            }
            
            ps = null;
            rs = null;
            
            ps = conexao.prepareStatement("select * from tipo_sala where id_tipo_sala = ?");
            for (int i = 0; i < lista.size(); i++) {
                ps.setInt(1, lista.get(i).getTpSala().getIdTipoSala());
                rs = ps.executeQuery();
                while(rs.next()){
                    lista.get(i).getTpSala().setDescricao(rs.getString("nome"));
                }
                rs = null;
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
    public Sala buscarSala(int idSala) throws Exception {
        /* @@@ implementar @@@*/

        Connection conexao   = null;
        PreparedStatement p = null;
        
        Sala sala = null;

        try {
            
            conexao = Conexao.abrirConexao();
            p = conexao.prepareStatement("select * from sala where id_sala = ?");
            p.setInt(1, idSala);
            
            ResultSet rs;
            rs = p.executeQuery();
            
            if (rs.next()) {
                sala = new Sala(
                        rs.getInt("id_sala"), rs.getString("nome"), rs.getInt("qtdAlunos"));           
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
        
        return sala;
    }    
    
}
