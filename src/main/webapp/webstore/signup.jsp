<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>sign up</title>
    <link href="/webstorepractise/webstore/signup.css" rel="stylesheet">
</head>
<body>
    <div class="header">
        <div class="center">
            <div class="left_block">
                <img src="/webstorepractise/images/logo.jpg">
            </div>
            <div class="right_block">
                <p>Already have account? <a href="/webstorepractise/webstore/login.jsp"><em>login here</em></a></p>
            </div>
        </div>

    </div>

    <div class="body">
        <div class="form">
            <form id="signupForm" action="http://localhost:8080/webStore/signup" method="post">
            	<div><label>userId</label><input id="userId" type="text" name="userId" required><br></div>
                <div><label>username</label><input id="username" type="text" name="username" required><br></div>
                <div><label>password</label><input id="password1" type="password" name="password" required><br></div>
                <div><label>confirm password</label><input id="password2" type="password" name="repassword" required><br></div>
                <div><label>email</label><input id="email" type="text" name="email" required><br></div>
                <div id="submit"><input type="button" value="Sign Up" onClick=checkUserInputs()></div>
            </form>
        </div>

    </div>

	<script type="text/javascript">
	
		function checkUserInputs(){
			console.log("Iam in check input ");
			let userId = document.getElementById("userId").value;
			let username = document.getElementById("username").value;
			let pwd1 = document.getElementById("password1").value;
			let pwd2 = document.getElementById("password2").value;
			let email = document.getElementById("email").value;
			if(!userId || !username || !pwd1 || !pwd2 || !email){
				return alert("Please enter all the required fields");
			}
			if(pwd1 != pwd2){
				return alert("Two passwords must be the same");
			}
			let form = document.getElementById("signupForm");
			form.submit(); //same as the form action
		}
	</script>

</body>
</html>