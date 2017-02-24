
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
                    <h1>Vrijeme</h1>
                    <hr>       
                </div>
                <br>
                <div class="row">                    
                    <div class="col-lg-4 col-xs-12">
                        <div class="row">
                            <h4>Trenutno vrijeme</h4>
                        </div>
                        <br>
                        <div class="row js-current-weather-result">   
                            <div class="col-lg-10 col-xs-12 weather-item">
                                <div class="row text-center">   
                                    <div class="col-xs-12">      
                                        <span class="js-place"></span> 
                                    </div>
                                    <div class="col-xs-12">   
                                        <img class="js-icon" src="" alt="icon">
                                    </div>
                                    <div class="col-xs-12">   
                                        <span>Temperatura: <span class="js-temp"></span>&nbsp;<span class="js-temp-unit">°C</span></span>
                                    </div>
                                    <div  class="col-xs-12">
                                        <span>Pritisak: <span class="js-pressure"></span>&nbsp;<span class="js-pressure-unit">hPa</span></span>
                                    </div>
                                    <div  class="col-xs-12">
                                        <span>Vlaznost: <span class="js-humidity"></span>&nbsp;<span class="js-humidity-unit">%</span></span>
                                    </div>
                                    <div  class="col-xs-12">
                                        <span>Brzina vjetra: <span class="js-speed"></span>&nbsp;<span class="js-speed-unit">m/s</span></span>
                                    </div>
                                    <div class="col-xs-12">
                                        <span>Latitude: <span class="js-lat"></span>&nbsp;<span class="js-lat-unit">°</span></span>
                                    </div>
                                    <div class="col-xs-12">
                                        <span>Longitude: <span class="js-long"></span>&nbsp;<span class="js-lon-unit">°</span></span>
                                    </div>
                                </div> 
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-8 col-xs-12">
                        <div class="row">
                            <h4>Naredni dani</h4>
                        </div>
                        <br>
                        <div class="row js-weather-result">  

                        </div>
                    </div>
                </div>
            </div>
        </div> 

        <!-- Footer -->
        <footer class="container-fluid text-center">     
            <p>Copyright &copy; <span class="copyright">2015</span> Planner</p> 
        </footer>
       
        <script src="scripts/common.js"></script>
        <script src="scripts/weather.js"></script>
    </body>
</html>