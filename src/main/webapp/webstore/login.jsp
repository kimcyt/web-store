<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>login page</title>
    <link href="/webstorepractise/webstore/login_page.css" rel="stylesheet">
</head>
<body>
    <div id="header">
        <div class="h_logo">
            <img src="/webstorepractise/images/logo.jpg" alt="image not found" >
            <p>For security, please sign up with your valid ID.</p>
        </div>
    </div>

    <div id="middle_part" >
        <div id="login">
            <form action="http://localhost:8080/webstorepractise/loginuser" method="get">
                <div class="user_inputs">
                    <img src="/webstorepractise/images/user.png">
                    <input type="text" id="userId" name="userId" autofocus required> 
                </div>
                <div class="user_inputs">
                    <img src="/webstorepractise/images/password.png">
                    <input type="password" id="password" name="password" required> 
                </div>
                <div class="submit">
                    <input type="submit" value="Login" onclick="submit"> <br>
                </div>
                <div class="other_options">
                    <a href="">forgot password</a>
                    <a href="/webstorepractise/webstore/signup.jsp">signup</a>
                </div>
            </form>
        </div>
    </div>
    
    <%@ include file="footer.jsp" %>

</body>
</html>