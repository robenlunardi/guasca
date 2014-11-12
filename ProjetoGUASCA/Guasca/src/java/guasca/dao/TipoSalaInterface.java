/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package guasca.dao;

import guasca.modelo.TipoSala;
import java.util.List;

/**
 *
 * @author Douglas
 */
public interface TipoSalaInterface {
    public abstract void inserirTipoSala(TipoSala tpSala)throws Exception;
    public abstract List<TipoSala> buscarTiposSalas()throws Exception;
}
