// AO CLICAR NO BOTÃO "SALVAR" FAZ VALIDAÇÕES DOS CAMPOS OBRIGATÓRIOS
function validarArea(){
    
    var a = document.formCadastroArea;
    
    if(a.descricaoArea.value == ""){
        alert("Dados obrigatórios não preenchidos.");
        a.descricaoArea.style.backgroundColor="#dddddd";
        a.descricaoArea.focus();
        return false;
    }else{
        a.descricaoArea.style.backgroundColor="#FFFFFF";
    }
    
    return true;
}
 
function validarCurso(){
    
    var a = document.formCadastroCurso;
    
    if(a.nomeDisciplina.value == ""){
        alert("Dados obrigatórios não preenchidos.");
        a.nomeDisciplina.style.backgroundColor="#dddddd";
        a.nomeDisciplina.focus();
        return false;
    }else{
        a.nomeDisciplina.style.backgroundColor="#FFFFFF";
    }
    
    return true;
}

function validarProfessor(){
    
    var a = document.formCadastroProf;
    
    if(a.nomeProf.value == ""){
        alert("Dados obrigatórios não preenchidos.");
        a.nomeProf.style.backgroundColor="#dddddd";
        a.nomeProf.focus();
        return false;
    }else{
        a.nomeProf.style.backgroundColor="#FFFFFF";
    }
    
    if(a.matriculaProf.value == ""){
        alert("Dados obrigatórios não preenchidos.");
        a.matriculaProf.style.backgroundColor="#dddddd";
        a.matriculaProf.focus();
        return false;
    }else{
        a.matriculaProf.style.backgroundColor="#FFFFFF";
    }
    
    if(a.emailProf.value == ""){
        alert("Dados obrigatórios não preenchidos.");
        a.emailProf.style.backgroundColor="#dddddd";
        a.emailProf.focus();
        return false;
    }else{
        a.emailProf.style.backgroundColor="#FFFFFF";
    }
    
    if(a.area.value == ""){
        alert("Dados obrigatórios não preenchidos.");
        a.area.style.backgroundColor="#dddddd";
        a.area.focus();
        return false;
    }else{
        a.area.style.backgroundColor="#FFFFFF";
    }
    
    return true;
}

function validarTipoSala(){
    
    var a = document.formCadastroTipoSala;
    
    if(a.descricaoTipoSala.value == ""){
        alert("Dados obrigatórios não preenchidos.");
        a.descricaoTipoSala.style.backgroundColor="#dddddd";
        a.descricaoTipoSala.focus();
        return false;
    }else{
        a.descricaoTipoSala.style.backgroundColor="#FFFFFF";
    }
    
    return true;
}

function validarSala(){
    
    var a = document.formCadastroSala;
    
    if(a.nomeSala.value == ""){
        alert("Dados obrigatórios não preenchidos.");
        a.nomeSala.style.backgroundColor="#dddddd";
        a.nomeSala.focus();
        return false;
    }else{
        a.nomeSala.style.backgroundColor="#FFFFFF";
    }
    
    if(a.optionTipoSala.value == 0){
        alert("Dados obrigatórios não preenchidos.");
        a.optionTipoSala.style.backgroundColor="#dddddd";
        a.optionTipoSala.focus();
        return false;
    }else{
        a.optionTipoSala.style.backgroundColor="#FFFFFF";
    }
    
    if(a.quantidadeAlunos.value == ""){
        alert("Dados obrigatórios não preenchidos.");
        a.quantidadeAlunos.style.backgroundColor="#dddddd";
        a.quantidadeAlunos.focus();
        return false;
    }else{
        a.quantidadeAlunos.style.backgroundColor="#FFFFFF";
    }
    
    return true;
}

function validarIndisponibilidade(){
    
    var a = document.formRegistroInd;
    
    if(a.ano.value == ""){
        alert("Dados obrigatórios não preenchidos.");
        a.ano.style.backgroundColor="#dddddd";
        a.ano.focus();
        return false;
    }else{
        a.ano.style.backgroundColor="#FFFFFF";
    }
    
    if(a.semestre.value == 0){
        alert("Dados obrigatórios não preenchidos.");
        a.semestre.style.backgroundColor="#dddddd";
        a.semestre.focus();
        return false;
    }else{
        a.semestre.style.backgroundColor="#FFFFFF";
    }
    
    return true;
}

function validarDisciplina(){
    
    var a = document.formCadastroDisciplina;
    
    if(a.cursoDisciplina.value == -1){
        alert("Dados obrigatórios não preenchidos.");
        a.cursoDisciplina.style.backgroundColor="#dddddd";
        a.cursoDisciplina.focus();
        return false;
    }else{
        a.cursoDisciplina.style.backgroundColor="#FFFFFF";
    }
    
    if(a.nomeDisciplina.value == ""){
        alert("Dados obrigatórios não preenchidos.");
        a.nomeDisciplina.style.backgroundColor="#dddddd";
        a.nomeDisciplina.focus();
        return false;
    }else{
        a.nomeDisciplina.style.backgroundColor="#FFFFFF";
    }
    
    if(a.areaDisciplina.value == -1){
        alert("Dados obrigatórios não preenchidos.");
        a.areaDisciplina.style.backgroundColor="#dddddd";
        a.areaDisciplina.focus();
        return false;
    }else{
        a.areaDisciplina.style.backgroundColor="#FFFFFF";
    }
    
    if(a.optionTipoSala1.value == 0 && a.optionTipoSala2.value == 0){
        alert("Selecione pelo menos um tipo de Sala.");
        a.optionTipoSala1.style.backgroundColor="#dddddd";
        a.optionTipoSala2.style.backgroundColor="#dddddd";
        a.optionTipoSala1.focus();
        return false;
    }else{
        a.optionTipoSala1.style.backgroundColor="#FFFFFF";
        a.optionTipoSala2.style.backgroundColor="#FFFFFF";
    }
    
    if(a.creditos1.value == "" && a.creditos2.value == ""){
        alert("Preencha pelo menos um Crédito.");
        a.creditos1.style.backgroundColor="#dddddd";
        a.creditos2.style.backgroundColor="#dddddd";
        a.creditos1.focus();
        return false;
    }else{
        a.creditos1.style.backgroundColor="#FFFFFF";
        a.creditos2.style.backgroundColor="#FFFFFF";
    }
    
    if (a.turno[1].checked==false && a.turno[0].checked==false && a.turno[2].checked==false) {
        alert("Dados obrigatórios não preenchidos. Selecione se o servidor é ou não motorista!");
        return false;
    }
    
    if(a.quantAlunos.value == ""){
        alert("Dados obrigatórios não preenchidos.");
        a.quantAlunos.style.backgroundColor="#dddddd";
        a.quantAlunos.focus();
        return false;
    }else{
        a.quantAlunos.style.backgroundColor="#FFFFFF";
    }
    
    return true;
}