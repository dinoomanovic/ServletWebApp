<%@ page import="java.io.*,java.util.*,com.dino.model.*,  com.dino.controller.*, com.dino.servlet.*" %>

<!DOCTYPE HTML>
<html lang="en">
    <head>
        <title>Planner</title>
        <meta charset="UTF-8">

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
        <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBHG5fBehoOUiQdPSe5fFPhnvVHS41uMlg&libraries=places"></script>



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
                    <h1>Postavke</h1>
                    <hr>
                </div>
                <br>
                
                    <form name="nameList" id="name-list" method="post" action="settings">
                        <div class="col-lg-3 col-xs-12 data-input">

                            <label>Va&scaron;e ime</label>
                            <input type="text" name="userName" class="js-name" placeholder="Unesite ime">
                    
                    

                            <label>Lozinka</label>
                            <input type="text" name="passWord" class="js-name" placeholder="Unesite lozinku">
                        </div>
                    
                        <div class="col-lg-3  col-xs-12">
                            <input type="submit" value="Spremi" class="btn btn-black ">
                        </div>
                        </form>
                        <br><br>
                        

                                                                   


                </div>
<form name="prognoza" id="day-list" method="post" action="weather">
    <label>Grad</label>
    <input id="locationTextField" class="form-control" type="text" name="locationTextField" value="<% out.print(request.getAttribute("locationName")); %>">
			<input type="hidden" id="city" name="city"/>
			<input type="hidden" id="latitude" name="latitude"/>
			<input type="hidden" id="longitude" name="longitude"/>
			<input type="hidden" name="action" value="prognoza">
                        
                        <label>Odaberite broj dana za vremensku prognozu:</label>
                        
                        <select name="days" class="js-weather-day-cnt">
                            <option value="4">4 dana</option>
                            <option value="8">8 dana</option>
                            <option value="12">12 dana</option>
                            <option value="16">16 dana</option>
                        </select>
      
                <br><br>
                <div class="col-lg-3  col-xs-12">
                    <input type="submit" value="Spremi" class="btn btn-black js-save">
                    
                </div>
                          </form>

                <br><br>

            </div>
                    
            </div>
        </div> 


        <!-- Footer -->
        <footer class="container-fluid text-center">     
            <p>Copyright &copy; <span class="copyright">2015</span> Planner</p> 
        </footer>
<script>
            function init() {
                var input = document.getElementById('locationTextField');
       		 var autocomplete = new google.maps.places.Autocomplete(input);
       		 google.maps.event.addListener(autocomplete, 'place_changed', function () {
		    var place = autocomplete.getPlace();
		    document.getElementById('city').value = place.name;
		    document.getElementById('latitude').value = place.geometry.location.lat();
		    document.getElementById('longitude').value = place.geometry.location.lng();

        });
            }

            google.maps.event.addDomListener(window, 'load', init);
        </script>
       <script src="scripts/common.js"></script>
        <script src="scripts/settings.js"></script>
</html>