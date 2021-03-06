<%-- 
    Document   : cadastroArea
    Created on : 10/09/2014, 11:03:41
    Author     : Douglas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/estilos-gerais.css" />
        <title>Cadastro de Área</title>
        <%@include file="includes.jsp" %>
    </head>
    <body>
        <div id="menu" class="menuLateral">
            <%@include file="menuAdmin.jsp" %>
        </div>
        <div id="conteudo" class="conteudoCentro">
            <form id="formCadastroArea" name="formCadastroArea" action="ControleArea" onsubmit="return validarArea();">
                <input type="hidden" name="action" value="cadastrarArea"/>
                <fieldset class="fieldsetForm">
                    <legend>Cadastro de Área</legend>
                    <br>
                    <label for="descricaoArea">
                        Descrição:
                    </label>
                    <input type="text" id="descricaoArea" name="descricaoArea"><br><br>

                    <input class="botaoForm" type="submit" value="Cadastrar">

                </fieldset>
            </form>
        </div>
    </body>
</html>
