/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package guasca.dao;

import guasca.modelo.Sala;
import java.util.List;

/**
 *
 * @author 4DS
 */
public interface SalaInterface {
    
    public abstract void cadastrarSala(Sala nova) throws Exception;
    public abstract void atualizarSala(int idSala) throws Exception;
    public abstract void deletarSala(int idSala) throws Exception;
    public abstract List<Sala> buscarSalas() throws Exception;
    
}
