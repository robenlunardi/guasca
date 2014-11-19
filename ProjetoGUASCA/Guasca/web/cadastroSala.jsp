<%-- 
    Document   : cadastroSala
    Created on : 07/10/2014, 16:15:18
    Author     : fernando
--%>

<%@page import="guasca.modelo.TipoSala"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/estilos-gerais.css" />
        <%@include file="includes.jsp" %>
        <title>Cadastro de Salas</title>
    </head>
    <body>
        <div id="menu" class="menuLateral">
            <%@include file="menuAdmin.jsp" %>
        </div>
        <div id="conteudo" class="conteudoCentro">
            <form action="ControleSala2" name="formCadastroSala" id="formCadastroSala" onsubmit="return validarSala();">
                <input type="hidden" name="action" value="cadastrarSala"/>
                <fieldset class="fieldsetForm">
                    <legend>Cadastro de sala</legend>
                    <br>
                    <label for="nomeSala">
                        Nome:
                    </label>
                    <input type="text" id="nomeSala" name="nomeSala"><br><br>

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
                        <%                        } else {
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
                    <input type="text" id="quantidadeAlunos" name="quantidadeAlunos"><br><br>
                    <br>

                    <input class="botaoForm" type="submit" value="Cadastrar">

                </fieldset>
            </form>
        </div>
    </body>
</html>

