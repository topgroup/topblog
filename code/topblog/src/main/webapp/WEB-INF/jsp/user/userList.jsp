<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>
	<form action="/topblog/loginOut">
		<div>
			<input type="submit" value="注销"/>
		</div>
		<c:forEach items="${userList }" var="userItem">
			<h2>${userItem.userid }/${userItem.username} </h2>
			<ur>
				<li>${ userItem.userid }</li>
				<li>${ userItem.username }</li>
				<li>${ userItem.sex == true ? '男' : '女' }</li>
				<li>${ userItem.userno }</li>
			</ur>
		</c:forEach>
	</form>
</body>
</html>
