var todoList = [];
var finishedList = [];
$("document").ready(function () {

    showAll();
    addTasks();

});

function addTasks() {
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
    if (name.length == 0 || value.length == 0) { alert("Unos ne smije biti prazan!"); }
    else

        todoList.push(value);

    setLocalStorage("todoList", JSON.stringify(todoList));

    showAll();

    resetForm();

}

function resetForm() {
    $('#todo-list')[0].reset();
    $(".js-save").blur();
}

function removeItem(index) {
    todoList.splice(index, 1);
    setLocalStorage("todoList", JSON.stringify(todoList));
    showAll();
}

function clearAll() {
    removeLocalStorage("todoList");
    todoList = [];
    showAll();
}

function showAll() {

    var completedList = getLocalStorage("finishedList", "");
    var storageList = getLocalStorage("todoList", "");


    var list = "<tr draggable='true' colspan='3' id='list-title'><th>Naziv</th><th>Opis</th><th class='text-right'>Ukloni</th></tr>\n";
    var finishedlist = "<tr><th>Naziv</th><th>Opis</th></tr>\n";
    if (storageList.length > 0) {
        todoList = JSON.parse(storageList);

        for (var i = 0; i <= todoList.length - 1; i++) {
            var item = todoList[i];
            list += "<tr id='" + i + "'class='single_row' draggable='true' ondragstart='handleStart(event)'><td>" + item.name + "</td><td>"
                    + item.value + "</td><td><span class='glyphicon glyphicon-remove js-remove-item' data-index=" + i + "></span></td></tr>";

        }

        $(".js-clear").show();
    }
    else {
        list += "<tr><td colspan='3'>Nemate obaveza u listi taskova!</td></tr>";
        $(".js-clear").hide();
    }

    if (completedList.length > 0) {
        finishedList = JSON.parse(completedList);

        for (var i = 0; i <= finishedList.length - 1; i++) {
            var item = finishedList[i];
            finishedlist += "<tr><td>" + item.name + "</td><td>" + item.value + "</td></tr>";
        }

        $(".js-clear").show();
    }
    else {
        finishedlist += "<tr><td colspan='3'><i>Nemate zavrsenih taskova!</i></td></tr>";
        $(".js-clear").hide();
    }

    $('#table1').html(list);
    $('#table2').html(finishedlist);

    $(".js-remove-item").unbind("click").on("click", function () {
        removeItem($(this).data("index"));
    });

}

function handleStart(ev) {
    ev.dataTransfer.setData("transfer", ev.target.id);
}

function handleOver(ev) {
    ev.preventDefault();
    $("#table2").addClass("tabledrop");
}

function handleLeave(ev) {
    ev.preventDefault();
    $("#finished_list").removeClass("tabledrop");
}

function handleDrop(ev) {
    ev.preventDefault();
    var transfer = ev.dataTransfer.getData("transfer");
    var row = document.getElementById(transfer).getElementsByTagName('td');

    var podaci = {
        name: row[0].innerHTML,
        value: row[1].innerHTML
    };



    finishedList.push(podaci);
    setLocalStorage("finishedList", JSON.stringify(finishedList));
    removeItem(transfer);
    $("#table2").removeClass("tabledrop");
    showAll();
}

var redovi = document.querySelectorAll('#table1 .single_row');
[].forEach.call(redovi, function (row) {
    row.addEventListener('dragstart', handleStart, false);
    row.addEventListener('dragcancel', handleLeave, false);
});
