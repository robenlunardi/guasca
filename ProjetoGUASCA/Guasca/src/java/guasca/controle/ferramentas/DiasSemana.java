/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package guasca.controle.ferramentas;

/**
 *
 * @author Douglas
 */
public class DiasSemana {

    private String[] diasCabecalho = new String[6];
    private String[] diasIndex = new String[6];
    private char[] turnos = new char[3];

    public DiasSemana() {
        this.diasCabecalho = new String[6];
        this.diasIndex = new String[6];
        this.turnos = new char[3];

        this.diasCabecalho[0] = "Seg";
        this.diasCabecalho[1] = "Ter";
        this.diasCabecalho[2] = "Qua";
        this.diasCabecalho[3] = "Qui";
        this.diasCabecalho[4] = "Sex";
        this.diasCabecalho[5] = "Sáb";
        
        this.diasIndex[0] = "Seg";
        this.diasIndex[1] = "Ter";
        this.diasIndex[2] = "Qua";
        this.diasIndex[3] = "Qui";
        this.diasIndex[4] = "Sex";
        this.diasIndex[5] = "Sab";

        turnos[0] = 'M';
        turnos[1] = 'T';
        turnos[2] = 'N';

    }

    public String[] getDiasCabecalho() {
        return this.diasCabecalho;
    }
    
    public String[] getDias() {
        return this.diasIndex;
    }
    
    public char[] getTurnos() {
        return this.turnos;
    }
    
    public String[][] concatenarDiaTurno(){
        String[][] diaTurno = new String[3][6];
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < this.turnos.length; i++) {
            for (int j = 0; j < this.diasIndex.length; j++) {
                sb.append(this.diasIndex[j]);
                sb.append(this.turnos[i]);
                diaTurno[i][j] = sb.toString();
                sb.setLength(0);
            }
        }
        
        return diaTurno;
    }
    
}
