<%@ page import="java.io.*,java.util.*,com.dino.model.*,  com.dino.controller.*, com.dino.servlet.*" %>
<!DOCTYPE HTML>
<html lang="en">
    <head>
        <title>Planner</title>
        <meta charset="UTF-8">

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>


 	<link href="http://fonts.googleapis.com/css?family=Lato:100italic,100,300italic,300,400italic,400,700italic,700,900italic,900" rel="stylesheet" type="text/css">
	<link rel="stylesheet" type="text/css" href="assets/bootstrap/css/bootstrap.min.css" />
	<link rel="stylesheet" type="text/css" href="assets/css/styles.css" />
    </head>
    <body id="top">

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

                        </ul>
                    </div>
                </div>
            </nav>
            

            <div class="container">

                <div class="row">
                    <h1>Shopping lista</h1>
                    <hr>                  
                </div>
                <div class="row">
                    <div class="col-xs-12">
                        <h3>Unesite proizvod i koli&ccaron;inu</h3>
                    </div>
                </div>
                <br>
                <div class="row">
                    <div class="col-xs-12">
                        <div class="row">
                            <form name="ShoppingList" id="shopping-list" method="post" action="shopping">
                                <div class="col-lg-3 col-xs-12">
                                    <label>Proizvod:</label>
                                    <input type="text" name="Proizvod" class="js-name">
                                </div>
                                <div class="col-lg-3  col-xs-12">
                                    <label>Koli&ccaron;ina:</label>
                                    <input type="text" name="Kolicina" class="js-value">
                                </div>
                                <div class="col-lg-3  col-xs-12">
                                    <input type="submit" value="Spremi" class="btn btn-black js-save">
                                </div>
                            </form>
                        </div>
                    </div>
                </div>

                <br>
                <br>
                <div id="items_table">

                    <h3>Shopping Lista</h3>
                    <table id="list" class="table table-bordered table-striped">
		    <tr><th>Proizvod</th><th class='text-center'>Koli&ccaron;ina</th><th class='text-center'>Ukloni</th></tr>
			<%
				List<Shopping> shoppingLista = (List<Shopping>)request.getAttribute("shoppingLista");
                       if(shoppingLista.size()>0){
					for(int i=0; i<shoppingLista.size(); i++){
						out.print("<td>" + shoppingLista.get(i).getProizvod() + "</td>");	
						out.print("<td>" + shoppingLista.get(i).getKolicina() + "</td>");	
						out.print("<td class='text-center'><a href='shopping?delete_id=" + shoppingLista.get(i).getShoppingId() + "'><i class='glyphicon glyphicon-remove js-remove-item'></i></a></td>");
						out.print("</tr>");	
					}
				}else	
					out.print("<tr><td colspan='3'>Nemate proizvoda u listi za kupovinu!</td></tr>");		
				
			%>    

			</table>
                    <p>
                        <a href="shopping?deleteAll=true" class="btn btn-default" role="button">Obri&scaron;i sve</a>
                    </p>
                </div>
            </div>
        </div> 


        <!-- Footer -->
        <footer class="container-fluid text-center">     
            <p>Copyright &copy; <span class="copyright">2015</span> Planner</p> 
        </footer>

        <script src="scripts/common.js"></script> 
        <!--- <script src="scripts/shopping.js"></script> -->
    </body>
</html>

