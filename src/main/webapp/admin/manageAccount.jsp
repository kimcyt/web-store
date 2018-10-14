<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Manage Account</h1>
	<br>
	<div class="update-account">
		<form id="form" action="http://localhost:8080/webStore/admin/updateAdmin?accountId=${admin.accountId }" method="post">
			<span>User: ${admin.accountId }</span><br>
			<span>Reset Password:</span><br>
			<span>Old Password</span><input type="password" name="oldPwd" required><br>
			<span>New Password</span><input id="new1" type="password" name="newPwd1" required><br>
			<span>Retype Password</span><input id="new2" type="password" name="newPwd2" required> <span id="unmatched"></span><br>
			<input type="submit" value="Submit" onClick=checkInputs(event) >
		</form>
	</div>
	
	<script src="jquery.min.js"></script>
	<script>
		function checkInputs(event){
			event.preventDefault();
			let pwd1 = document.getElementById("new1").value;
			let pwd2 = document.getElementById("new2").value;
			//let pwd1 = $("#form[name=newPwd1]").val();
			//let pwd2 = $("#form[name=newPwd2]").val();
			console.log(pwd1,pwd2);
			if(pwd1===pwd2){
				$("#form").submit();
			} else{
				document.getElementById("unmatched").innerHTML = "Password unmatched";
			}
		}
		
		
	</script>
</body>
</html>