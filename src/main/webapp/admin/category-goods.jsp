<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="model.Category"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="pageStyle.css">
<style type="text/css">
.content{
	background: white;
	margin: 0;
	padding: 0;
	box-sizing: border box;
}

.commands button{
	width: 80px;
	height: 30px;
	font-size: 18px;
}

.goods-display{
	padding: 30px;
}

.goods-list th{
    margin: 20px;
    font-size: 20px;
    padding: 20px;
}

.goods-list a{
	text-decoration:none;
}

.goods-list a:visited, a:link{
	color: blue;
}

.goods-list a:hover{
	color: #00CCCC
}

</style>
</head>
<body>
	<div class="content">
		<h1>Goods Management</h1>
		<br>
		<c:if test="${!empty category}">
			<h2>${Categories.getCategories().get(Integer.parseInt(category))}</h2>
		</c:if>
		<div class="commands">
		<!--todo: go to add directly with category = current category-->
			<a href="http://localhost:8080/webstorepractise/admin/manageGoods?action=getCategory&category=${category}"><button>Add Item</button></a>
		</div>
		<div class="goods-display">
			
			<c:if test="${empty pageInfo}">
				No goods available.
			</c:if>
			
		  	<c:if test="${!empty pageInfo}">
			  	<table class="goods-list">
				  <tr >
				    <th>ID</th>
				    <th>Picture</th>
				    <th>Name</th>
				    <th>Price</th>
				    <th>Category</th>
				    <th>OnSale</th>
				    <th>Edit</th>
				    <th>Delete</th>
				  </tr>
					  <c:forEach items="${pageInfo.goodList }" var="good" varStatus="status">
						<tr >
						  <th>${good.gId}</th>
						  <th><img src="" alt=""></th>
						  <th>${good.name }</th>
						  <th>${good.price }</th>
						  <th>
						  ${categories.get(good.category) }
						  </th>
						  <th>
							 <c:if test="${good.onsale==0}">
								NO
							 </c:if>
							 <c:if test="${good.onsale==1}">
								YES
							 </c:if>
						  </th>
						  <th><a href="http://localhost:8080/webstorepractise/admin/manageGoods?action=getGood&gId=${good.gId }&currentPage=${pageInfo.currentPage}&category=${category}">Edit Item</a></th>
						  <th><a href="http://localhost:8080/webstorepractise/admin/manageGoods?action=delete&gId=${good.gId }&currentPage=${pageInfo.currentPage}&category=${category}">Delete Item</a></th>
						</tr>
					  </c:forEach>
				</table>
			</c:if>
		  	
		</div>
		<div id="page" class="page_div"></div>
	</div>
	
	<script src="jquery.min.js"></script>
	<script type="text/javascript" src="paging.js"></script>
	<script>
	    $("#page").paging({
	        pageNo:${pageInfo.currentPage},  /*当前选中的是哪一页*/
	        totalPage: ${pageInfo.totalPages}, /*共多少页*/
	        totalSize: ${pageInfo.totalItems},/*共多少条记录*/
	        callback: function(num) {
	        	$(window).attr("location", 
	        			"http://localhost:8080/webstorepractise/admin/manageGoods?action=getPageData&currentPage="+num+"&category="+${category});
	        }    
	    })
	</script>
</body>
</html>