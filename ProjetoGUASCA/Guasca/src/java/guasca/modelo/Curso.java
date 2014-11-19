/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package guasca.modelo;

/**
 *
 * @author Douglas
 */
public class Curso {

    private String nome;
    private int idCurso;

    public Curso() {
    }

    public Curso(int idCurso, String nome) {
        this.nome = nome;
        this.idCurso = idCurso;
    }

    public Curso(String nome) {
        this.nome = nome;
    }

    public Curso(int idCurso) {
        this.idCurso = idCurso;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }
    
}
