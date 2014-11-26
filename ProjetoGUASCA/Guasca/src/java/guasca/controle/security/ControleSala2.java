/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package guasca.controle.security;

import guasca.dao.AreaDao;
import guasca.dao.CursoDao;
import guasca.dao.DisciplinaDao;
import guasca.dao.IndisponibilidadeDao;
import guasca.dao.ProfessorDao;
import guasca.dao.SalaDao;
import guasca.dao.TipoSalaDao;
import guasca.modelo.Area;
import guasca.modelo.Curso;
import guasca.modelo.Disciplina;
import guasca.modelo.Indisponibilidade;
import guasca.modelo.Professor;
import guasca.modelo.Sala;
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
                //cadastrar Sala
            if (action.equals("cadastrarSala")) {

                String nome = request.getParameter("nomeSala");
                int id_tipo_sala = Integer.parseInt(request.getParameter("optionTipoSala"));
                int quantAlunos = Integer.parseInt(request.getParameter("quantidadeAlunos"));

                Sala sal = new Sala();
                TipoSala tpSala = new TipoSala(id_tipo_sala);
                sal.setNome(nome);
                sal.setTpSala(tpSala);
                sal.setQuantAlunos(quantAlunos);

                SalaDao salaDao = new SalaDao();
                salaDao.cadastrarSala(sal);

                request.getRequestDispatcher("index.jsp").forward(request, response);
           //Atualizar Sala
            } else if (action.equals("atualizarSala")) {

                List<TipoSala> listaTipoSala = new ArrayList<TipoSala>();
                TipoSalaDao tpDao = new TipoSalaDao();
                listaTipoSala = tpDao.buscarTiposSalas();

                request.setAttribute("listaTipoSala", listaTipoSala);

                int idSala;

                idSala = Integer.parseInt(request.getParameter("idSala"));

                SalaDao salaDao = new SalaDao();

                Sala salaAtual;
                salaAtual = salaDao.buscarSala(idSala);

                request.setAttribute("salaAtual", salaAtual);
                //Sala x = (Sala)response.getAttribute("salaAtual");
                request.getRequestDispatcher("atualizarSala.jsp").forward(request, response);
                //listarr Sala     
            }else if (action.equals("atualizar")) {

                String nome = request.getParameter("nomeSala");
                int id_tipo_sala = Integer.parseInt(request.getParameter("optionTipoSala"));
                int quantAlunos = Integer.parseInt(request.getParameter("quantidadeAlunos"));
                int idSala = Integer.parseInt(request.getParameter("idSala"));

                SalaDao salaDao = new SalaDao();
                salaDao.atualizarSala(nome, quantAlunos, id_tipo_sala, idSala);

                request.getRequestDispatcher("ControleSala2?action=listarSala").forward(request, response);

            }else if (action.equals("ExcluirSala")) {
                int idSala = Integer.parseInt(request.getParameter("idSala"));
                
                SalaDao sdao = new SalaDao();
                sdao.deletarSala(idSala);
                
                request.getRequestDispatcher("ControleSala2?action=listarSala").forward(request, response);
                 // Parte de consulta ###############################
            }else if (action.equals("listarSala")) {  //listar sala  
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
            }else if (action.equals("listarArea")) {  //listar Area  
                try {

                    AreaDao adao = new AreaDao();
                    List<Area> lista = adao.buscarAreas();

                    request.setAttribute("listaarea", lista);
                    request.getRequestDispatcher("listarArea.jsp").forward(request, response);
                } catch (Exception e) {
                    System.out.println("Erro no log: " + e.getCause());
                    request.setAttribute("mensagem", e.getMessage());
                    request.getRequestDispatcher("index.jsp").forward(request, response);

                }

                throw new Exception("Página não localizada.");
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
            }else if (action.equals("listarDisciplina")) {  //listar Disciplina  
                try {

                    DisciplinaDao disdao = new DisciplinaDao();
                    List<Disciplina> lista = disdao.buscarDisciplinas();

                    request.setAttribute("listadisciplina", lista);
                    request.getRequestDispatcher("listarDisciplina.jsp").forward(request, response);
                } catch (Exception e) {
                    System.out.println("Erro no log: " + e.getCause());
                    request.setAttribute("mensagem", e.getMessage());
                    request.getRequestDispatcher("index.jsp").forward(request, response);

                }

                throw new Exception("Página não localizada.");
            }else if (action.equals("listarIndisponibilidade")) {  //listar Indisponibilidade  
                try {

                    IndisponibilidadeDao inddao = new IndisponibilidadeDao();
                    List<Indisponibilidade> lista = inddao.buscarIndisponibilidades();

                    request.setAttribute("listaindisponibilidade", lista);
                    request.getRequestDispatcher("listarIndisponibilidade.jsp").forward(request, response);
                } catch (Exception e) {
                    System.out.println("Erro no log: " + e.getCause());
                    request.setAttribute("mensagem", e.getMessage());
                    request.getRequestDispatcher("index.jsp").forward(request, response);

                }

                throw new Exception("Página não localizada.");
            }else if (action.equals("listarProfessor")) {  //listar Professor 
                try {

                    ProfessorDao prodao = new ProfessorDao();
                    List<Professor> lista = prodao.buscarProfessores();

                    request.setAttribute("listaprofessor", lista);
                    request.getRequestDispatcher("listarProfessor.jsp").forward(request, response);
                } catch (Exception e) {
                    System.out.println("Erro no log: " + e.getCause());
                    request.setAttribute("mensagem", e.getMessage());
                    request.getRequestDispatcher("index.jsp").forward(request, response);

                }

                throw new Exception("Página não localizada.");
            } else if(action.equals("cadastrarTipoSala")){  //cadastro do tipo de sala
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
