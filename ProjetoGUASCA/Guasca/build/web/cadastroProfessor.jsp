<%-- 
    Document   : cadastroProfessor
    Created on : 17/09/2014, 01:16:12
    Author     : Douglas
--%>

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
        <form action="ControleProfessor" class="formularioBasico" name="formCadastroProf">
            <input type="hidden" name="action" value="cadastrarProfessor"/>
            <fieldset>
                <div class="rowElem">
                    <legend>Cadastro de Professor</legend>
                    <br>
                    <br>
                    <div class="rowElem"><label for="nomeProf">Nome:</label><input type="text" name="nomeProf" /></div>
                    <div class="rowElem"><label for="matriculaProf">Matricula</label><input type="text" name="matriculaProf" /></div>
                    <br>
                    <div class="rowElem">
                        <label for="matriculaProf">Indisponibilidade:</label>
                        <table class="table1">
                            <%
                                String[] dias = new String[6];
                                dias[0] = "Seg";
                                dias[1] = "Ter";
                                dias[2] = "Qua";
                                dias[3] = "Qui";
                                dias[4] = "Sex";
                                dias[5] = "Sáb";
                                
                                String[] diasId = new String[6];
                                diasId[0] = "Seg";
                                diasId[1] = "Ter";
                                diasId[2] = "Qua";
                                diasId[3] = "Qui";
                                diasId[4] = "Sex";
                                diasId[5] = "Sab";
                            %>
                            <thead>
                                <tr>
                                    <%
                                        for (int tHlinha = 0; tHlinha < 1; tHlinha++) {
                                            for (int tHcoluna = 0; tHcoluna < 6; tHcoluna++) {
                                                if (tHcoluna == 0) {
                                    %>
                                    <th></th>
                                    <%                                        }
                                    %>
                                    <th><%= dias[tHcoluna]%></th>
                                    <%

                                            }
                                        }
                                    %>
                                </tr>
                            </thead>
                            <tbody>
                                <%
                                    char[] turnos = new char[3];
                                    int[] valores = new int[6];
                                    String[][] indispVals = new String[3][6];

                                    for (int i = 0; i < valores.length; i++) {
                                        valores[i] = i;
                                    }
                                    turnos[0] = 'M';
                                    turnos[1] = 'T';
                                    turnos[2] = 'N';
                                    StringBuilder idSelect = new StringBuilder();
                                    for (int tBlinha = 0; tBlinha < 3; tBlinha++) {
                                %>
                                <tr>
                                    <%
                                        for (int tBcoluna = 0; tBcoluna < 7; tBcoluna++) {
                                            if (tBcoluna == 0) {
                                    %>
                                    <th scope="row"><%= turnos[tBlinha]%></th>
                                    <%
                                    } else {
                                        idSelect.append(diasId[tBcoluna - 1]);
                                        idSelect.append(turnos[tBlinha]);
                                    %>

                                    <td>

                                        <select id="<%= idSelect%>" name="<%= idSelect%>">
                                            <%
                                                for (int i = 0; i < valores.length; i++) {
                                            %>
                                            <option value="<%= valores[i]%>">
                                                <%= valores[i]%>
                                            </option>
                                            <%
                                                }
                                            %>
                                        </select>


                                    </td>
                                    <%
                                                idSelect.setLength(0);
                                            }
                                        }
                                    %>
                                <tr>
                                    <%
                                        }
                                    %>
                            </tbody>
                        </table>
                    </div>
                    <br>
                    <label for="labelArea">
                        Área:
                    </label>
                    <select name="area">
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
                </div>
                <br>
                <div class="rowElem">
                    <input type="submit" value="Cadastrar" class="botaoForm"/>
                    <input type="reset" value="Cancelar" class="botaoForm" />
                </div>
            </fieldset>
        </form>
    </body>
</html>
