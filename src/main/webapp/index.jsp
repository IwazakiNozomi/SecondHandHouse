<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
</head>
<body>

<form:form action="/login" method="post" modelAttribute="account">
	
		<input type="text" name="email"/><form:errors path="email"></form:errors>
		<input type="password" name="password"/><form:errors path="password" ></form:errors>
		
		<input type="submit" value="登录" />
</form:form>
	

</body>
</html>