/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package guasca.controle.ferramentas;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Douglas
 */
public class Utilidades {

    public static Timestamp getTimesTampNow() {
        Date date_atual = new Date();
        Timestamp retorno = new Timestamp(date_atual.getTime());
        return retorno;
    }
}
