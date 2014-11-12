/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package guasca.controle.security;

import guasca.controle.ferramentas.Utilidades;
import guasca.dao.IndisponibilidadeDao;
import guasca.dao.ProfessorDao;
import guasca.modelo.Indisponibilidade;
import guasca.modelo.Professor;
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
@WebServlet(name = "ControleInd", urlPatterns = {"/ControleInd"})
public class ControleInd extends HttpServlet {

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
            if (action.equals("cadastroInd")) {
                String idProf = request.getParameter("id_prof");
                int id = Integer.parseInt(idProf);
                ProfessorDao pDao = new ProfessorDao();
                Professor prof = pDao.buscarProfessoresId(id);
                request.setAttribute("id_prof", prof.getIdProfessor());
                request.setAttribute("nome_prof", prof.getNome());
                request.getRequestDispatcher("cadastroInd.jsp").forward(request, response);
                /*
                 * <%
                 for (int tBcoluna = 0; tBcoluna < 7; tBcoluna++) {
                 if (tBcoluna == 0) {
                 %>
                 <th scope="row"><%= turnos[tBlinha]%></th>
                 <%
                 } else {
                 %>
                 <td>
                 <%
                 for (int i = 0; i < valores.length; i++) {
                 %>
                 <label for="<%= tBcoluna + i %>" ><%= i %></label>
                 <input type="radio" name="<%= tBcoluna %>" value="<%= i %>" />
                 <%
                 }
                 %>
                 </td>
                 <%                                            }
                 }
                 %>
                 * 
                 
                 */
            } else if (action.equals("registrarInd")) {
                int idProf = Integer.parseInt(request.getParameter("id_prof"));
                int ano = Integer.parseInt(request.getParameter("ano"));
                int semestre = Integer.parseInt(request.getParameter("semestre"));
                StringBuilder aux = new StringBuilder();
                int valor;
                Indisponibilidade ind;
                List<Indisponibilidade> listaInd = new ArrayList<Indisponibilidade>();

                for (int i = 0; i < 3; i++) {
                    for (int j = 1; j < 7; j++) {
                        aux.append("i")
                                .append(Integer.toString(i))
                                .append(Integer.toString(j));
                        System.out.println("Teste: " + aux.toString());
                        valor = Integer.parseInt(request.getParameter(aux.toString()));
                        //int dia, int turno, int valor, int ano, int periodo
                        ind = new Indisponibilidade(
                                j, i, valor, ano, semestre);
                        listaInd.add(ind);
                        aux.setLength(0);
                    }
                }
                
                IndisponibilidadeDao iDao = new IndisponibilidadeDao();
                iDao.cadastrarInds(idProf, listaInd);
                aux.setLength(0);
                aux.append("Indisponibilidade para ")
                   .append(Integer.toString(ano))
                   .append("/")
                   .append(Integer.toString(semestre))
                   .append(" registrada com sucesso.");
                request.setAttribute("mensagem", aux.toString());
                request.getRequestDispatcher("index.jsp").forward(request, response);
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
