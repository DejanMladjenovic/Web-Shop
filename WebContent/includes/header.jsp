<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav class="navbar navbar-default navbar-fixed-top navbar-inverse">
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="index.jsp">mobile-shop</a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li><a href="index.jsp">Pocetna<span class="sr-only">(current)</span></a></li>
				<li><a href="phoneslist.jsp">Mobiteli</a></li>
			</ul>
			<form action="SearchServlet" class="navbar-form navbar-left">
				<div class="form-group">
					<input type="text" name="search" class="form-control" placeholder="Proizvodjac ili model">
				</div>
				<button type="submit" class="btn btn-default">Pretrazi</button>
			</form>
			
			<ul class="nav navbar-nav navbar-right">
			<c:choose>
				<c:when test="${user.username == null}">
					<li><a href="mycart.jsp">Korpa</a></li>
					<li><a href="login.jsp">Prijava</a></li>
				</c:when>
				
				<c:when test="${user.username.equals(\"admin\")}">
				<!-- Admin -->
					<li><a href="mycart.jsp">Korpa</a></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">${user.username}<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="phoneslist.jsp">Artikli</a></li>
							<li><a href="addphone.jsp">Dodaj novi</a></li>
							<li role="separator" class="divider"></li>
							<li><a href="LogoutServlet">Odjava</a></li>
					</ul></li>
				</c:when>
				
				<c:otherwise>
				<!--User -->
				<li><a href="mycart.jsp">Korpa</a></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">${user.username}<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="#">Moje kupovine</a></li>
						<li><a href="myprofile.jsp">Moj profil</a></li>
						<li role="separator" class="divider"></li>
						<li><a href="LogoutServlet">Odjava</a></li>
					
					</ul>
				</li>
				</c:otherwise>
			</c:choose>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid -->
</nav>
<br>
<br>
<br>