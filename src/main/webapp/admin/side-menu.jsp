<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
			background: #484848;
		}
	
		.side-menu{
			background: #484848;
			color: white;
			height: 100%;
		}
		li{
			list-style: none;
			padding: 10px;
			font-size: 20px;
			border-bottom: 1px solid rgba(107, 108, 109, 0.19);
		}
		
		li a{
			color: #B5B5B5;
		}
		
		a:link { text-decoration: none}
		a:hover { color: #00CCCC} 
	</style>   
</head>
<body>
	<div class="side-menu">
		<ul>
			<li><a href="http://localhost:8080/webstorepractise/admin/manageGoods?action=getPageData&currentPage=1" target="content">Manage All</a></li>
			<li><a href="categories-management.jsp" target="content">Manage by Categories</a></li>
			<li><a href="manageAccount.jsp" target="content">Manage Account</a></li>
		</ul>
	</div>
	
</body>
</html>