<%-- 
    Document   : cadastroInd
    Created on : 07/11/2014, 00:12:36
    Author     : Douglas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro de Indisponibilidade</title>
        <%@include file="includes.jsp" %>
    </head>
    <body>
        <div id="menu" class="menuLateral">
            <%@include file="menuAdmin.jsp" %>
        </div>
        <div id="conteudo" class="conteudoCentro">
            <br>
            <br>
            <form action="ControleInd" class="formularioBasico" name="formRegistroInd" id="formRegistroInd" onsubmit="return validarIndisponibilidade();">
                <input type="hidden" name="action" value="registrarInd" />
                <div class="rowElem">
                    <fieldset class="fieldsetForm">
                        <%
                            String nome = request.getAttribute("nome_prof").toString();
                            String id_prof = request.getAttribute("id_prof").toString();
                        %>
                        <legend>Registro de Indisponibilidade: Professor <%= nome%></legend>
                        <input type="hidden" name="id_prof" value="<%= id_prof%>"/>
                        <br>
                        <div class="rowElem">
                            <label for="ano">Ano: </label>
                            <input type="text" name="ano"/>
                        </div>
                        <br>
                        <br>
                        <div class="rowElem">
                            <label for="periodo">Semestre: </label>
                            <input type="text" name="semestre" />
                        </div>
                        <br>
                        <br>
                        <div>
                            <label for="tabelaIndisponibilidades">Indisponibilidades:</label>
                            <br>
                            <br>
                            <table class="table1" name="tabelaIndisponibilidades">
                                <%
                                    String[] dias = new String[7];
                                    dias[0] = "Seg";
                                    dias[1] = "Ter";
                                    dias[2] = "Qua";
                                    dias[3] = "Qui";
                                    dias[4] = "Sex";
                                    dias[5] = "Sáb";
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
                                        for (int i = 0; i < valores.length; i++) {
                                            valores[i] = i;
                                        }
                                        turnos[0] = 'M';
                                        turnos[1] = 'T';
                                        turnos[2] = 'N';
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
                                        %>
                                        <td>
                                            <select name="<% out.print("i" + Integer.toString(tBlinha) + Integer.toString(tBcoluna));%>">
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
                                        <%                                            }
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
                        <br>
                        <div class="botaoElem">
                            <input type="submit" value="Cadastrar" class="botaoForm"/>
                            <input type="reset" value="Cancelar" class="botaoForm" />
                        </div>
                    </fieldset>
                </div>
            </form> 
        </div>
    </body>
</html>