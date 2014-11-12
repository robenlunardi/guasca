/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package guasca.controle.security;

import guasca.dao.AreaDao;
import guasca.dao.DisciplinaDao;
import guasca.dao.ProfessorDao;
import guasca.dao.TipoSalaDao;
import guasca.modelo.Area;
import guasca.modelo.Disciplina;
import guasca.modelo.Professor;
import guasca.modelo.TipoSala;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Paula
 */
@WebServlet(name = "ControleDisciplina", urlPatterns = {"/ControleDisciplina"})
public class ControleDisciplina extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {

            String action = request.getParameter("action");

            if (action.equals("cadastrarDisciplina")) {
                String seguranca = null;
                boolean bProf1 = false;
                boolean bProf2 = false;
                boolean bTipoSala2 = false;
                String nomeDisciplina;
                int areaDisciplina = 0;
                int turno;
                int qtdAlunos = 0;
                int tipoSala1 = 0;
                int credito1 = 0;
                int tipoSala2 = 0;
                int credito2 = 0;
                int professor1 = 0;
                int professor2 = 0;
                //nome obrigatorio


                nomeDisciplina = request.getParameter("nomeDisciplina");
                if (nomeDisciplina.equals("") || nomeDisciplina == null) {
                    request.setAttribute("mensagem", "Disciplina não cadastrada: nome indefinido.");
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                }

                //area obrigatorio
                seguranca = null;
                seguranca = request.getParameter("areaDisciplina");

                if (seguranca.equals("") || seguranca == null) {
                    request.setAttribute("mensagem", "Disciplina não cadastrada: nenhuma área foi seleiconada.");
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                } else {
                    areaDisciplina = Integer.parseInt(seguranca);
                    if (areaDisciplina <= 0) {
                        request.setAttribute("mensagem", "Disciplina não cadastrada: nenhuma área foi seleiconada.");
                        request.getRequestDispatcher("index.jsp").forward(request, response);
                    } else {
                        seguranca = null;
                        seguranca = request.getParameter("professor1");
                        if (!seguranca.equals("") || seguranca != null) {
                            professor1 = Integer.parseInt(request.getParameter("professor1"));
                            bProf1 = true;
                        }else{
                            //nada de erro
                        }
                        seguranca = null;
                        seguranca = request.getParameter("professor2");
                        if (!seguranca.equals("") || seguranca != null) {
                            professor2 = Integer.parseInt(request.getParameter("professor2"));
                            bProf2 = true;
                        }else{
                            //nada de erro
                        }

                    }
                }

                seguranca = null;
                seguranca = request.getParameter("optionTipoSala1");
                tipoSala1 = 0;
                if (seguranca.equals("") || seguranca == null) {
                    request.setAttribute("mensagem", "Disciplina não cadastrada: nenhum tipo de sala foi selecionado.");
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                } else {
                    tipoSala1 = Integer.parseInt(request.getParameter("optionTipoSala1"));
                    if (tipoSala1 <= 0) {
                        request.setAttribute("mensagem", "Disciplina não cadastrada: nenhum tipo de sala foi selecionado.");
                        request.getRequestDispatcher("index.jsp").forward(request, response);
                    }
                }

                seguranca = null;
                seguranca = request.getParameter("creditos1");
                credito1 = 0;
                if (seguranca.equals("") || seguranca == null) {
                    request.setAttribute("mensagem", "Disciplina não cadastrada: crédito indefinido.");
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                } else {
                    credito1 = Integer.parseInt(request.getParameter("optionTipoSala1"));
                    if (credito1 <= 0) {
                        request.setAttribute("mensagem", "Disciplina não cadastrada: crédito indefinido.");
                        request.getRequestDispatcher("index.jsp").forward(request, response);
                    } else {
                        credito1 = Integer.parseInt(request.getParameter("creditos1"));
                    }
                }

                seguranca = null;
                seguranca = request.getParameter("optionTipoSala2");
                tipoSala2 = 0;
                credito2 = 0;
                if (seguranca.equals("") || seguranca == null) {
                    //nada
                } else {
                    tipoSala1 = Integer.parseInt(request.getParameter("optionTipoSala2"));
                    if (tipoSala1 <= 0) {
                        //nada
                    } else {
                        seguranca = null;
                        seguranca = request.getParameter("creditos2");
                        credito2 = 0;
                        if (seguranca.equals("") || seguranca == null) {
                            //nada
                        } else {
                            credito2 = Integer.parseInt(request.getParameter("optionTipoSala2"));
                            if (credito2 <= 0) {
                            } else {
                                credito2 = Integer.parseInt(request.getParameter("creditos2"));
                                bTipoSala2 = true;
                            }
                        }
                    }

                }

                seguranca = null;
                seguranca = request.getParameter("quantAlunos");
                qtdAlunos = 0;
                if (seguranca.equals("") || seguranca == null) {
                    request.setAttribute("mensagem", "Disciplina não cadastrada: quantidade de alunos indefinida.");
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                } else {
                    qtdAlunos = Integer.parseInt(request.getParameter("quantAlunos"));
                    if (qtdAlunos <= 0) {
                        request.setAttribute("mensagem", "Disciplina não cadastrada: quantidade de alunos indefinida.");
                        request.getRequestDispatcher("index.jsp").forward(request, response);
                    }
                }

                turno = Integer.parseInt(request.getParameter("turno"));

                //public Disciplina(String nome, int id_area, int turno, int qtd_alunos, int tipo_sala1, int qtd_creditos1)
                Disciplina nova;
                if (bTipoSala2) {
                    nova = new Disciplina(
                            nomeDisciplina, areaDisciplina, turno, qtdAlunos, tipoSala1, credito1, tipoSala2, credito2);
                } else {
                    nova = new Disciplina(
                            nomeDisciplina, areaDisciplina, turno, qtdAlunos, tipoSala1, credito1);
                }
                if (bProf1) {
                    nova.setId_professor1(professor1);
                }
                if (bProf2) {
                    nova.setId_professor2(professor2);
                }
                
                DisciplinaDao dDao = new DisciplinaDao();
                if (dDao.cadastrarDisciplina(nova)) {
                    request.setAttribute("mensagem", "Disciplina cadastrada com sucesso.");
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                }

            } else if (action.equals("carregarListas")) {
                try {
                    List<Area> listaAreas = new ArrayList<Area>();
                    AreaDao aDao = new AreaDao();
                    listaAreas = aDao.buscarAreas();

                    List<Professor> listaProfessores = new ArrayList<Professor>();
                    ProfessorDao pDao = new ProfessorDao();
                    listaProfessores = pDao.buscarProfessores();

                    List<TipoSala> listaTipoSala = new ArrayList<TipoSala>();
                    TipoSalaDao tpDao = new TipoSalaDao();
                    listaTipoSala = tpDao.buscarTiposSalas();

                    request.setAttribute("listaProfessores", listaProfessores);
                    request.setAttribute("listaAreas", listaAreas);
                    request.setAttribute("listaTipoSala", listaTipoSala);
                    //request.setAttribute("listasala", lista);
                    request.getRequestDispatcher("cadastroDisciplina.jsp").forward(request, response);
                } catch (Exception e) {
                    System.out.println("Erro no log: " + e.getCause());
                    request.setAttribute("mensagem", e.getMessage());
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                }
            } else {
                throw new Exception("Página não localizada.");
            }
        } catch (Exception e) {
            System.out.println("Erro no log: " + e.getCause());
            request.setAttribute("mensagem", e.getMessage());
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
