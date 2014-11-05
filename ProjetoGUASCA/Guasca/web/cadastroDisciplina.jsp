<%--
    Document   : cadastroDisciplina
    Created on : 21/10/2014, 09:53:23
    Author     : Paula
--%>

<%@page import="guasca.modelo.Professor"%>
<%@page import="guasca.modelo.Area"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/estilos-gerais.css" />
        <title>Cadastro de Disciplina</title>
    </head>
    <body>
        <form action="ControleDisciplina">
            <input type="hidden" name="action" value="cadastrarDisciplina"/>
            <fieldset>
                <legend>Cadastro de Disciplina</legend>
                <br>
                <label for="nomeDisciplina">
                    Nome:
                </label>
                <input type="text" id="nomeDisciplina" name="nomeDisciplina"><br><br>
                <label for="professor1">
                    Professor:
                </label>
                <select name="professor1">
                    <option value="-1">Selecione:</option>
                        <%
                            List<Professor> pLista = (List<Professor>) request.getAttribute("listaProfessores");
                            for (int i = 0; i < pLista.size(); i++) {

                        %>
                        <option value="<%= pLista.get(i).getIdProfessor()%>">
                            <%= pLista.get(i).getNome()%>
                        </option>
                </select>
                <label for="professor2">
                    Professor:
                </label>
                <select name="professor2">
                    <option value="-1">Selecione:</option>
                        <option value="<%= pLista.get(i).getIdProfessor()%>">
                            <%= pLista.get(i).getNome()%>
                        </option>
                        <%
                            }
                        %>
                </select>
                <label for="areaDisciplina">
                    Área:
                </label>
                <select name="areaDisciplina">
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
                <label for="tipoSala1">
                    Tipo de Sala 1:
                </label>
                <%@include file="includeTipoSala.jsp" %>
                <label for="creditos1">
                    Créditos:
                </label>
                <input type="text" id="creditos1" name="creditos1">
                <br><br>
                <label for="tipoSala2">
                    Tipo de Sala 2:
                </label>
                <select name="tipoSala2">
                    <%
                        for (int i = 0; i < tipoSala.length; i++) {
                    %>
                    <option value="<%= tipoSala[i]%>">
                        <%= tipoSala[i]%>
                    </option>
                    <%
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
                <label class="radioManha" for="manha" >
                    Manhã
                </label>
                <input type="radio" id="tarde" name="turno" value="1"/>
                <label class="radioTarde" for="Tarde">
                    Tarde
                </label>
                <input type="radio" id="noite" name="turno" value="2"/>
                <label class="radioNoite" for="Noite">
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
            </fieldset>
        </form>
    </body>
</html>
