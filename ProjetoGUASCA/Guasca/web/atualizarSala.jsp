<%--
    Document   : atualizarSala
    Created on : 24/10/2014, 09:14:22
    Author     : Cleiton
--%>

<%@page import="guasca.modelo.TipoSala"%>
<%@page import="java.util.List"%>
<%@page import="guasca.modelo.Sala"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/estilos-gerais.css" />
        <%@include file="includes.jsp" %>
        <title>Atualizar Sala</title>
    </head>
    <body>
        <%
            Sala x = (Sala) request.getAttribute("salaAtual");

        %>
        <div id="menu" class="menuLateral">
            <%@include file="menuAdmin.jsp" %>
        </div>
        <div id="conteudo" class="conteudoCentro">

            <form action="ControleSala2">
                <input type="hidden" name="action" value="atualizar"/>
                <fieldset class="fieldsetForm">
                    <legend>Atualizar sala</legend>

                    <br>
                    <input type="hidden" name="idSala" value="<%= x.getIdSala()%>">
                    <label for="nomeSala">
                        Nome:
                    </label>
                    <input type="text" id="nomeSala" name="nomeSala" value="<%= x.getNome()%>"><br><br>

                    <br>

                    <br>

                    <%
                        List<TipoSala> tpLista = (List<TipoSala>) request.getAttribute("listaTipoSala");
                    %>
                    <label for="optionTipoSala">
                        Tipo de Sala:
                    </label>
                    <select id="optionTipoSala" name="optionTipoSala">
                        <%
                            if (tpLista.size() == 0) {
                        %>
                        <option value="-1">Inexiste um Tipo de Sala</option>
                        <%
                        } else {
                        %>
                        <option value="0">Selecione:</option>
                        <%
                            for (int i = 0; i < tpLista.size(); i++) {
                        %>
                        <option value="<%= tpLista.get(i).getIdTipoSala()%>">
                            <%= tpLista.get(i).getDescricao()%>
                        </option>
                        <%
                                }
                            }
                        %>
                    </select>              
                    <br>
                    <br>
                    <br>
                    <label for="quantidadeAlunos">
                        Quantidade de Alunos:
                    </label>
                    <input type="text" id="quantidadeAlunos" name="quantidadeAlunos" value="<%= x.getQuantAlunos()%>"><br><br>
                    <br>

                    <input class="botaoForm" type="submit" value="Atualizar">

                </fieldset>
            </form>
        </div>
    </body>
</html>


