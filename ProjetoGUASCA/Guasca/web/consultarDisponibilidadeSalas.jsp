<%-- 
    Document   : consultarDisponibilidadeSalas
    Created on : 14/10/2014, 16:16:24
    Author     : fernando
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/estilos-gerais.css" />
        <title>Consultar Disponibilidade de Salas</title>
    </head>
    <body>
        <form action="ControleSala">
            <input type="hidden" name="action" value="consultaDisponibilidadeSala"/>
            <fieldset>
                <legend>Consultar Disponibilidade de Salas</legend>
                <br>
                <label for="tipoSala">
                   Tipo:
                </label>
                <input type="text" id="tipoSala" name="tipoSala"><br><br>
                <br>
                
                <a class="botaoMenu" href="ControleGeral?formulario=cadastroSala" >Cadastrar Sala</a>
                             
            </fieldset>
        </form>
    </body>
</html>
