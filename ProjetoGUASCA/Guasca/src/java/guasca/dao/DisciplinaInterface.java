/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package guasca.dao;

import guasca.modelo.Disciplina;
import java.util.List;

/**
 *
 * @author Paula
 */
public interface DisciplinaInterface {
    public abstract boolean cadastrarDisciplina(Disciplina nova) throws Exception;
    public abstract void atualizarDisciplina(int idDisciplina) throws Exception;
    public abstract void deletarDisciplina(int idDisciplina) throws Exception;
    public abstract List<Disciplina> buscarDisciplinas() throws Exception;
}