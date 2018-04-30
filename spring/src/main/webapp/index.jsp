<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
	<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
</head>
<body>
<h2>ログイン</h2>
<form action="${pageContext.request.contextPath}/machine/" method="post" >
	<input class="btn btn-default" type="submit" name="gotoList" value="click">
</form>
<ul>
	<li><a href="admin/admin.jsp">管理者</a></li>
	<li><a href="user/user.jsp">一般</a></li>
</ul>
<form action="${pageContext.request.contextPath}/machine/" method="post" >
	<input class="btn btn-default" type="submit" name="gotoList" value="一般">
</form>
<script src="/resources/js/bootstrap.min.js"></script>
</body>
</html>
