<%-- 
    Document   : cadastroProfessor
    Created on : 17/09/2014, 01:16:12
    Author     : Douglas
--%>

<%@page import="java.util.Collections"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="guasca.modelo.Area"%>
<%@page import="guasca.dao.AreaDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar Professor</title>
        <%@include file="includes.jsp" %>
    </head>
    <body>
        <div id="menu" class="menuLateral">
            <%@include file="menuAdmin.jsp" %>
        </div>
        <div id="conteudo" class="conteudoCentro">
            <form action="ControleProfessor" class="formularioBasico" name="formCadastroProf">
                <input type="hidden" name="action" value="cadastrarProfessor"/>
                <fieldset class="fieldsetForm">
                    <div class="rowElem">
                        <legend>Cadastro de Professor</legend>
                        <br>
                        <br>
                        <div class="rowElem"><label for="nomeProf">Nome:</label><input style="width: 180px;" type="text" name="nomeProf" /></div>
                        <br>
                        <div class="rowElem"><label for="matriculaProf">Matricula</label><input style="width: 180px;" type="text" name="matriculaProf" /></div>
                        <br>
                        <div class="rowElem"><label for="emailProf">E-mail</label><input style="width: 180px;" type="text" name="emailProf" /></div>
                        <br>
                        <label for="labelArea">
                            Área:
                        </label>
                        <%
                            List<Area> aLista = (List<Area>) request.getAttribute("listaAreas");

                            if (aLista.size() < 5) {
                        %>
                        <select name="area" size ="3" style="width: 180px;" multiple>
                            <%                        } else {
                            %>
                            <select name="area" size ="5" style="width: 180px;" multiple>
                                <%                            }
                                %>
                                <option value="-1" disabled>Selecione:</option>
                                <%

                                    for (int i = 0; i < aLista.size(); i++) {

                                %>
                                <option value="<%= aLista.get(i).getIdArea()%>">
                                    <%= aLista.get(i).getDescricao()%>
                                </option>
                                <%
                                    }
                                %>
                            </select>
                    </div>
                    <br>
                    <br>
                    <div class="rowElem">
                        <input type="submit" value="Cadastrar" class="botaoForm"/>
                        <input type="reset" value="Cancelar" class="botaoForm" />
                    </div>
                </fieldset>
            </form>
        </div>
    </body>
</html>
