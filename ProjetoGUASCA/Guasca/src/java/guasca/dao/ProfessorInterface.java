/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package guasca.dao;

import guasca.modelo.Professor;
import java.util.List;

/**
 *
 * @author Paula
 */
public interface ProfessorInterface {
    public abstract void cadastrarProfessor(Professor nova) throws Exception;
    public abstract void atualizarProfessor(int idProfessor) throws Exception;
    public abstract void deletarProfessor(int idProfessor) throws Exception;
    public abstract List<Professor> buscarProfessores() throws Exception;
    public abstract Professor buscarProfessoresId(int id) throws Exception;
    public abstract List<Professor> buscarProfessoresSemProfHasInd() throws Exception;
    public abstract List<Professor> buscarProfessoresPorArea(int idArea) throws Exception;
}