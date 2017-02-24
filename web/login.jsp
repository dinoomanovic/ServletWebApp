<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta name="viewport" content="width=1,initial-scale=1,user-scalable=1" />
	<title>Planner</title>
	
	<link href="http://fonts.googleapis.com/css?family=Lato:100italic,100,300italic,300,400italic,400,700italic,700,900italic,900" rel="stylesheet" type="text/css">
	<link rel="stylesheet" type="text/css" href="assets/bootstrap/css/bootstrap.min.css" />
	<link rel="stylesheet" type="text/css" href="assets/css/styles.css" />
	
	<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>

	<section class="container">
			<section class="login-form">
                            <form method="post" action="login">
					<h2>Logujte se za pristup stranici</h2>
					<div class="form-group">
	    				<div class="input-group">
		      				<div class="input-group-addon"><span class="text-primary glyphicon glyphicon-user"></span></div>
							<input type="user" name="user" placeholder="Korisnik" required class="form-control" />
						</div>
					</div>
					<div class="form-group">
	    				<div class="input-group">
		      				<div class="input-group-addon"><span class="text-primary glyphicon glyphicon-lock"></span></div>
							<input type="pass" name="pass" placeholder="Password" required class="form-control" />
						</div>
		      				
                                                       <input id="active" float="center" type="checkbox" name="isChecked" checked="checked"> Zapamti me <br>
                                                     
                                                     
                    

                                                </div>
					</div>
					<button type="submit" name="go" class="btn btn-block btn-success">Login</button>
					<a href="register" class="btn btn-block btn-default">Kreirajte nalog</a>
				</form>
			</section>
	</section>
	
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="assets/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>