var temporary = {};
var c={};
$("document").ready(function () {
    bindEvents();

});
function bindEvents()
{
   bindDraggable();
   $(".table-finished-tasks").droppable({
     drop: function(event, ui) {
       var id = ui.draggable.context.attributes.todo_id.textContent;
       var naziv = ui.draggable.find(":first-child").text();
       var opis = ui.draggable.find(":first-child").next().text();
        
	$(c.tr).remove();
        $(c.helper).remove();
	$.ajax({
			    type: "GET",
			    url : 'todo',
			    data : "done=" + id,
			    success : function(responseText) {
				document.getElementById("list-finished").insertRow(-1).innerHTML = '<td>'+naziv+'</td><td>'+opis+'</td>';
				$(".js-nema-zadaca").remove();
			    }
      			    });      
	}
   });

}
function bindDraggable(){
  $(".draggable-row").draggable({
    cursor: 'move',
    helper: "clone",
    start: function(event, ui) {
            temporary.tr = this;
            temporary.helper = ui.helper;
        }
  });
}


