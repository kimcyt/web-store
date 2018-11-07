<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="model.Category"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Web Store Manager</title>
</head>
	<%
		HashMap<Integer, String> categories = Category.getCategories();
			  application.setAttribute("categories", categories);
	%>
  
	<frameset rows="70, *" frameborder="no" border="0" framespacing="0">
		<frame src="top.jsp" name="topFrame" scrolling="no" noresize="noresize">
		<frameset cols="250, *" frameborder="no" border="0" framespacing="10">
			<frame src="side-menu.jsp" name="sideMenu" scrolling="no">
			<frame src="http://localhost:8080/webstorepractise/admin/manageGoods?action=getPageData&currentPage=1" name="content">
		</frameset>
	</frameset> 
	
</html>