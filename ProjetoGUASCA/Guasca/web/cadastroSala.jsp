<%-- 
    Document   : cadastroSala
    Created on : 07/10/2014, 16:15:18
    Author     : fernando
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/estilos-gerais.css" />
        <title>Cadastro de Salas</title>
    </head>
    <body>
        <form action="ControleSala">
            <input type="hidden" name="action" value="cadastrarSala"/>
            <fieldset>
                <legend>Cadastro de sala</legend>
                <br>
                <label for="nomeSala">
                    Nome:
                </label>
                <input type="text" id="nomeSala" name="nomeSala"><br><br>
                
                <br>
                <label for="tipoSala">
                   Tipo:
                </label>
                <input type="text" id="tipoSala" name="tipoSala"><br><br>
                <br>
                <label for="descricaoArea">
                    Quantidade de Alunos:
                </label>
                <input type="text" id="descricaoArea" name="descricaoArea"><br><br>
                <br>
                <label for="disciplinaSala">
                    Disciplina:
                </label>
                <input type="text" id="disciplinaSala" name="disciplinaSala"><br><br>

                <input class="botaoForm" type="submit" value="Cadastrar">

            </fieldset>
        </form>
    </body>
</html>

