/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package guasca.controle;

import guasca.controle.ferramentas.DiasSemana;
import guasca.dao.AreaDao;
import guasca.dao.TipoSalaDao;
import guasca.modelo.Area;
import guasca.modelo.TipoSala;
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

            }else if(formulario.equals("cadastroTipoSala")){
                
                request.getRequestDispatcher("cadastroTipoSala.jsp").forward(request, response);
                
            }else if (formulario.equals("cadastroProfessor")) {
                request.getRequestDispatcher("ControleProfessor?action=carregarListas").forward(request, response);
            } else  if (formulario.equals("cadastroSala")) {
                
                List<TipoSala> listaTipoSala = new ArrayList<TipoSala>();
                TipoSalaDao tpDao = new TipoSalaDao();
                listaTipoSala = tpDao.buscarTiposSalas();
                
                request.setAttribute("listaTipoSala", listaTipoSala);
                request.getRequestDispatcher("cadastroSala.jsp").forward(request, response);

            } else  if (formulario.equals("consultaDisponibilidadeSala")) {

                request.getRequestDispatcher("consultarDisponibilidadeSalas.jsp").forward(request, response);
                    //listar
            } else  if (formulario.equals("listarSala")) {
                request.getRequestDispatcher("ControleSala2?action=listarSala").forward(request, response);
                //Atualizar Sala
            }else  if (formulario.equals("atualizarSala")) {
                request.getRequestDispatcher("ControleSala2?action=atualizarSala").forward(request, response);
                //excluir Sala
            }else  if (formulario.equals("ExcluirSala")) {
                request.getRequestDispatcher("ControleSala2?action=ExcluirSala").forward(request, response);
                 
            }else  if (formulario.equals("cadastroCurso")) {
                request.getRequestDispatcher("cadastroCurso.jsp").forward(request, response);
                 //Cadastrar disciplina
            }  else  if (formulario.equals("cadastroDisciplina")) {
                request.getRequestDispatcher("ControleDisciplina?action=carregarListas").forward(request, response);
            } else if(formulario.equals("listarProfessorInds")){
                request.getRequestDispatcher("ControleProfessor?action=listarProfessorInds").forward(request, response);
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
