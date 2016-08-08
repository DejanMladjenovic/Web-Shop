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
    <title>Moji podaci</title>

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

	<div class="container">
		<div>
			<h3>Moji podaci</h3>
		</div>
		<div>
			<table class="table table-hover">
				<tr>
					<td>Ime:</td>
					<td>${user.firstName}</td>
				<tr>
					<td>Prezime:</td>
					<td>${user.lastName}</td>
				<tr>
					<td>Adresa:</td>
					<td>${user.address}</td>
				<tr>
					<td>Broj telefona:</td>
					<td>${user.phoneNumber}</td>
				<tr>
					<td>Korisnicko ime:</td>
					<td>${user.username}</td>
				<tr>
					<td>Lozinka:</td>
					<td>${user.password}</td>
				</tr>
			</table>
		</div>
	</div>

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="bootstrap/js/bootstrap.min.js"></script>
  </body>
</html>