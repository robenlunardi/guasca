/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package guasca.dao;

import guasca.modelo.Area;
import java.util.List;

/**
 *
 * @author Douglas
 */
public interface AreaInterface {
    public abstract void cadastrarArea(Area nova) throws Exception;
    public abstract void atualizarArea(int idArea) throws Exception;
    public abstract void deletarArea(int idArea) throws Exception;
    public abstract List<Area> buscarAreas() throws Exception;
    public abstract List<Area> buscarAreasProfessor(int idProf) throws Exception;
}