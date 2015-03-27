<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"
    pageEncoding="UTF-8"%>

<html>
<body>
<h2>Login In</h2>
<form action="/topblog/login" method="post">
	<input type="text" name="userId" />
	<input type="text" name="userName" />
	<input type="submit" name="submit" />
	<span style="color:red">${msg }</span>
</form>
</body>
</html>
