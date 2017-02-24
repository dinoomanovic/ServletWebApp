 var shoppingList = [];

$("document").ready(function () {

    showAll();
    bindEvents();

});


function bindEvents()
{
    $(".js-save").on("click", function () {
        saveItem();
    });

    $(".js-clear").on("click", function () {
        clearAll();
    });

}

function saveItem() {

    var name = $(".js-name").val();
    var value = $(".js-value").val();

    var value = {
        name: name,
        value: value
    };

    shoppingList.push(value);

    setLocalStorage("shoppingList", JSON.stringify(shoppingList));

    showAll();

    resetForm();

}

function resetForm()
{
    $('#shopping-list')[0].reset();
    $(".js-save").blur();
}

function removeItem(index) {
    shoppingList.splice(index, 1);
    setLocalStorage("shoppingList", JSON.stringify(shoppingList));
    showAll();
}

function clearAll() {
    removeLocalStorage("shoppingList");
    shoppingList = [];
    showAll();
}

function showAll() {

    var storageList = getLocalStorage("shoppingList", "");

    var list = "<tr id='shopping-title'><th>Proizvod</th><th class='text-center'>Količina</th><th class='text-center'>Ukloni</th></tr>\n";

    if (storageList.length > 0)
    {
        shoppingList = JSON.parse(storageList);

        for (var i = 0; i <= shoppingList.length - 1; i++) {
            var item = shoppingList[i];
            list += "<tr><td>" + item.name + "</td><td class='text-center'>"
                    + item.value + "</td><td class='text-center'><i class='glyphicon glyphicon-remove js-remove-item' data-index=" + i + "></i></td></tr>";
        }

        $(".js-clear").show();
    }
    else {
        list += "<tr><td colspan='3'>Nemate proizvoda u listi za kupovinu!</td></tr>";
        $(".js-clear").hide();
    }

    $('#list').html(list);

    $(".js-remove-item").unbind("click").on("click", function ()
    {
        removeItem($(this).data("index"));
    });

}
