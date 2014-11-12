<%--
    Document   : cadastroDisciplina
    Created on : 21/10/2014, 09:53:23
    Author     : Paula
--%>

<%@page import="guasca.modelo.TipoSala"%>
<%@page import="guasca.modelo.Professor"%>
<%@page import="guasca.modelo.Area"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="includes.jsp" %>
        <script type="text/javascript" type="text/javascript" src="js/ajaxListarProfArea.js"></script>
        <title>Cadastro de Disciplina</title>
    </head>
    <body onload="init()">
        <form action="ControleDisciplina" method="POST" name="formCadastroDisciplina" id="formCadastroDisciplina">
            <input type="hidden" name="action" value="cadastrarDisciplina"/>
            <fieldset>
                <legend>Cadastro de Disciplina</legend>
                <div class="rowElem">
                    <br>
                    <br>
                    <label for="nomeDisciplina">
                        Nome:
                    </label>
                    <input type="text" id="nomeDisciplina" name="nomeDisciplina"><br><br>
                    <label for="areaDisciplina">
                        Área do Professor:
                    </label>
                    <select name="areaDisciplina" id="areaDisciplina" onchange="return filtrarVeiculos(this);">
                        <option value="-1">Selecione:</option>
                        <%
                            List<Area> aLista = (List<Area>) request.getAttribute("listaAreas");
                            for (int i = 0; i < aLista.size(); i++) {

                        %>
                        <option value="<%= aLista.get(i).getIdArea()%>">
                            <%= aLista.get(i).getDescricao()%>
                        </option>
                        <%
                            }
                        %>
                    </select>
                    <br><br>
                    <div id="msg">
                    </div>
                    <%
                        List<TipoSala> tpLista = (List<TipoSala>) request.getAttribute("listaTipoSala");
                    %>
                    <br>
                    <br>
                    <label for="optionTipoSala">
                        Tipo de Sala 1:
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

                    <label for="creditos1">
                        Créditos:
                    </label>
                    <input type="text" id="creditos1" name="creditos1">
                    <br><br>
                    <label for="optionTipoSala2">
                        Tipo de Sala 2:
                    </label>
                    <select id="optionTipoSala2" name="optionTipoSala2">
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
                    <label for="creditos2">
                        Créditos:
                    </label>
                    <input type="text" id="creditos2" name="creditos2">
                    <br><br>
                    <label class="radioManha" for="manha" >
                        Turno:
                    </label>
                    <input type="radio" id="manha" name="turno" value="0"/>
                    <label class="radioManha" for="turno" >
                        Manhã
                    </label>
                    <input type="radio" id="tarde" name="turno" value="1"/>
                    <label class="radioTarde" for="turno">
                        Tarde
                    </label>
                    <input type="radio" id="noite" name="turno" value="2"/>
                    <label class="radioNoite" for="turno">
                        Noite
                    </label>
                    <br><br>
                    <label for="quantAlunos">
                        Quantidade Alunos
                    </label>
                    <input type="text" id="quantAlunos" name="quantAlunos" maxlength="2">
                    <br><br>
                    <input class="botaoForm" type="submit" value="Cadastrar">
                    <input class="botaoForm" type="button" value="Cancelar">
                </div>
            </fieldset>
        </form>
    </body>
</html>
