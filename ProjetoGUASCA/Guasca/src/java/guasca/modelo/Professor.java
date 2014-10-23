/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package guasca.modelo;

/**
 *
 * @author Douglas
 */
public class Professor {
    
    private int idProfessor;
    private String matricula;
    private String nome;
    private String email;
    private int idIndisponibilidade;

    public int getIdProfessor() {
        return idProfessor;
    }

    public Professor(String matricula, String nome, String email) {
        this.matricula = matricula;
        this.nome = nome;
        this.email = email;
    }
    
    public Professor(int idProfessor, String nome) {
        this.nome = nome;
        this.idProfessor = idProfessor;
    }

    public Professor(int idProfessor, String matricula, String nome, String email, int idIndisponibilidade) {
        this.idProfessor = idProfessor;
        this.matricula = matricula;
        this.nome = nome;
        this.email = email;
        this.idIndisponibilidade = idIndisponibilidade;
    }    

    public void setIdProfessor(int idProfessor) {
        this.idProfessor = idProfessor;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdIndisponibilidade() {
        return idIndisponibilidade;
    }

    public void setIdIndisponibilidade(int idIndisponibilidade) {
        this.idIndisponibilidade = idIndisponibilidade;
    }    
    
}
