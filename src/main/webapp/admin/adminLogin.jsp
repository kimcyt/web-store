<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Web Store Manager</title>
<link href="login-styles.css" rel="stylesheet">
</head>
<body>
	<div id="login">
		<h2>Web Store Admin System</h2>
		<form action="http://localhost:8080/webstorepractise/admin/login" method="post">
			<div id="username">
				<span>Username</span><input type="text" name="accountId" required>
			</div>
			<br>
			<div id="password">
				<span>Password</span><input type="password" name="password" required>
			</div>
			<br><br>
			<input type="checkbox"><span>Remember me</span>
			<br>
			<input id="submit" type="submit" value="GO">
		</form>
	</div>
</body>   
<script type="text/javascript">

</script>
</html>