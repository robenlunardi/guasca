<%-- 
    Document   : index
    Created on : 10/09/2014, 10:50:51
    Author     : Douglas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Index page</title>
        <%@include file="includes.jsp" %>
    </head>
    <body>        
        <a class="botaoMenu" href="ControleGeral?formulario=cadastroArea" >Cadastrar Área</a>
        <a class="botaoMenu" href="ControleGeral?formulario=cadastroProfessor" >Cadastrar Professor</a>
        <a class="botaoMenu" href="ControleGeral?formulario=consultaDisponibilidadeSala" >Cadastrar Sala</a>
        <%
            String msg = (String) request.getAttribute("mensagem");
            if (msg != null) {
        %>
        <div id="mensagemErro"><p><%= msg%></p></div>
        <%                }
        %>
    </body>
</html>
