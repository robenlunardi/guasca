<%-- 
    Document   : listarProfessor
    Created on : 26/11/2014, 10:35:19
    Author     : 4DS
--%>

<%@page import="guasca.modelo.Professor"%>
<%@page import="guasca.modelo.Sala"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="includes.jsp" %>
        <title>JSP Page</title>
    </head>
    <body>
        <div id="menu" class="menuLateral">
            <%@include file="menuAdmin.jsp" %>
        </div>
        <div id="conteudo" class="conteudoCentro">
            <form action="ControleProfessor">
                <input type="hidden" name="action" value="listarProfessor"/>
                <fieldset class="fieldsetForm">
                    <legend>Lista de Professores</legend>
                    <br>    

                    <table class="tabelaListaprofessor" border="1">
                        <thead>
                        <td id="nomeProf" class="colunaDuzentos">Nome</td>
                        <td id="matriculaProf">Matricula</td>
                        <td id="emailProf">E-mail</td>
                        <td id="Acoes">Ações</td>
                        </thead>
                        <tbody>
                            <%
                                List<Professor> lista = (List<Professor>) request.getAttribute("listaprofessor");
                                for (int i = 0; i < lista.size(); i++) {
                                    Professor prof = lista.get(i);
                            %>
                            <tr>   
                                <td headers="matriculaProf"><% out.print(prof.getMatricula());%></td>
                                <td headers="nomeProf"><% out.print(prof.getNome());%></td>
                                <td headers="emailProf"><% out.print(prof.getEmail());%></td>
                                <td headers="Acoes" class="colunaAcoes">
<!--                                    <a href="ControleProfessor?action=atualizarSala&idSala=<>">Editar</a>
                                    <a href="ControleProfessor?action=ExcluirSala&idSala=<>">Excluir</a>-->
                            </tr>
                            <%
                                }
                            %>
                        </tbody>
                    </table>
                </fieldset>
            </form>    
        </div>
    </body>
</html>

