<%-- 
    Document   : listarDisciplina
    Created on : 26/11/2014, 10:38:17
    Author     : 4DS
--%>

<%@page import="guasca.modelo.Disciplina"%>
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
            <form action="ControleDisciplina">
                <input type="hidden" name="action" value="listardisciplina"/>
                <fieldset class="fieldsetForm">
                    <legend>Lista de Disciplina</legend>
                    <br>    

                    <table class="tabelaListadisciplina" border="1">
                        <thead>
                        <td id="nomeDisciplina" class="colunaDuzentos">Nome</td>
                        <td id="Acoes">Ações</td>
                        </thead>
                        <tbody>
                            <%
                                List<Disciplina> lista = (List<Disciplina>) request.getAttribute("listadisciplina");
                                for (int i = 0; i < lista.size(); i++) {
                                    Disciplina dis = lista.get(i);
                            %>
                            <tr>
                                <td headers="nomeDisciplina"><% out.print(dis.getNome());%></td>
                                <td headers="Acoes" class="colunaAcoes">
                                    <a href="ControleDisciplina?action=atualizarDisciplina&idDisciplina=<>">Editar</a>
                                    <a href="ControleDisciplina?action=ExcluirDisciplina&idDisciplina=<>">Excluir</a>
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

