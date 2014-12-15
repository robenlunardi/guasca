<%-- 
    Document   : index
    Created on : 10/09/2014, 10:50:51
    Author     : Douglas
--%>

<%@page import="guasca.modelo.Disciplina"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Index page</title>
        <%@include file="includes.jsp" %>
    </head>
    <body>
        <div id="menu" class="menuLateral">
            <%@include file="menuAdmin.jsp" %>
        </div>
        <div id="conteudo" class="conteudoCentro">
            <%                
                String msg = (String) request.getAttribute("mensagem");
                String grade = (String) request.getAttribute("chaveGrade");
                if (msg != null && !(msg.equals(""))) {
            %>
            <div id="mensagemErro"><p><%= msg%></p></div>
            <%                
            } else {
                if (grade != null && !(grade.equals(""))) {
                    %>
                    <%@include file="mostrarGradeHorario.jsp" %>
            <%
            } else {
            %>
            
            <%                        
                    }
                }
            %>
        </div>
    </body>
</html>
