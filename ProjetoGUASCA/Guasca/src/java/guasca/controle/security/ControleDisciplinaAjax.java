/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package guasca.controle.security;

import guasca.dao.ProfessorDao;
import guasca.modelo.Professor;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Douglas
 */
@WebServlet(name = "ControleDisciplinaAjax", urlPatterns = {"/ControleDisciplinaAjax"})
public class ControleDisciplinaAjax extends HttpServlet {

    private ServletContext context;

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
            System.out.println("aqui");
        } catch (Exception e) {
            e.getMessage();
        } finally {
        }
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.context = config.getServletContext();
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
        response.setContentType("text/html;charset=UTF-8");
        try {
            int areaSelecionada = Integer.parseInt(request.getParameter("areaDisciplina"));
            ProfessorDao pDao = new ProfessorDao();
            List<Professor> lista = new ArrayList<Professor>();
            lista = pDao.buscarProfessoresPorArea(areaSelecionada);
            StringBuilder retorno = new StringBuilder();

            if (areaSelecionada < 0) {
            } else {
                if (lista.size() == 0) {
                    retorno.append("<span>Nenhum professor cadastrado com a Área selecionada</span><br><br>");
                } else if (lista.size() == 1) {
                    retorno.append("<label for=\"professor1\">Professor 1: </label>")
                            .append("<select name=\"professor1\"><option value=\"-1\">Selecione:</option>");
                    retorno.append("<option value=\"")
                            .append(lista.get(0).getIdProfessor())
                            .append("\">")
                            .append(lista.get(0).getNome())
                            .append("</option>");
                    retorno.append("</select><br><br>");
                } else if (lista.size() == 2) {
                    retorno.append("<label for=\"professor1\">Professor 1: </label>")
                            .append("<select name=\"professor1\"><option value=\"-1\">Selecione:</option>");
                    retorno.append("<option value=\"")
                            .append(lista.get(0).getIdProfessor())
                            .append("\">")
                            .append(lista.get(0).getNome())
                            .append("</option>");
                    retorno.append("</select>");
                    retorno.append("&nbsp&nbsp<label for=\"professor2\">Professor 2: </label>")
                            .append("<select name=\"professor2\"><option value=\"-1\">Selecione:</option>");
                    retorno.append("<option value=\"")
                            .append(lista.get(1).getIdProfessor())
                            .append("\">")
                            .append(lista.get(1).getNome())
                            .append("</option>");
                    retorno.append("</select><br><br>");
                } else {
                    retorno.append("<label for=\"professor1\">Professor 1: </label>")
                            .append("<select name=\"professor1\"><option value=\"-1\">Selecione:</option>")
                            .append("");
                    for (int i = 0; i < lista.size(); i++) {
                        retorno.append("<option value=\"")
                                .append(lista.get(i).getIdProfessor())
                                .append("\">")
                                .append(lista.get(i).getNome())
                                .append("</option>");
                    }
                    retorno.append("</select>");
                    retorno.append("&nbsp&nbsp<label for=\"professor2\">Professor 2: </label>")
                            .append("<select name=\"professor2\"><option value=\"-1\">Selecione:</option>")
                            .append("");
                    for (int i = 0; i < lista.size(); i++) {
                        retorno.append("<option value=\"")
                                .append(lista.get(i).getIdProfessor())
                                .append("\">")
                                .append(lista.get(i).getNome())
                                .append("</option>");
                    }
                    retorno.append("</select><br><br>");
                }
                response.getWriter().write(retorno.toString());
            }

            /*
             <label for="professor1">
             Professor 1:
             </label>
             <select name="professor1">
             <option value="-1">Selecione:</option>
             <%
             List<Professor> pLista = (List<Professor>) request.getAttribute("listaProfessores");
             for (int i = 0; i < pLista.size(); i++) {

             %>
             <option value="<%= pLista.get(i).getIdProfessor()%>">
             <%= pLista.get(i).getNome()%>
             </option>
             <%
             }
             %>
             </select>
             <label for="professor2">
             Professor 2:
             </label>
             <select name="professor2">
             <option value="-1">Selecione:</option>
             <%
             for (int i = 0; i < pLista.size(); i++) {

             %>
             <option value="<%= pLista.get(i).getIdProfessor()%>">
             <%= pLista.get(i).getNome()%>
             </option>
             <%
             }
             %>
             </select>
             */

        } catch (Exception e) {
            request.setAttribute("mensagem", e.getMessage());
            request.getRequestDispatcher("erro.jsp").forward(request, response);
        }
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
