/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package guasca.controle;

import guasca.controle.ferramentas.DiasSemana;
import guasca.dao.AreaDao;
import guasca.modelo.Area;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
@WebServlet(name = "ControleGeral", urlPatterns = {"/ControleGeral"})
public class ControleGeral extends HttpServlet {

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

            String formulario = request.getParameter("formulario");

            if (formulario.equals("cadastroArea")) {

                request.getRequestDispatcher("cadastroArea.jsp").forward(request, response);

            } else if (formulario.equals("cadastroProfessor")) {
                List<Area> listaAreas = new ArrayList<Area>();
                AreaDao aDao = new AreaDao();
                listaAreas = aDao.buscarAreas();
                
                String[][] diasTurnos = new String[3][6];
                
                DiasSemana dias = new DiasSemana();
                diasTurnos = dias.concatenarDiaTurno();
                
                request.setAttribute("listaAreas", listaAreas);
                request.setAttribute("listaDiasTurnos", diasTurnos);
                request.getRequestDispatcher("cadastroProfessor.jsp").forward(request, response);
            } else  if (formulario.equals("cadastroSala")) {

                request.getRequestDispatcher("cadastroSala.jsp").forward(request, response);

            } else  if (formulario.equals("consultaDisponibilidadeSala")) {

                request.getRequestDispatcher("consultarDisponibilidadeSalas.jsp").forward(request, response);

            } else  if (formulario.equals("listarSala")) {
                request.getRequestDispatcher("ControleSala2?action=listarSala").forward(request, response);
                request.getRequestDispatcher("listarSala.jsp").forward(request, response);

            }
            else {
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
