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
    private int id_curso;
    private String nome;
    private int id_area;
    private int turno;
    private int qtd_alunos;
    private int id_professor1;
    private int id_professor2;
    private int tipo_sala1;
    private int qtd_creditos1;
    private int tipo_sala2;
    private int qtd_creditos2;
    private int id_credito;
    private int id_credito2;

    //@@@revisar
    public Disciplina(int idDisciplina, String nomeDisciplina) {
        this.id_disciplina = idDisciplina;
        this.nome = nomeDisciplina;
    }
    
    public Disciplina(int idDisciplina, String nomeDisciplina, int credito1, int valor1) {
        this.id_disciplina = idDisciplina;
        this.nome = nomeDisciplina;
        this.id_credito = credito1;
        this.qtd_creditos1 = valor1;
        this.id_credito2 = -1;
        this.qtd_creditos2 = -1;
    }

    public Disciplina() {
        this.id_area = -1;
        this.id_disciplina = -1;
        this.turno = -1;
        this.qtd_alunos = -1;
        this.id_professor1 = -1;
        this.id_professor2 = -1;
        this.tipo_sala1 = -1;
        this.tipo_sala2 = -1;
        this.qtd_creditos1 = -1;
        this.qtd_creditos2 = -1;
        this.id_credito = -1;
        this.id_credito2 = -1;
    }

    public Disciplina(String nome, int id_curso, int id_area, int turno, int qtd_alunos, int tipo_sala1, int qtd_creditos1) {
        this.nome = nome;
        this.id_curso = id_curso;
        this.id_area = id_area;
        this.turno = turno;
        this.qtd_alunos = qtd_alunos;
        this.tipo_sala1 = tipo_sala1;
        this.qtd_creditos1 = qtd_creditos1;

        this.id_professor1 = -1;
        this.id_professor2 = -1;
        this.id_disciplina = -1;
        this.tipo_sala2 = -1;
        this.qtd_creditos2 = -1;
        this.id_credito = -1;
    }

    public Disciplina(String nome, int id_curso, int id_area, int turno, int qtd_alunos, int tipo_sala1, int qtd_creditos1, int tipo_sala2, int qtd_creditos2) {
        this.nome = nome;
        this.id_curso = id_curso;
        this.id_area = id_area;
        this.turno = turno;
        this.qtd_alunos = qtd_alunos;
        this.tipo_sala1 = tipo_sala1;
        this.qtd_creditos1 = qtd_creditos1;
        this.tipo_sala2 = tipo_sala2;
        this.qtd_creditos2 = qtd_creditos2;

        this.id_professor1 = -1;
        this.id_professor2 = -1;
        this.id_disciplina = -1;
        this.id_credito = -1;
    }

    public int getId_curso() {
        return id_curso;
    }

    public void setId_curso(int id_curso) {
        this.id_curso = id_curso;
    }

    public int getId_disciplina() {
        return id_disciplina;
    }

    public void setId_disciplina(int id_disciplina) {
        this.id_disciplina = id_disciplina;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId_area() {
        return id_area;
    }

    public void setId_area(int id_area) {
        this.id_area = id_area;
    }

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }

    public int getQtd_alunos() {
        return qtd_alunos;
    }

    public void setQtd_alunos(int qtd_alunos) {
        this.qtd_alunos = qtd_alunos;
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

    public int getTipo_sala1() {
        return tipo_sala1;
    }

    public void setTipo_sala1(int tipo_sala1) {
        this.tipo_sala1 = tipo_sala1;
    }

    public int getQtd_creditos1() {
        return qtd_creditos1;
    }

    public void setQtd_creditos1(int qtd_creditos1) {
        this.qtd_creditos1 = qtd_creditos1;
    }

    public int getTipo_sala2() {
        return tipo_sala2;
    }

    public void setTipo_sala2(int tipo_sala2) {
        this.tipo_sala2 = tipo_sala2;
    }

    public int getQtd_creditos2() {
        return qtd_creditos2;
    }

    public void setQtd_creditos2(int qtd_creditos2) {
        this.qtd_creditos2 = qtd_creditos2;
    }

    public int getId_credito() {
        return id_credito;
    }

    public void setId_credito(int id_credito) {
        this.id_credito = id_credito;
    }
    
    public int getId_credito2() {
        return id_credito2;
    }

    public void setId_credito2(int id_credito2) {
        this.id_credito2 = id_credito2;
    }    
    
}
