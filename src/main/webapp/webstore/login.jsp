<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>login page</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    
    <link href="/webstorepractise/webstore/login_page.css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-4 offset-md-4 header" >
            	<img src="/webstorepractise/images/logo.png" alt="local picture" >
			</div>	
		</div>
		
		<div class="row">
			<div class="col-md-4 offset-md-4 middle-part">
	        	<div class="login">
	            	<form action="http://localhost:8080/webstorepractise/loginuser" method="get">
	                	<div class="user_inputs">
	                    	<img src="/webstorepractise/images/user.png">
	                    	<input type="text" id="userId" name="userId" autofocus required> 
	                	</div>
	                	<div class="user_inputs">
	                    	<img src="/webstorepractise/images/pwd.png">
	                    	<input type="password" id="password" name="password" required> 
	                	</div>
	                	<div>
	                		<input type="submit" value="Login" onclick="submit"> 
	                	</div>
	                	<div class="other-options">
	                    	<a href="">forgot password</a>
	                    	<a href="/webstorepractise/webstore/signup.jsp">signup</a>
	                	</div>
	            	</form>
	        	</div>

			</div>
		</div>
		
		<div class="row">
			<div class="col-md">
				<%@ include file="footer.jsp" %>
			</div>
		</div>
	</div>
	
    
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</body>
</html>