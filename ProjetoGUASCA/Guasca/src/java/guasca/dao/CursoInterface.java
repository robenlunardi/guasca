/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package guasca.dao;

import guasca.modelo.Curso;
import java.util.List;

/**
 *
 * @author Douglas
 */
public interface CursoInterface {

    public abstract void cadastrarCurso(Curso novo) throws Exception;

    public abstract void atualizarCurso(int idCurso) throws Exception;

    public abstract void deletarCurso(int idCurso) throws Exception;

    public abstract List<Curso> buscarCursos() throws Exception;

    public abstract List<Curso> buscarCurso(int idCurso) throws Exception;
    
}
