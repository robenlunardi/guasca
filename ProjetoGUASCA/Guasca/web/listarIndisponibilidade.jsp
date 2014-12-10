<%-- 
    Document   : listarIndisponibilidade
    Created on : 26/11/2014, 10:37:42
    Author     : 4DS
--%>

<%@page import="guasca.modelo.Professor"%>
<%@page import="guasca.modelo.Indisponibilidade"%>
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
                <input type="hidden" name="action" value="listarIndisponibilidade"/>
                <fieldset class="fieldsetForm">
                    <legend>Lista de professores com alguma indisponibilidade</legend>
                    <br>    

                    <table class="tabelaListasala" border="1">
                        <thead>
                        <td id="nomeProf" class="colunaDuzentos">Nome</td>
                        <td id="Acoes">Ações</td>
                        </thead>
                        <tbody>
                            <%
                                List<Professor> lista = (List<Professor>) request.getAttribute("listaindisponibilidade");
                                for (int i = 0; i < lista.size(); i++) {
                                    Professor ind = lista.get(i);
                            %>
                            <tr>
                                <td headers="nomeProf"><% out.print(ind.getNome());%></td>
                                <td headers="Acoes" class="colunaAcoes">
                                    <a href="ControleInd?action=atualizarInd&idInd=<>">Editar</a>
                                    <a href="ControleInd?action=ExcluirInd&idInd=<>">Excluir</a>
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

