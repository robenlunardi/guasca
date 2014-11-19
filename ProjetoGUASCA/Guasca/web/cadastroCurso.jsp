<%-- 
    Document   : cadastroCurso
    Created on : 19/11/2014, 09:43:50
    Author     : 4DS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/estilos-gerais.css" />
        <title>Cadastro de Curso</title>
        <%@include file="includes.jsp" %>
    </head>
    <body>
        <div id="menu" class="menuLateral">
            <%@include file="menuAdmin.jsp" %>
        </div>
        <div id="conteudo" class="conteudoCentro">
            <form action="ControleCurso">
                <input type="hidden" name="action" value="cadastrarCurso"/>
                <fieldset class="fieldsetForm">
                    <legend>Cadastro de Curso</legend>
                    <br>
                    <label for="nomeCurso">
                        Nome do Curso:
                    </label>
                    <input type="text" id="nomeCurso" name="nomeCurso"><br><br>

                    <input class="botaoForm" type="submit" value="Cadastrar">

                </fieldset>
            </form>
        </div>
    </body>
</html>