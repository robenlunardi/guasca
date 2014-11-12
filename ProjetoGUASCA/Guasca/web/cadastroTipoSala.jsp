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
        <title>Cadastro de Tipo de Sala</title>
    </head>
    <body>
        <form action="ControleSala2">
            <input type="hidden" name="action" value="cadastrarTipoSala"/>
            <fieldset>
                <legend>Cadastro de Tipo de Sala</legend>
                <br>
                <label for="descricaoTipoSala">
                    Descrição:
                </label>
                <input type="text" id="descricaoTipoSala" name="descricaoTipoSala"><br><br>

                <input class="botaoForm" type="submit" value="Cadastrar">

            </fieldset>
        </form>
    </body>
</html>
