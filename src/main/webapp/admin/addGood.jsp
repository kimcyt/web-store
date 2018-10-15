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

	<h2>Add Item</h2>
	<form action="http://localhost:8080/webstorepractise/admin/manageGoods?action=add" method="post">
		<span>Item name: </span><input type="text" name="name" required><br>
		<span>Picture: </span><input type="file" name="image" ><br>
		<span>Price: </span><input type="text" name="price" required><br>
		<span>Category: </span> 
		<c:if test="${!empty allCategories}">
			<select name="category">
				<c:forEach items="${allCategories }" var="category">
					<option value="${category.NO }">${category.name }</option>
				</c:forEach>	
			</select>
		</c:if>
		<c:if test="${empty allCategories}">
			<select name="category">
				<option value="${category.NO }">${category.name }</option>
			</select>
		</c:if>
		
		
		<br>
		<span>OnSale: </span>
		<select name="onsale">
			<option value="1">YES</option>
			<option value="0">NO</option>
		</select>
		<input type="submit" value="Submit Item"> 
	</form>
	<c:if test="${empty category }">
		<a href="http://localhost:8080/webstorepractise/admin/manageGoods?action=getPageData&currentPage=1">Go Back</a>
	</c:if>
	<c:if test="${!empty category }">
		<a href="http://localhost:8080/webstorepractise/admin/manageGoods?action=getPageData&currentPage=1&category=${category}">Go Back</a>
	</c:if>

</body>
</html>