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
                String nomeDisciplina = request.getParameter("nomeDisciplina");
                String professor1 = request.getParameter("professor1");
                String professor2 = request.getParameter("professor2");
                String areaDisciplina = request.getParameter("areaDisciplina");
                String tipoSala1 = request.getParameter("tipoSala1");
                String creditos1 = request.getParameter("creditos1");
                String tipoSala2 = request.getParameter("tipoSala2");
                String creditos2 = request.getParameter("creditos2");
                int turno = (Integer.parseInt(request.getParameter("turno")));
                String quantAlunos = request.getParameter("quantAlunos");

                Disciplina disciplina = new Disciplina();
                disciplina.setNome(nomeDisciplina);
                disciplina.setId_professor1(Integer.parseInt(professor1));
                disciplina.setId_professor2(Integer.parseInt(professor2));
                disciplina.setId_area(Integer.parseInt(areaDisciplina));
                disciplina.setTipo_sala1(tipoSala1);
                disciplina.setQtd_creditos1(Integer.parseInt(creditos1));
                disciplina.setTipo_sala2(tipoSala2);
                disciplina.setQtd_creditos2(Integer.parseInt(creditos2));
                disciplina.setTurno(turno);
                disciplina.setQtd_alunos(Integer.parseInt(quantAlunos));

                DisciplinaDao disciplinaDao = new DisciplinaDao();
                disciplinaDao.cadastrarDisciplina(disciplina);

                request.getRequestDispatcher("index.jsp").forward(request, response);

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
