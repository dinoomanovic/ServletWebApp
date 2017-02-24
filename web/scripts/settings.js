var nameList=[] ;
$(document).ready(function () {
    changeName();
    bindEvents();
});
function changeName(){
    $(".js-save").on("click", function () {
        saveItem();
    });
}
function saveItem()
{
    var name = $(".js-name").val();

    var value = {
        name: name
       
    };
    
    

    nameList.push(value);
    setLocalStorage("nameList", JSON.stringify(nameList));

    showAll();
    resetForm();
    
}
function resetForm() {
    $('#name-list')[0].reset();
    $(".js-save").blur();
}

function showAll() {

    var storageList = getLocalStorage("nameList", "");

    var list = nameList;
   
            
        

        $(".js-clear").show();
    

}
function bindEvents()
{
    $(".js-weather-day-cnt").on("change", function () {

        if (checkBrowser())
        {
            localStorage.setItem("weather_cnt", $(this).val());
        }

    });
}