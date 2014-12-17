/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package guasca.controle.gradehorarios;

import guasca.modelo.Disciplina;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author Douglas
 */
public class AlgoritmoGrade {

    private int[][] grade = new int[5][5];
    private Disciplina[][] gradeCompleta = new Disciplina[5][5];
    private List<Disciplina> listaDisciplina;
    private LinkedList<Disciplina> listaLigadaDisciplina;

    public AlgoritmoGrade(List<Disciplina> listaDisciplina) {
        this.listaDisciplina = listaDisciplina;
        listaLigadaDisciplina = new LinkedList();
        zerarGrade();
    }

    public void geraListaLigadaDisciplina() {
        listaLigadaDisciplina.clear();
        for (int i = 0; i < listaDisciplina.size(); i++) {
            listaLigadaDisciplina.addLast(listaDisciplina.get(i));
        }
        for (int i = 0; i < listaLigadaDisciplina.size(); i++) {
            if (listaLigadaDisciplina.get(i).getQtd_creditos1() > 3) {
                listaLigadaDisciplina.get(i).setQtd_creditos1(listaLigadaDisciplina.get(i).getQtd_creditos1() / 2);
                listaLigadaDisciplina.addFirst(listaLigadaDisciplina.get(i));
            }
        }
        baguncaListaLigada();
    }

    public void baguncaListaLigada() {
        Collections.shuffle(listaLigadaDisciplina);
    }
    /** Método onde são comparados a quantidade de créditos da disciplina com os do dia.
     * 
     * @param dia Dia para comparação.
     * @param periodoAtual Periodo da grade para verificação.
     * @param quantidade Quantidade de periodos da disciplina.
     */
    public boolean verificaSeCabe(int dia, int periodoAtual, int quantidade) {
        boolean retorno = false;

        if ((quantidade + periodoAtual) <= grade[dia].length) {
            for (int i = periodoAtual; i < grade[dia].length; i++) {
                if (grade[dia][i] > 0) {
                    retorno = false;
                    break;
                } else {
                    retorno = true;
                }
            }
        }

        return retorno;
    }
    /** Método onde as disciplinas são inseridas na grade de horários.
     * 
     */
    public boolean insereNaGrade() {
        boolean retorno = false;
        boolean chaveR = false;
        try {
            for (int i = 0; i < listaLigadaDisciplina.size(); i++) {
                if (chaveR) {
                    break;
                }
                for (int j = 0; j < grade.length; j++) {
                    if (chaveR) {
                        break;
                    }
                    for (int k = 0; k < grade[j].length; k++) {
                        if (verificaSeCabe(j, k, listaLigadaDisciplina.get(i).getQtd_creditos1())) {
                            for (int l = k; l < (k + listaLigadaDisciplina.get(i).getQtd_creditos1()); l++) {
                                grade[j][l] = listaLigadaDisciplina.get(i).getId_disciplina();
                            }

                            listaLigadaDisciplina.remove();
                            chaveR = true;
                            break;
                        }
                    }
                }
            }

            if (listaLigadaDisciplina.isEmpty()) {
                System.out.println("@@@@@@@@@@@@FOI TUDO!!!!");
                retorno = true;
            }

        } catch (Exception e) {
            System.out.println("@@@Errou:");
            e.getMessage();
        }
        return retorno;
    }
    /** Método onde serão feitas as tentativas de gerar uma grade de horários que atenda aos requisitos.
     * 
     */
    public void gerarGrade() {
        geraListaLigadaDisciplina();
        int controle = 0;
        while (!insereNaGrade()) {
            System.out.printf("Tentativa: %d\n", controle);
            controle++;
            if (controle == 1000) {
                geraListaLigadaDisciplina();
                zerarGrade();
                controle = 0;
            }
        }
    }

    public void zerarGrade() {
        for (int i = 0; i < grade.length; i++) {
            for (int j = 0; j < grade[i].length; j++) {
                grade[i][j] = 0;
            }
        }
    }

    public int[][] getGrade() {
        return grade;
    }

    public void setGrade(int[][] grade) {
        this.grade = grade;
    }
   
    public Disciplina[][] getGradeCompleta() {
        geraListaLigadaDisciplina();

        Disciplina aux;
        aux = new Disciplina();
        aux.setNome("--vazio--");
        for (int i = 0; i < grade.length; i++) {
            for (int j = 0; j < grade[i].length; j++) {
                this.gradeCompleta[i][j] = aux;
            }
        }

        for (int i = 0; i < grade.length; i++) {
            for (int j = 0; j < grade[i].length; j++) {
                this.gradeCompleta[i][j] = achaDisciplinaNaLista(grade[i][j]);
                if(this.gradeCompleta[i][j] == null){
                    this.gradeCompleta[i][j] = aux;
                }
            }
        }

        return this.gradeCompleta;
    }
    /** Método para buscar uma disciplina em uma lista.
     * 
     * @param id Id da disciplina para busca.
     * @return Uma disciplina.
     */
    private Disciplina achaDisciplinaNaLista(int id) {
        Disciplina retorno = null;
        for (int i = 0; i < this.listaLigadaDisciplina.size(); i++) {
            if (this.listaLigadaDisciplina.get(i).getId_disciplina() == id) {
                retorno = this.listaLigadaDisciplina.get(i);
                break;
            }
        }
        return retorno;
    }
}
