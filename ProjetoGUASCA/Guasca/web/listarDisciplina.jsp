<%-- 
    Document   : listarDisciplina
    Created on : 26/11/2014, 10:38:17
    Author     : 4DS
--%>

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
            <form action="ControleSala2">
                <input type="hidden" name="action" value="listarSala"/>
                <fieldset class="fieldsetForm">
                    <legend>Lista de sala</legend>
                    <br>    

                    <table class="tabelaListasala" border="1">
                        <thead>
                        <td id="nomeSala" class="colunaDuzentos">Nome</td>
                        <td id="tipoSala">Tipo</td>
                        <td id="quantidadeAlunos">Capacidade</td>
                        <td id="Acoes">Ações</td>
                        </thead>
                        <tbody>
                            <%
                                List<Sala> lista = (List<Sala>) request.getAttribute("listasala");
                                for (int i = 0; i < lista.size(); i++) {
                                    Sala sal = lista.get(i);
                            %>
                            <tr>
                                <td headers="nomeSala"><% out.print(sal.getNome());%></td>
                                <td headers="tipoSala"><% out.print(sal.getTpSala().getDescricao());%></td>
                                <td headers="quantidadeAlunos"><% out.print(sal.getQuantAlunos());%></td>
                                <td headers="Acoes" class="colunaAcoes">
                                    <a href="ControleSala2?action=atualizarSala&idSala=<%= sal.getIdSala()%>">Editar</a>
                                    <a href="ControleSala2?action=ExcluirSala&idSala=<%= sal.getIdSala()%>">Excluir</a>
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

