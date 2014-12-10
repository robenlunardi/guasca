/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package guasca.modelo;

import java.util.List;

/**
 *
 * @author Douglas
 */
public class Professor {
    
    private int idProfessor;
    private String matricula;
    private String nome;
    private String email;
    private List<Area> listaArea;
    private List<Indisponibilidade> listaInds;

    public Professor(int idProfessor, List<Indisponibilidade> listaInds) {
        this.idProfessor = idProfessor;
        this.listaInds = listaInds;
    }

    public Professor(int idProfessor){
        
    }
    
    public Professor(int idProfessor, String nome) {
        this.nome = nome;
        this.idProfessor = idProfessor;
    }
    
    public Professor(String matricula, String nome, String email) {
        this.matricula = matricula;
        this.nome = nome;
        this.email = email;
    }
    
    public Professor(String matricula, String nome, String email, List<Area> listaArea) {
        this.idProfessor = idProfessor;
        this.matricula = matricula;
        this.nome = nome;
        this.email = email;
        this.listaArea = listaArea;
    }    

    public Professor(int idProfessor, String matricula, String nome, String email) {
        this.idProfessor = idProfessor;
        this.matricula = matricula;
        this.nome = nome;
        this.email = email;
    }
    
    public Professor(int idProfessor, String matricula, String nome, String email, List<Area> listaArea) {
        this.idProfessor = idProfessor;
        this.matricula = matricula;
        this.nome = nome;
        this.email = email;
        this.listaArea = listaArea;
    }

    public Professor(int idProfessor, String matricula, String nome, String email, List<Area> listaArea, List<Indisponibilidade> listaInds) {
        this.idProfessor = idProfessor;
        this.matricula = matricula;
        this.nome = nome;
        this.email = email;
        this.listaArea = listaArea;
        this.listaInds = listaInds;
    }
        
    public int getIdProfessor() {
        return idProfessor;
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
    
    public List<Area> getListaArea() {
        return listaArea;
    }

    public void setListaArea(List<Area> listaArea) {
        this.listaArea = listaArea;
    }

    public List<Indisponibilidade> getListaInds() {
        return listaInds;
    }

    public void setListaInds(List<Indisponibilidade> listaInds) {
        this.listaInds = listaInds;
    }
    
}
