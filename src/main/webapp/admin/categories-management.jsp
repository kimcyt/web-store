<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">

.category-list {
	width: 400px;
	margin: 0 auto;
}

.category-list li{
	list-style: none;
	font-size: 26px;
	margin-bottom: 40px;
}

.category-list a{
	text-decoration:none;
}

.category-list a:visited, a:link{
	color: blue;
}

.category-list a:hover{
	color: #00CCCC
}
</style>

</head>
<body>
	<div class="category-list">
		<ul>
			<c:forEach var="i" begin="1" end="${categories.size()}">
				<li><a href="http://localhost:8080/webstorepractise/admin/manageGoods?action=getPageData&currentPage=1&category=${i}">${categories.get(i)}</a></li>
			</c:forEach>
		</ul>
	</div>
	   

</body>
</html>