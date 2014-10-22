/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package guasca.modelo;

/**
 *
 * @author Paula
 */
public class Disciplina {
    private String descricao;
    private int idDisciplina;

    public Disciplina() {
    }

    public Disciplina(int idDisciplina, String descricao) {
        this.descricao = descricao;
        this.idDisciplina = idDisciplina;
    }

    public Disciplina(String descricao) {
        this.descricao = descricao;
    }
    
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getIdDisciplina() {
        return idDisciplina;
    }

    public void setIdDisciplina(int idDisciplina) {
        this.idDisciplina = idDisciplina;
    }
}
