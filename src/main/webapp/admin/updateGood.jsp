<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit</title>
</head>
<body>   
	<h2>Edit Item</h2>
	<form action="http://localhost:8080/webstorepractise/admin/manageGoods?action=update&currentCategory=${category }" method="post">
		<input type="text" name="currentPage" value="${currentPage }" style="display:none">
		<input type="text" name="gId" value="${currentGood.gId }" style="display:none">
		<span>Item name: </span><input type="text" name="name" value="${currentGood.name }"><br>
		<span>Picture: </span><input type="file" name="image" value="${currentGood.image }"><br>
		<span>Price: </span><input type="text" name="price" value="${currentGood.price }"><br>
		<span>Category: </span> 
		<select name="category" id="category">
			<c:forEach items="${allCategories }" var="category">
				<option value="${category.NO }">${category.name }</option>
			</c:forEach>	
		</select>
		<br>
		<span>OnSale: </span>
		<select name="onsale" id="onsale">
			<option value="1">YES</option>
			<option value="0">NO</option>
		</select>
		<br>
		<input type="submit" value="Update Item"> 
	</form>
	<c:if test="${empty category }">
		<a href="http://localhost:8080/webstorepractise/admin/manageGoods?action=getPageData&currentPage=${currentPage }">Go Back</a>
	</c:if>
	<c:if test="${!empty category }">
		<a href="http://localhost:8080/webstorepractise/admin/manageGoods?action=getPageData&currentPage=${currentPage }&category=${category}">Go Back</a>
	</c:if>
	

	<script type="text/javascript">
		//run as the webpage loads
		$(function(){
			document.getElementById("category")["${currentGood.category}"].selected=true; 
			document.getElementById("category")["${currentGood.onsale}"].selected=true; 
			$("#category option[value=${currentGood.category}]").prop("selected", true);
			$("#onsale option[value=${currentGood.onsale}]").prop("selected", true);
		});
	</script>
</body>
</html>