<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Lista telefona</title>

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
		
		<c:if test="${fn:length(phones) == 0}">
			<h3 class="text-center">Nema artikala za prikaz!</h3>
		</c:if>
		
		<c:choose>
		
			<c:when test="${user.username.equals(\"admin\")}">
			<!-- Admin-->
			

				<table class="table table-hover table-bordered table-fixed-top">
					<thead>
						<tr class="success">
							<td>Id</td>
							<td>Proizvodjac</td>
							<td>Model</td>
							<td>OS</td>
							<td>Opis</td>
							<td>Cijena</td>
							<td>Kolicina</td>
							<td>Fotografija</td>
						</tr>
					</thead>
					<c:forEach items="${phones}" var="phone">
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
								<td>
									<form action="UpdateServlet" method="get">
										<button class="btn btn-primary" name="update"
											value="${phone.phoneId}">Azuriraj</button>
									</form>
								</td>
								<td>
									<form action="DeleteServlet" method="post">
										<button class="btn btn-danger" name="delete"
											value="${phone.phoneId}">Obrisi</button>
									</form>
								</td>
							</tr>
						</tbody>
					</c:forEach>
				</table>
			</c:when>

			<c:otherwise>
			<!-- User -->
				<div class="row">
					<c:forEach items="${phones}" var="phone">
						<div class="col-sm-6 col-md-4">
							<div class="thumbnail">
								<img src="${phone.picture}" alt="${phone.model}" />
								<div class="caption">
									<h3>${phone.manufacturer} ${phone.model}</h3>
									<h4>${phone.price} KM</h4>
									
									<div>
										<form action="PhoneServlet">
											<button class="btn btn-primary" name="details" value="${phone.phoneId}">Detaljnije!</button>
										</form>
										<c:if test="${user.username != null }">
										<a href="mycart.jsp">
											<button class="btn btn-success"> <c:set var="cart" value="${phone}" scope="session"></c:set>Dodaj u korpu!</button>
										</a>
										</c:if>
									</div>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
			</c:otherwise>
		</c:choose>

	</div>
	

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="bootstrap/js/bootstrap.min.js"></script>
</body>
</html>