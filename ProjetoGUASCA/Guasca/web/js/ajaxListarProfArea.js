var req;
var isIE;
var completeField;
var completeTable;
var autoRow;

function init() {
    completeField = document.getElementById("complete-field");
    completeTable = document.getElementById("idTabelaListaProfessorArea");
    autoRow = document.getElementById("auto-row");
    completeTable.style.top = getElementY(autoRow) + "px";
}

function limparTabela() {
    
    var objetoXMLHttp = objXMLHttp();
    
    objetoXMLHttp.open("POST", "ControleDisciplinaAjax", true);
    objetoXMLHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    
    if(document.getElementById("idTabelaListaProfessorArea") == null){
        completeTable = document.getElementById("idListaErros");
        if(completeTable != null){
            clearTable(); 
        }
    }else if(document.getElementById("idListaErros") == null){
        completeTable = document.getElementById("idTabelaListaProfessorArea");
        if(completeTable != null){
            clearTable(); 
        }
    }else{
        completeTable = document.getElementById("idListaErros");
        if(completeTable != null){
            clearTable(); 
        }
        completeTable = document.getElementById("idTabelaListaProfessorArea");
        if(completeTable != null){
            clearTable(); 
        }
    }

}

function filtrarVeiculos(form) {
    
    var dados = "areaDisciplina="+form.value;
    
    var objetoXMLHttp = objXMLHttp();
    
    objetoXMLHttp.open("POST", "ControleDisciplinaAjax", true);
    objetoXMLHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    
    objetoXMLHttp.onreadystatechange = function(){
        if(objetoXMLHttp.readyState == 4){
            if(objetoXMLHttp.status == 200){
                mensagem(objetoXMLHttp.responseText);
            }
        }else{
            mensagem("<table id=\"idListaErros\"><tr><td>Todos os campos são de preenchimento obrigatório. Revise este formulário.</td></tr></table>");
        }
    };
    //tem tabela?
    
    completeTable = document.getElementById("idTabelaListaProfessorArea");
    if(completeTable != null){
        clearTable(); 
    }
    objetoXMLHttp.send(dados);

    return false;
}

function callback() {
    clearTable();
    if(objetoXMLHttp.readyState == 4){
        if(objetoXMLHttp.status == 200){
            mensagem(objetoXMLHttp.responseText);
        }
    }else{
        mensagem("Ocorreu um erro: "+objetoXMLHttp.statusText);
    }
//    if (req.readyState == 4) {
//        if (req.status == 200) {
//            parseMessages(req.responseXML);
//        }
//    }
}

function appendComposer(firstName,lastName,composerId) {

    var row;
    var cell;
    var linkElement;
    
    if (isIE) {
        completeTable.style.display = 'block';
        row = completeTable.insertRow(completeTable.rows.length);
        cell = row.insertCell(0);
    } else {
        completeTable.style.display = 'table';
        row = document.createElement("tr");
        cell = document.createElement("td");
        row.appendChild(cell);
        completeTable.appendChild(row);
    }

    cell.className = "popupCell";

    linkElement = document.createElement("a");
    linkElement.className = "popupItem";
    linkElement.setAttribute("href", "autocomplete?action=lookup&id=" + composerId);
    linkElement.appendChild(document.createTextNode(firstName + " " + lastName));
    cell.appendChild(linkElement);
}

function clearTable() {
    if (completeTable.getElementsByTagName("tr").length > 0) {
        completeTable.style.display = 'none';
        for (loop = completeTable.childNodes.length -1; loop >= 0 ; loop--) {
            completeTable.removeChild(completeTable.childNodes[loop]);
        }
    }
}

function getElementY(element){
    
    var targetTop = 0;
    
    if (element.offsetParent) {
        while (element.offsetParent) {
            targetTop += element.offsetTop;
            element = element.offsetParent;
        }
    } else if (element.y) {
        targetTop += element.y;
    }
    return targetTop;
}

function objXMLHttp(){
    var obj;
    if(window.XMLHttpRequest){//mozilla, safari, chrome...
        obj = new XMLHttpRequest();
        return obj;
    }else if(window.ActiveXObject){//IE
        obj = new ActiveXObject("Microsoft.XMLHTTP");
        return obj;
    }
    return false;
}

function mensagem(msg){
    document.getElementById('msg').innerHTML=msg;
}

