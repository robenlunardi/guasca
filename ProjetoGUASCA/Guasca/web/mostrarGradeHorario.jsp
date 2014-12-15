<%@page import="guasca.controle.gradehorarios.AlgoritmoGrade"%>
<%@page import="guasca.modelo.Disciplina"%>
<%@page import="java.util.List"%>
<%
    List<Disciplina> listaDisciplina = (List<Disciplina>) request.getAttribute("listaDisciplina");

    try {
        AlgoritmoGrade novaGrade = new AlgoritmoGrade(listaDisciplina);
        novaGrade.gerarGrade();
        Disciplina[][] gradeCompleta = new Disciplina[5][5];
        gradeCompleta = novaGrade.getGradeCompleta();

%><table class="table1">
    <thead>
        <tr>
            <%
                String[] dias = new String[5];
                dias[0] = "Seg";
                dias[1] = "Ter";
                dias[2] = "Qua";
                dias[3] = "Qui";
                dias[4] = "Sex";
                for (int i = 0; i < dias.length; i++) {
                    %> <th> <%= dias[i] %> </th> <%
                }
            %>
        </tr>
    </thead>
    <tbody>
        <%
            for (int i = 0; i < gradeCompleta.length; i++) {
        %><tr><%
            for (int j = 0; j < gradeCompleta[i].length; j++) {
            %> <td> <%= gradeCompleta[j][i].getNome()%> </td> <%
                }
            %></tr><%
                }
            %></tbody></table><%

            } catch (Exception e) {
                System.out.println("EXCEPTION!");
                e.getMessage();
            }

%>