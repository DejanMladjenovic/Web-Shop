<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Novi artikal</title>

    <!-- Bootstrap -->
    <link rel="stylesheet" href="bootstrap/css/bootstrap.css">
    <link rel="stylesheet" href="css/stylesheet.css">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
	
	<jsp:include page="includes/header.jsp"></jsp:include>
	<c:import url="/PhonesListServlet" />


	<div class="container">
		<h3 class="text-center"><c:out value="${addPhoneScreen}" /></h3>
		
		<h3 class="text-center">Novi artikal:</h3>
		<form action="AddPhoneServlet" method="post" class="form-horizontal">
			<div class="form-group">
				<label for="manufacturer" class="col-md-offset-3 col-md-1 ">Proizvodjac:</label>
				<div class="col-md-5">
					<input type="text" class="form-control" name="manufacturer">
				</div>
			</div>

			<div class="form-group">
				<label for="model" class="col-md-offset-3 col-md-1">Model:</label>
				<div class="col-md-5">
					<input type="text" class="form-control" name="model">
				</div>
			</div>

			<div class="form-group">
				<label for="operating_system" class="col-md-offset-3 col-md-1">Operativni sistem:</label>
				<div class="col-md-5">
					<input type="text" class="form-control" name="operating_system">
				</div>
			</div>

			<div class="form-group">
				<label for="description" class="col-md-offset-3 col-md-1">Opis:</label>
				<div class="col-md-5">
					<textarea class="form-control" name="description"></textarea>
				</div>
			</div>

			<div class="form-group">
				<label for="price" class="col-md-offset-3 col-md-1">Cijena (u KM):</label>
				<div class="col-md-5">
					<input type="number" class="form-control" name="price">
				</div>
			</div>
			
			<div class="form-group">
				<label for="amount" class="col-md-offset-3 col-md-1">Broj komada:</label>
				<div class="col-md-5">
					<input type="number" class="form-control" name="amount">
				</div>
			</div>
			<div class="form-group">
				<label for="picture" class="col-md-offset-3 col-md-1">Slika:</label>
				<div class="col-md-5">
					<input type="text" class="form-control" name="picture" placeholder="Link do slike">
				</div>
			</div>
			
			<div class="text-center">
				<button type="submit" class="btn btn-primary text-center" name="submit"
					value="Submit">Dodaj</button>
			</div>
		</form>
	</div>

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="bootstrap/js/bootstrap.min.js"></script>
  </body>
</html>