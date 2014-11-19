<link rel="stylesheet" type="text/css" href="css/estilos-gerais.css" />
<link rel="stylesheet" type="text/css" href="css/menu.css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/validacoes.js"></script>

<script type="text/javascript">
    $(document).ready(function(){
        $("#accordian h3").click(function(){
            //slide up all the link lists
            $("#accordian ul ul").slideUp();
            //slide down the link list below the h3 clicked - only if its closed
            if(!$(this).next().is(":visible")){
                $(this).next().slideDown();
            }
        })
    })
</script>