var list ;
$(document).ready(function () {
    showWelcome();
   
});
function showWelcome()
{

    var d = new Date();
    var n = d.getHours();
    var m = d.getMinutes();
    
    var lista="";
 
    if (n <= 10) {
         lista = "Dobro jutro,   "+name;
    }
    else if (n > 10 && n <= 18)
    {
         lista = "Dobar dan, "+name;

    }
    else {
        lista = "Dobro veče, "+name;

    }

        $(".js-clear").show();
        $('#lista').html(lista);
        $(".js-save").blur();

}

