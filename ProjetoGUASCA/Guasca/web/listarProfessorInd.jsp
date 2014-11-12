<%-- 
    Document   : listarProfessorInds
    Created on : 06/11/2014, 21:55:35
    Author     : Douglas
--%>

<%@page import="guasca.modelo.Professor"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Indisponibilidade: Lista de Professores</title>
        <%@include file="includes.jsp" %>
    </head>
    <body>
        <%@include file="menuAdmin.jsp" %>
        <br>
        <br>
        <form action="ControleSala2">
            <input type="hidden" name="action" value="listarSala"/>
            <fieldset>
                <legend>Indisponibilidade: Lista de Professores</legend>
                <br>    

                <table class="tabelaListasala" border="1">
                    <thead>
                    <td id="matriculaProf">Matricula</td>
                    <td id="nomeProf">Nome</td>
                    <td id="emailProf">E-mail</td>
                    <td id="Acoes">Ações</td>
                    </thead>
                    <tbody>
                        <%
                            List<Professor> lista = (List<Professor>) request.getAttribute("listaProf");
                            for (int i = 0; i < lista.size(); i++) {
                        %>
                        <tr>
                            <td headers="matriculaProf"><% out.print(lista.get(i).getMatricula());%></td>
                            <td headers="nomeProf"><% out.print(lista.get(i).getNome());%></td>                            
                            <td headers="emailProf"><% out.print(lista.get(i).getEmail());%></td>
                            <td headers="Acoes" class="colunaAcoes">
                                <a href="ControleInd?action=cadastroInd&id_prof=<%= lista.get(i).getIdProfessor() %>">Registrar</a>
                            </td>
                        </tr>
                        <%
                            }
                        %>
                    </tbody>
                </table>
            </fieldset>
        </form>                   
    </body>
</html>