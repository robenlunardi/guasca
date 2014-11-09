/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package guasca.controle.security;

import guasca.controle.ferramentas.DiasSemana;
import guasca.dao.AreaDao;
import guasca.dao.ProfessorDao;
import guasca.modelo.Area;
import guasca.modelo.Professor;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Douglas
 */
public class ControleProfessor extends HttpServlet {

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
            
            if(action.equals("cadastrarProfessor")){
                String matricula = request.getParameter("matriculaProf");
                String nome = request.getParameter("nomeProf");
                String email = request.getParameter("emailProf");
                String[] idArea = request.getParameterValues("area");
                List<Area> listaIdArea = new ArrayList<Area>();
                Area area = null;
                for (int i = 0; i < idArea.length; i++) {
                    area = new Area(Integer.parseInt(idArea[i]));
                    listaIdArea.add(area);
                }
                
                /*
                String[][] diasTurnos = new String[3][6];
                int[][] inds = new int[3][6];
                
                DiasSemana dias = new DiasSemana();
                diasTurnos = dias.concatenarDiaTurno();
                
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 6; j++) {
                        inds[i][j] = Integer.parseInt(request.getParameter(diasTurnos[i][j]));
                    }
                }
                */
                Professor prof = new Professor(matricula, nome, email, listaIdArea);                
                ProfessorDao pDao = new ProfessorDao();
                pDao.cadastrarProfessor(prof);
                request.setAttribute("mensagem", "Professor cadastrado com sucesso.");
                request.getRequestDispatcher("index.jsp").forward(request, response);
                
            }else if(action.equals("carregarListas")){
                                List<Area> listaAreas = new ArrayList<Area>();
                AreaDao aDao = new AreaDao();
                listaAreas = aDao.buscarAreas();
                
                String[][] diasTurnos = new String[3][6];
                
                DiasSemana dias = new DiasSemana();
                diasTurnos = dias.concatenarDiaTurno();
                
                request.setAttribute("listaAreas", listaAreas);
                request.setAttribute("listaDiasTurnos", diasTurnos);
                request.getRequestDispatcher("cadastroProfessor.jsp").forward(request, response);
                
            }else if(action.equals("listarProfessorInds")){
                ProfessorDao pDao = new ProfessorDao();
                List<Professor> lista = pDao.buscarProfessoresSemProfHasInd();
                request.setAttribute("listaProf", lista);
                request.getRequestDispatcher("listarProfessorInd.jsp").forward(request, response);

            }else{
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
