<%-- 
    Document   : listarSala
    Created on : 15/10/2014, 11:05:40
    Author     : 4DS
--%>

<%@page import="guasca.modelo.Sala"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>lista de Salas</h1>

        <form action="ControleSala2">
            <input type="hidden" name="action" value="listarSala"/>
            <fieldset>
                <legend>Lista de sala</legend>
                <br>    

                <table class="tabelaListasala" border="1">
                    <thead>
                    <td id="nomeSala" class="colunaDuzentos">Nome</td>
                    <td id="tipoSala">Tipo</td>
                    <td id="quantidadeAlunos">Capacidade</td>
                    <td id="Acoes">Ações</td>
                    </thead>
                    <tbody>
                        <%
                            List<Sala> lista = (List<Sala>) request.getAttribute("listasala");
                            for (int i = 0; i < lista.size(); i++) {
                                Sala sal = lista.get(i);
                        %>
                        <tr>
                            <td headers="nomeSala"><% out.print(sal.getNome());%></td>
                            <td headers="tipoSala"><% out.print(sal.getTipo());%></td>
                            <td headers="quantidadeAlunos"><% out.print(sal.getQuantAlunos());%></td>
                            <td headers="Acoes" class="colunaAcoes"></td>
                        </tr>
                        <%
                            }
                        %>
                    </tbody>
                </table>
            </fieldset>
        </form>                   
    </body>
</html>

