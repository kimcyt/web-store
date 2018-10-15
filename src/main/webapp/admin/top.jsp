<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
   
*{
	margin: 0;
	padding: 0;
	box-sizing: border-box;
}


.top{
	width: 100%;
	background: #00CCCC;
	position: relative;
}

#top-left{
	color: white;
	font-size: 20px;
	background: #484848;
	width: 250px;
	height: 60px;
	display: inline-block;
	padding: 15px;
}

#top-right{
	display: inline-block;
}

#top-right a{
	position: absolute;
	right: 20px;
	top: 5px;
}

</style>
</head>

<body>
	<div class="top">
		<div id="top-left">
			<span>Web Store Manager</span>
		</div>
		<div id="top-right">
			<a href="">Hello ${admin.accountId }</a>
		</div>
	</div>
</body>

</html>