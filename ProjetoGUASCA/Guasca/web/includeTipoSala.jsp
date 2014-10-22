<%@page import="java.util.Arrays"%>
<%
    String[] tipoSala = {
        "Informática", "Hardware e Redes", "Eletrônica Digital", "Eletricidade Básica", "Idiomas", "Desenho", "Sala de Aula", "Eletrônica de Potência"
    };
    Arrays.sort(tipoSala);
%>
<label for="labelArea">
    Tipo de Sala:
</label>
<select name="area">
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
