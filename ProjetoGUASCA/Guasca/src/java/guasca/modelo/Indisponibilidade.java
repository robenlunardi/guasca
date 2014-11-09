/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package guasca.modelo;

/**
 *
 * @author Douglas
 */
public class Indisponibilidade {
    /* id_ind, dia, turno, valor, ano, periodo */
    private int idInd;
    private int dia;
    private int turno;
    private int valor;
    private int ano;
    /* semestre ou trimestre, não sabemos ainda o padrão */
    private int periodo;

    public Indisponibilidade(int idInd, int dia, int turno, int valor, int ano, int periodo) {
        this.idInd = idInd;
        this.dia = dia;
        this.turno = turno;
        this.valor = valor;
        this.ano = ano;
        this.periodo = periodo;
    }
    
    public Indisponibilidade(int dia, int turno, int valor, int ano, int periodo) {
        this.dia = dia;
        this.turno = turno;
        this.valor = valor;
        this.ano = ano;
        this.periodo = periodo;
    }

    public int getIdInd() {
        return idInd;
    }

    public void setIdInd(int idInd) {
        this.idInd = idInd;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getPeriodo() {
        return periodo;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }
    
}
