<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
	<%@ include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>update employee</title>
</head>
<body>

	<h2>update employee</h2>
	<form action="updateEmployee" method="post">
		<pre>
		<input type="hidden" name="id" value="${employee.id}" />
	       NAME:    <input type="text" name="firstName"
				value="${employee.name }" />
	       EMAILID:<input type="text" name="email"
				value="${employee.email }" />
	       MOBILE:  <input type="text" name="mobile"
				value="${employee.mobile }" />
      <input type="submit" name="save" value="update">
      </pre>
	</form>

	${msg}
</body>
</html>