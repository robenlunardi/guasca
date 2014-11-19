<%-- 
    Document   : cadastroTipoSala
    Created on : 05/11/2014, 19:28:52
    Author     : Douglas
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/estilos-gerais.css" />
        <%@include file="includes.jsp" %>
        <title>Cadastro de Tipo de Sala</title>
    </head>
    <body>
        <div id="menu" class="menuLateral">
            <%@include file="menuAdmin.jsp" %>
        </div>
        <div id="conteudo" class="conteudoCentro">
            <form action="ControleSala2" class="form">
                <input type="hidden" name="action" value="cadastrarTipoSala"/>
                <fieldset class="fieldsetForm">
                    <legend>Cadastro de Tipo de Sala</legend>
                    <br>
                    <label for="descricaoTipoSala">
                        Descrição:
                    </label>
                    <input type="text" id="descricaoTipoSala" name="descricaoTipoSala"><br><br>

                    <input class="botaoForm" type="submit" value="Cadastrar">

                </fieldset>
            </form>
        </div>
    </body>
</html>
