<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<link href="main.css" rel="stylesheet">
</head>
<body>
    <div class="header">
        <div class="header_top">
            <p>Welcome to Ant Online Store</p>
            <!-- check if user already login -->
            <c:if test="${empty user }">
                <a href="login.jsp">Login</a>
            	<a href="signup.jsp">Sign up for free</a>
            </c:if>
            <c:if test="${!empty user }">
                <a href=""> ${user.username }</a>
                <a href="login.jsp"> Logout</a>
            </c:if>
     
            <a href="">Shopping Cart</a>
            <a href="">My Order</a>
        </div>
        <div class="header_mid">
            <div class="center">
                <div id="icon">
                    <!--<img src="./images/u=3694969640,119489513&fm=27&gp=0.jpg">-->
                </div>
                <div class="search_box">
                    <form>
                        <input type="text" id="search" placeholder="please enter key word">
                        <input type="submit" id="submit" value="search" > <br>
                        <a href="">dress</a>
                        <a href="">jeans</a>
                        <a href="">hat</a>

                    </form>
                </div>
                <div id="scan_code">

                </div>
            </div>

        </div>
        <div class="header_bottom">
            <ul>
                <li><a href="">Main Page</a></li>
                <li><a href="/webstore/GoodsServlet">Office Supplies</a></li>
                <li><a href="">Furniture</a></li>
                <li><a href="">Fresh Produce</a></li>
                <li><a href="">Books Audio</a></li>
                <li><a href="">Fashion Designs</a></li>
            </ul>
        </div>
    </div>

</body>
</html>