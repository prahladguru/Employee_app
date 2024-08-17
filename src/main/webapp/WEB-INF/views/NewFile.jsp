<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
	<%@ include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body style="background-color:aqua;">
	<h2>add employee</h2>
	<h3>you can enter your details here....</h3>

	<form action="addEmployee" method = "post">
		<pre>
       NAME:    <input type="text" name="firstName">
       EMAIL ID:<input type="text" name="email">
       MOBILE:  <input type="text" name="mobile">
      <input type="submit" name="save">
      </pre>
	</form>
	
	${msg}
	
	<c:out value="100"></c:out>
	<c:set var = "x" value ="200"></c:set>
	<c:out value="${x}"></c:out>
	
	 <c:forEach var = "i" begin = "1" end = "5">
         Item <c:out value = "${i}"/><p>
      </c:forEach>
      
       <c:set var = "salary" scope = "session" value = "${2000*2}"/>
      <c:if test = "${salary > 2000}">
         <p>My salary is:  <c:out value = "${salary}"/><p>
      </c:if>
	
</body>
</html>