/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package guasca.modelo;

/**
 *
 * @author Douglas
 */
public class Area {
    private String descricao;
    private int idArea;

    public Area() {
    }

    public Area(int idArea, String descricao) {
        this.idArea = idArea;
        this.descricao = descricao;
    }

    public Area(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getIdArea() {
        return idArea;
    }

    public void setIdArea(int idArea) {
        this.idArea = idArea;
    }
    
}
