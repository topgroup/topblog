<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>
<form action="/topblog/loginOut">
<div>
	<input type="submit" value="注销"/>
</div>
<div>
	<h2>Hello World!  ${user.userid},S${user.userno }(${user.username}) </h2>
</div>
</form>
</body>
</html>
