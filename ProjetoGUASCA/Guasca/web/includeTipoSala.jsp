<%@page import="java.util.Arrays"%>
<%
    String[] tipoSala = {
        "Informática", "Hardware e Redes", "Eletrônica Digital", "Eletricidade Básica", "Idiomas", "Desenho", "Sala de Aula", "Eletrônica de Potência"
    };
    Arrays.sort(tipoSala);
%>
<select   id="tipoSala1" name="tipoSala1">
    <%
        for (int i = 0; i < tipoSala.length; i++) {
    %>
    <option value="<%= tipoSala[i] %>">
        <%= tipoSala[i]%>
    </option>
    <%
        }
    %>
</select>