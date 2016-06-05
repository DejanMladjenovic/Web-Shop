<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Bootstrap 101 Template</title>

    <!-- Bootstrap -->
    <link rel="stylesheet" href="bootstrap/bootstrap.css">
    <link rel="stylesheet" href="css/stylesheet.css">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  
  <body>
	
	<nav class="navbar navbar-default">
		<h3 class="text-center col-sm-6">Mobile-Shop</h3>
		<form class="col-sm-6" action="#" method="post">
		<ul class="list-inline">
			<li>
				<label  for="username">Korisnicko ime: </label>
				<input type="text" name="username" class="form-control">
			<li>
				<label for="password">Lozinka:</label>
				<input type="password" name="password" class="form-control">
			<li>
				<button type="submit" >Prijavi se!</button>
		</ul>
		</form>
	</nav>
	
	<div class="container" >
		<div class="row">
			<div class="col-sm-6 text-center">
				<h3>Mobile-shop</h3>
					<p>je online prodavnica mobilnih telefona.</p>
				<p>Pronadjite mobitel koji odgovara bas vama.</p>
				<p>Narucite vec danas i mi cemo ga dostaviti u roku 3 dana.</p>
				<p>Za ulaz na stranicu molimo da se prijavite!</p>
			</div>
		
			<div class="col-sm-3 col-sm-offset-3">
				<h3>Novi korisnik!</h3>
				<form class="form-horizontal" action="#" method="post">
					<div class="form-group">
						<label for="firstName">Ime:</label><br>
						<input type="text" id="firstName" pattern="[A-Za-z]{3,}" title="Samo slova. Min 3 karaktera">
					</div>
					
					<div class="form-group">
						<label for="lastName">Prezime:</label><br>
						<input type="text" name="lastName" pattern="[A-Za-z]{3,}" title="Samo slova. Min 3 karaktera">
					</div>
					
					<div class="form-group">
						<label for="address">Adresa:</label><br>
						<input type="text" name="address" pattern=".{3,}" title="Minimalno 3 slova">
					</div>
					
					<div class="form-group">
						<label for="phoneNumber">Telefon:</label><br>
						<input type="text" name="phoneNumber" pattern=".{6,}" title="Minimalno 6 karaktera">
					</div>
					
					<div class="form-group">
						<label for="username">Korisnicko ime:</label><br>
						<input type="text" name="username" pattern="[A-Za-z]{5,}" title="Samo slova. Min 5 karaktera">
					</div>
					
					<div class="form-group">
						<label for="password">Lozinka:</label><br>
						<input type="password" name="password" pattern=".{5,}" title="Minimalno 5 karaktera">
					</div>
					
					<div>
						<button type="submit" class="btn btn-success" name="submit">Potvrdi registraciju!</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	
	
	
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="bootstrap.min.js"></script>
  </body>
</html>