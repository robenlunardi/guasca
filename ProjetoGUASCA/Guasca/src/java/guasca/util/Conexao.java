/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package guasca.util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Douglas
 */
public class Conexao {
    public static Connection abrirConexao() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con;
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/guasca", "root", "connect");
        
        return con;
    }
}
