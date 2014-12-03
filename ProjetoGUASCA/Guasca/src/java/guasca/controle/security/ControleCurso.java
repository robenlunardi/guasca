/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package guasca.controle.security;

import guasca.dao.AreaDao;
import guasca.dao.CursoDao;
import guasca.modelo.Curso;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Douglas
 */
@WebServlet(name = "ControleCurso", urlPatterns = {"/ControleCurso"})
public class ControleCurso extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */

            String action = request.getParameter("action");

            if (action.equals("cadastrarCurso")) {
                String nome = request.getParameter("nomeCurso");
                Curso curso = new Curso(nome);
                CursoDao cursoDao = new CursoDao();
                cursoDao.cadastrarCurso(curso);

                request.setAttribute("mensagem", "Curso cadastrado com sucesso.");
                request.getRequestDispatcher("index.jsp").forward(request, response);

            }else if (action.equals("listarCurso")) {  //listar Curso 
                try {

                    CursoDao curdao = new CursoDao();
                    List<Curso> lista = curdao.buscarCursos();

                    request.setAttribute("listacurso", lista);
                    request.getRequestDispatcher("listarCurso.jsp").forward(request, response);
                } catch (Exception e) {
                    System.out.println("Erro no log: " + e.getCause());
                    request.setAttribute("mensagem", e.getMessage());
                    request.getRequestDispatcher("index.jsp").forward(request, response);

                }

                throw new Exception("Página não localizada.");
            } else {
                throw new Exception("Página não localizada.");
            }

        } catch (Exception e) {
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
