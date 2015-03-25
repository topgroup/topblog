<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>
<div>用户注册</div>
<div>
	<form action="/topblog/user/regedit" method="post">
		<table>
		<tr><td>
			id：<input type="text" name="userId" />
		</td></tr>
		<tr><td>
			name:<input type="text" name="userName"/>
		</td></tr>
		<tr><td>
			sex:男<input type="radio" name="sexMan"/>女<input type="radio" name="sexWomen"/>
		</td></tr>
		<tr><td>
			userno:<input type="text" name="userNo"/>
		</td></tr>
		<tr>
			<td>
				<input type="submit" name="submit" value="submit"/>
			</td>
		</tr>
		</table>
	</form>
</div>
</body>
</html>
