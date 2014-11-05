/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package guasca.controle.security;

import guasca.dao.SalaDao;
import guasca.dao.TipoSalaDao;
import guasca.modelo.Sala;
import guasca.modelo.TipoSala;
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
 * @author Aluno
 */
@WebServlet(name = "ControleSala2", urlPatterns = {"/ControleSala2"})
public class ControleSala2 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
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

            if (action.equals("cadastrarSala")) {

                String nome = request.getParameter("nomeSala");
                int id_tipo_sala = Integer.parseInt(request.getParameter("optionTipoSala"));
                int quantAlunos = Integer.parseInt(request.getParameter("quantidadeAlunos"));

                Sala sal = new Sala();
                sal.setNome(nome);
                sal.setIdTipoSala(id_tipo_sala);
                sal.setQuantAlunos(quantAlunos);

                SalaDao salaDao = new SalaDao();
                salaDao.cadastrarSala(sal);

                request.getRequestDispatcher("index.jsp").forward(request, response);
            } else if (action.equals("listarSala")) {// Parte de consulta ###############################
                try {

                    SalaDao sdao = new SalaDao();
                    List<Sala> lista = sdao.buscarSalas();

                    request.setAttribute("listasala", lista);
                    request.getRequestDispatcher("listarSala.jsp").forward(request, response);
                } catch (Exception e) {
                    System.out.println("Erro no log: " + e.getCause());
                    request.setAttribute("mensagem", e.getMessage());
                    request.getRequestDispatcher("index.jsp").forward(request, response);

                }

                throw new Exception("Página não localizada.");
            }else if(action.equals("cadastrarTipoSala")){
                String descricao = request.getParameter("descricaoTipoSala");
                TipoSala tipoSala = new TipoSala(descricao);
                TipoSalaDao tipoSalaDao = new TipoSalaDao();
                tipoSalaDao.inserirTipoSala(tipoSala);
                
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }

        } catch (Exception e) {
            System.out.println("Erro no log: " + e.getCause());
            request.setAttribute("mensagem", e.getMessage());
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
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
     * Handles the HTTP <code>POST</code> method.
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
