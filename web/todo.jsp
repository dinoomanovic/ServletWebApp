<%@ page import="java.io.*,java.util.*,com.dino.model.*,  com.dino.controller.*, com.dino.servlet.*" %>

<!DOCTYPE HTML>
<html lang="en">
    <head>
        <title>Planner</title>
        <meta charset="UTF-8">

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js" type="text/javascript"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>


     	<link href="http://fonts.googleapis.com/css?family=Lato:100italic,100,300italic,300,400italic,400,700italic,700,900italic,900" rel="stylesheet" type="text/css">
	<link rel="stylesheet" type="text/css" href="assets/bootstrap/css/bootstrap.min.css" />
	<link rel="stylesheet" type="text/css" href="assets/css/styles.css" />
    </head>
    <body  id="top">

        <div class="wrap">

            <!-- Navbar -->
            <nav class="navbar navbar-default">
                <div class="container">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a class="navbar-brand" href="index">Planner</a>
                    </div>
                    <div class="collapse navbar-collapse" id="myNavbar">
                        <ul class="nav navbar-nav navbar-right">
                          <li><a href="index">Po&ccaron;etna</a></li>
                            <li><a href="shopping">Shopping</a></li>
                            <li><a href="todo">TODO</a></li>
                            <li><a href="weather">Vrijeme</a></li>
                            <li><a href="settings">Postavke</a></li>
                                                        <li><a href="login" action="index" name="action" method="POST">Odjava</a></li>

                    </div>
                </div>
            </nav>

            <div class="container">
                <div class="row">
                    <h1>TODO lista</h1>
                    <hr>
                </div>
                <div class="row">
                    <div class="col-xs-12">
                        <h3>Unesite novu obavezu</h3>
                    </div>
                </div>
                <br>
                <div class="row">
                    <div class="col-xs-12">
                        <div class="row">
                            <form name="TodoList" id="todo-list" method="post" action="todo">
                                <div class="col-lg-3 col-xs-12">
                                    <label>Naziv</label>
                                    <input type="text" name="Naziv" class="js-name">
                                </div>
                                <div class="col-lg-3  col-xs-12">
                                    <label>Opis</label>
                                    <input type="text" name="Opis" class="js-value">
                                </div>
                                <div class="col-lg-3  col-xs-12">
                                    <input type="submit" value="Spremi" class="btn btn-black ">
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
                <br>
                <br>
                <div  class="item-list">
                    <h3>Nove obaveze</h3>
                    <table draggable="true" id="table-finished-tasks" name="zavrsena" action="todo" method="POST" class="table table-striped table-bordered childgrid">
                    <%
				List<Todo> todoLista  = (List<Todo>)request.getAttribute("todoLista");
         
                                       
                                    if(todoLista.size()>0){
					for(int i=0; i<todoLista.size(); i++){
						out.print("<td>" + todoLista.get(i).getNaziv() + "</td>");	
						out.print("<td>" + todoLista.get(i).getOpis() + "</td>");	
						out.print("</tr>");	
					}
				}else	
					out.print("<tr><td colspan='3'>Nemate proizvoda u listi za kupovinu!</td></tr>");		
				
			%>  
                </table>
                    <p>
 <a href="todo?deleteAll=true" class="btn btn-default js-nema-zadaca" role="button">Obri&scaron;i sve</a>                    </p>
                    </div>
                <div  class="item-list">
                    <h3>Zavr&scaron;ene obaveze</h3>
                    <table draggable="true" id="list-finished" name="zavrsena" action="todo" method="POST" class="table table-striped table-bordered childgrid" ondrop="handleDrop(event)" ondragover="handleOver(event)" ondragleave="handleLeave(event)"></table>
                  
                </div>


            </div>
        </div>


        <!-- Footer -->
        <footer class="container-fluid text-center">
            <p>Copyright &copy; <span class="copyright">2015</span> Planner</p>
        </footer>

      <!--  <script src="scripts/common.js"></script> -->
   <!--    <script src="scripts/todo.js"></script> -->
   <script src ="scripts/todolist.js"</script>

    </body>
</html>
