<%@page import="java.util.Arrays"%>
<%
    String[] tipoSala = {
        "Inform�tica", "Hardware e Redes", "Eletr�nica Digital", "Eletricidade B�sica", "Idiomas", "Desenho", "Sala de Aula", "Eletr�nica de Pot�ncia"
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
