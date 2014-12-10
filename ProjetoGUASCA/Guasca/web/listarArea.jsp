<%-- 
    Document   : listarArea
    Created on : 26/11/2014, 10:35:51
    Author     : 4DS
--%>

<%@page import="guasca.modelo.Area"%>
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
            <form action="ControleArea">
                <input type="hidden" name="action" value="listarArea"/>
                <fieldset class="fieldsetForm">
                    <legend>Lista de Area</legend>
                    <br>    

                    <table class="tabelaListaarea" border="1">
                        <thead>
                        <td id="descricaoArea" class="colunaDuzentos">Descrição</td>
                        <td id="Acoes">Ações</td>
                        </thead>
                        <tbody>
                            <%
                                List<Area> lista = (List<Area>) request.getAttribute("listaarea");
                                for (int i = 0; i < lista.size(); i++) {
                                    Area sal = lista.get(i);
                            %>
                            <tr>
                                <td headers="descricaoArea"><% out.print(sal.getDescricao());%></td>
                                <td headers="Acoes" class="colunaAcoes">
                                    <a href="ControleArea?action=atualizarArea&idArea=<>">Editar</a>
                                    <a href="ControleArea?action=ExcluirArea&idArea=<>">Excluir</a>
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

