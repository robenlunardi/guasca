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

    private int id_disciplina;
    private int id_professor1;
    private int id_professor2;
    private int qtd_alunos;
    private int qtd_creditos1;
    private int qtd_creditos2;
    private String nome;

    public int getQtd_creditos1() {
        return qtd_creditos1;
    }

    public void setQtd_creditos1(int qtd_creditos1) {
        this.qtd_creditos1 = qtd_creditos1;
    }

    public int getQtd_creditos2() {
        return qtd_creditos2;
    }

    public void setQtd_creditos2(int qtd_creditos2) {
        this.qtd_creditos2 = qtd_creditos2;
    }
    private String turno;
    private String tipo_sala1;
    private String tipo_sala2;
    private int id_area;
    private int id_credito;

    public Disciplina() {
    }

    public Disciplina(int id_disciplina, String nome) {
        this.nome = nome;
        this.id_disciplina = id_disciplina;
    }

    public int getId_disciplina() {
        return id_disciplina;
    }

    public void setId_disciplina(int id_disciplina) {
        this.id_disciplina = id_disciplina;
    }

    public int getQtd_alunos() {
        return qtd_alunos;
    }

    public void setQtd_alunos(int qtd_alunos) {
        this.qtd_alunos = qtd_alunos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getTipo_sala1() {
        return tipo_sala1;
    }

    public void setTipo_sala1(String tipo_sala1) {
        this.tipo_sala1 = tipo_sala1;
    }

    public String getTipo_sala2() {
        return tipo_sala2;
    }

    public void setTipo_sala2(String tipo_sala2) {
        this.tipo_sala2 = tipo_sala2;
    }

    public int getId_area() {
        return id_area;
    }

    public void setId_area(int id_area) {
        this.id_area = id_area;
    }

    public int getId_credito() {
        return id_credito;
    }

    public void setId_credito(int id_credito) {
        this.id_credito = id_credito;
    }

    public int getId_professor1() {
        return id_professor1;
    }

    public void setId_professor1(int id_professor1) {
        this.id_professor1 = id_professor1;
    }

    public int getId_professor2() {
        return id_professor2;
    }

    public void setId_professor2(int id_professor2) {
        this.id_professor2 = id_professor2;
    }
}
