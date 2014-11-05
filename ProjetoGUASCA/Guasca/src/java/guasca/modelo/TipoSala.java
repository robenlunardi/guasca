/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package guasca.modelo;

/**
 *
 * @author Paula
 */
public class TipoSala {
    private String descricao;
    private int idTipoSala;
    
    public TipoSala(){    
    }

    public TipoSala(int idTipoSala, String descricao) {
        this.descricao = descricao;
        this.idTipoSala = idTipoSala;
    }

    public TipoSala(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getIdTipoSala() {
        return idTipoSala;
    }

    public void setIdTipoSala(int idTipoSala) {
        this.idTipoSala = idTipoSala;
    }
    
}
