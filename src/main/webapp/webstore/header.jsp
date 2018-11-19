<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="common.css" rel="stylesheet">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
</head>
<body>
	<div class="header_top row">
		<div class="col-md-4 offset-md-8">
			<!-- check if user already login -->
			<c:if test="${empty user }">
				<a href="login.jsp">Login</a>
				<a href="signup.jsp">Sign up</a>
			</c:if>
			<c:if test="${!empty user }">
				<a href=""> ${user.username }</a>
				<a href=""> Logout</a>
			</c:if>
			<a href="">Shopping Cart</a>
		</div>
	</div>
	<div class="header_mid row">
		<div id="icon" class="col-md-3">
			<img src="../images/logo.png">
		</div>
		<div class="center col-md-6">
			<div class="input-group mb-3 search_box">
				<input type="text" class="form-control" placeholder="Search"
					aria-label="Search" aria-describedby="search">
				<div class="input-group-append">
					<button class="btn btn-outline-secondary" type="button" id="search">Search</button>
				</div>
			</div>
		</div>
	</div>
	
	<div class="header_bottom row">
		<nav class="col-md-12 navbar navbar-expand-lg navbar-light bg-light"> 
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarNav" aria-controls="navbarNav"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav">
					<li class="nav-item active">
						<a class="nav-link" href="#">Main Page
							<span class="sr-only">(current)</span>
						</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="#">Office Supplies</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Furniture</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Fresh Produce</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Books Audio</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Cosmetics</a></li>
				</ul>
			</div>
		</nav>
	</div>

	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
		integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
		integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
		crossorigin="anonymous"></script>
</body>
</html>