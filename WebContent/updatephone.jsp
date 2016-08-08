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
    <title>Update</title>

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

	<h3><c:out value="${addPhoneScreen}" /></h3>
	

	<div class="container">
		
		<h4>Unesite nove podatke!</h4>
		
		<form action="UpdateServlet" method="post">
		<table class="table table-hover table-bordered">
			<thead>
				<tr class="success">
					<th>Id</th>
					<th>Proizvodjac</th>
					<th>Model</th>
					<th>OS</th>
					<th>Opis</th>
					<th>Cijena</th>
					<th>Kolicina</th>
					<th>Fotografija</th>
				</tr>
			</thead>
			<tbody class="tbody" style="background-color: lightgrey">
				<tr>
					<td><c:out value="${phone.phoneId}" /></td>
					<td><c:out value="${phone.manufacturer}" /></td>
					<td><c:out value="${phone.model}" /></td>
					<td><c:out value="${phone.operating_system}" /></td>
					<td><c:out value="${phone.description}" /></td>
					<td><c:out value="${phone.price}" /></td>
					<td><c:out value="${phone.amount}" /></td>
					<td><c:out value="${phone.picture}" /></td>
				</tr>
				<tr>
					<td><c:out value="${phone.phoneId}" /></td>
					<td><input type="text" name="manufacturer" size="10" value="${phone.manufacturer}"></td>
					<td><input type="text" name="model" size=10 value="${phone.model}"></td>
					<td><input type="text" name="operating_system" size=10 value="${phone.operating_system}"></td>
					<td><textarea name="description">${phone.description}</textarea></td>
					<td><input type="number" name="price" style="width: 5em;" value="${phone.price}"></td>
					<td><input type="number" name="amount" style="width: 5em;" value="${phone.amount}"></td>
					<td><input type="text" name="picture" size="10" value="${phone.picture}"></td>
				</tr>
			</tbody>
		</table>
		
			<button class="btn btn-primary" name="submit" value="${phone.phoneId}">Potvrdi</button>
		<a href="phoneslist.jsp" class="btn btn-danger">Otkazi!</a>
		</form>
	</div>

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="bootstrap/js/bootstrap.min.js"></script>
  </body>
</html>