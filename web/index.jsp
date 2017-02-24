<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
 import="java.io.*,java.util.*,com.dino.model.*,  com.dino.controller.*, com.dino.servlet.*" %>

<!DOCTYPE HTML>
<html lang="en">
    <head>
        <title>Planner</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta name="viewport" content="width=1,initial-scale=1,user-scalable=1" />
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
        <script src="scripts/main.js"></script>


    
	
	<link href="http://fonts.googleapis.com/css?family=Lato:100italic,100,300italic,300,400italic,400,700italic,700,900italic,900" rel="stylesheet" type="text/css">
	<link rel="stylesheet" type="text/css" href="assets/bootstrap/css/bootstrap.min.css" />
	<link rel="stylesheet" type="text/css" href="assets/css/styles.css" />
    </head>
    

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
                              <li><a href="index">Početna</a></li>
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
                <span class="row" >
                <h1 id="lista">
 
            
                                    
                 
                </h1>
                    <h1>
                                <% 
                        String userName="";
                    userName = (String) request.getAttribute("userName");
                   out.print(userName);
                    
                    %>
                    </h1>
                </span>

               
                
                <div id="items_table">
                    <h3>Shopping Lista</h3>
                    <table id="shopping-list" class="table table-bordered table-striped shopping-table">
	<%
				List<Shopping> shoppingLista  = (List<Shopping>)request.getAttribute("shoppingLista");
         
                                       
                                    if(shoppingLista.size()>0){
					for(int i=0; i<shoppingLista.size(); i++){
						out.print("<td>" + shoppingLista.get(i).getProizvod() + "</td>");	
                                                out.print("<td>" + shoppingLista.get(i).getKolicina() + "</td>");	
						out.print("</tr>");	
					}
				}else	
					out.print("<tr><td colspan='3'>Nemate proizvoda u listi za kupovinu!</td></tr>");		
				
			%>   
                    </table>
                    <h3>TODO Lista</h3>
                    <table id="todo-list" class="table table-bordered table-striped todo-table">
                        
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
                </div>
            </div>
        </div> 


        <!-- Footer -->
        <footer class="container-fluid text-center">     
            <p>Copyright &copy; <span class="copyright">2015</span> Planner</p> 
        </footer>
                      <script> var name = <%=request.getAttribute("userName")%>; </script>
      <!--  <script src="scripts/common.js"></script> -->
     <script src="scripts/main.js">
  
    
</html>