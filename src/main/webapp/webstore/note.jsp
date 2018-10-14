<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- html注释，会被 out.print到页面源码

jsp本质上是servlet文件，用out.write()把每一行写到browser, 编译成jsp.class在tomcat work 目录里被执行
在 server web.xml里有url-pattern *.jsp/*.jspx mapping to jsp servlet 去输出jsp文件内容到浏览器
要把前端所有html改成jsp
！！！建议不要直接发送请求到jsp，发到servlet后在四大域中储存数据，redirect 到jsp去显示

<%-- jsp注释:只在此处可见  --%>
java code, 放到 jsp servlet 的 service方法内部
<%
//java注释 or /* 页面中看不到 */
String name = "hello";
%>

直接输出： out.print(var/expression)
<%=name %>
<%=1+1 %>

变成class attribute
<%! String name1 = "hello"; %>


/////////////////指令
-page: jsp settings
<%@ page
pageEncoding="UTF-8"
%>
<%@page import="java.util.*"
%>
--contentType: 指定MIME和编码格式， 等同 response.setContentType()
--pageEncodeing: jsp file 编码
--import: 导入需要的class
--session:指定当前页面能否获得用户的session, true by default, 可直接获取session
<%
session.setAttribute(name, "hello");
%>
--errorPage:发生错误时跳转的页面，可为jsp
--extends: jsp继承的类，不要修改
--


-include: for importing repeated html， 静态包含：先替换成jsp,加入到原有jsp，再用servlet输出
<%@ include file="/some.jsp" %>
<h1> nbbbb </h1>


-taglib: 导入第三方jsp标签库



/////////////////////标签动作
-page include: 动态包含：每个jsp=>java,再合成所有java
<jsp:include page="/mm.jsp></jsp:include>"

-请求转发 request redirection
<jsp:forward page=""></jsp:forward>


-隐式对象： jsp翻译为servlet后有9个对象初始化完毕可以直接使用
--pageContext：域对象-set/get/removeAttribute，获取当前页面信息 
setAttribute(key, value, pageContext.SESSION_SCOPE) 可写入其他域-session/request
可通过其他域getAttribute来取： session.getAttribute(key)
可获取其他八个对象
--session, 
--servletContext-application, 
--servletConfig-config, 
--out：
out.write()写到out缓冲区，ie. <<%= "aa" %> / aa   ,  被统一添加到response缓冲区（后面）
response.write()写到response缓冲区
out 缓冲区8kb,设为0的话直接加到response缓冲区
  
--page：当前jsp转换成的servlet的实例, 
--request, response
--exception 表示jsp中发生的异常，可在errorPage中使用


///////////////////////EL/JSTL

EL:减少脚本编写，获得四大域中的数据
-${pageScope.key}： get value from pageContext/request/session/servletContext(application) (add Scope)
-或者省略scope， 直接用key取，默认从小scope到大取,取到就停 : ${key}
-${expression}
-${empty object} return t/f
   
JSTL: 
-引入库： <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"   %>  //c为核心库
-if :
   -<c:if condition> 满足才会显示内容  </c:if>
   -没有else,只能重复多个if
-for each
  -普通循环： 自动从PageScope中存储数据
   <c:forEach begin="0" end="5" var="i">
       ${i}
   </c:forEach>
  -增强for循环： 遍历集合
  <c:forEach items="${集合name}" var="element">
  </c:forEach>
     
     
////////////////////mvc: jsp(view)+servelt(controller)+javabean(model)
-三层架构：
 ->web(jsp, web servlet that give/get data to/from jsp)
 -> service(service servlet that get data from dao) 
 -> DAO(database operations)


 -->
 
 
 
 
</body>
</html>