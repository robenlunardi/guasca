/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package guasca.dao;

import guasca.modelo.Indisponibilidade;
import guasca.modelo.Professor;
import java.util.List;

/**
 *
 * @author Douglas
 */
public interface IndisponibilidadeInterface {
    public abstract void cadastrarInds(int id, List<Indisponibilidade> lista) throws Exception;
}
