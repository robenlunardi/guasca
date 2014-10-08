/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package guasca.modelo;

/**
 *
 * @author 4DS
 */
public class Sala {
    
     private int idSala;
    private String nome;
    private String tipo;
    private int quantAlunos;
   /* 
    public Sala(String nome, String numero, String tipo){
        this.nome = nome;
        this.tipo = tipo;
        this.numero = numero;
    }
    
     public Sala(int idSala, String nome, String tipo, String numero, int quantAlunos){
        this.idSala = idSala;
        this.nome = nome;
        this.tipo = tipo;
        this.numero = numero;
        this.quantAlunos = quantAlunos;
    }
*/
    public Sala() {
        
    }

    public Sala(int idSala, String nome) {
        this.idSala = idSala;
        this.nome = nome;
    }

    
    public int getIdSala() {
        return idSala;
    }

   
    public void setIdSala(int idSala) {
        this.idSala = idSala;
    }

   
    public String getNome() {
        return nome;
    }

    
    public void setNome(String nome) {
        this.nome = nome;
    }

    
    public String getTipo() {
        return tipo;
    }

    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    
    public int getQuantAlunos() {
        return quantAlunos;
    }

    
    public void setQuantAlunos(int quantAlunos) {
        this.quantAlunos = quantAlunos;
    }
    
}
