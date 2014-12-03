<%-- 
    Document   : listarCurso
    Created on : 26/11/2014, 10:36:17
    Author     : 4DS
--%>

<%@page import="guasca.modelo.Curso"%>
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
            <form action="ControleCurso">
                <input type="hidden" name="action" value="listarCurso"/>
                <fieldset class="fieldsetForm">
                    <legend>Lista de Cursos</legend>
                    <br>    

                    <table class="tabelaListacurso" border="1">
                        <thead>
                        <td id="nomeCurso" class="colunaDuzentos">Nome</td>
                        <td id="Acoes">Ações</td>
                        </thead>
                        <tbody>
                            <%
                                List<Curso> lista = (List<Curso>) request.getAttribute("listacurso");
                                for (int i = 0; i < lista.size(); i++) {
                                    Curso sal = lista.get(i);
                            %>
                            <tr>
                                <td headers="nomeCurso"><% out.print(sal.getNome());%></td>
                                <td headers="Acoes" class="colunaAcoes">
<!--                                    <a href="ControleSala2?action=atualizarSala&idSala=<>">Editar</a>
                                    <a href="ControleSala2?action=ExcluirSala&idSala=<>">Excluir</a>-->
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

