<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="utf-8">
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<title>yeeeh</title>
</head>
<body>
	<c:if test="${!empty message}">
		<h1>${message}</h1>
	</c:if>
	<h2>PC</h2>
	<div class="table-responsive">
		<table class="table table-hover" style="table-layout:fixed;">
		<thead>
			<tr>
				<th style="width:100px;">PC名</th>
				<th style="width:100px;">シリアルNo</th>
				<th>ユーザー</th>
				<th>状況</th>
				<th>状態</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="viewMachine" items="${machineListResult.machines}" varStatus="status">
        		<tr>
				<td style="width:10px;"><a href="${pageContext.request.contextPath}/machine/edit/">${viewMachine.name}</a></td>
				<td style="width:10px;">${viewMachine.serialNo}</td>
				<td style="width:10px;">${viewMachine.userName}</td>
				<td style="width:10px;">${viewMachine.statusName}</td>
				<td style="width:10px;">${viewMachine.stateName}</td>
				<td></td>
			</tr>
			</c:forEach>
		</tbody>
		</table>
		<c:set var="currentOffset" value="${machineListResult.currentOffset}" />
		<p>現在ページ：<c:out value="${currentOffset}"></c:out></p>
		<c:set var="maxViewOffset" value="${machineListResult.maxViewOffset}"/>
		<c:set var="minViewOffset" value="${machineListResult.minViewOffset}"/>
		<c:if test="${minViewOffset != 1 }">
			<a href="${pageContext.request.contextPath}/machine/list?page=1" >&lt;&lt;</a>
		</c:if>
		<c:forEach begin = "${minViewOffset}" varStatus="status" end = "${maxViewOffset}">
			
			<c:choose>
				<c:when test="${status.index == currentOffset}">
					<a><c:out value="${status.index}"></c:out></a>
				</c:when>
				<c:otherwise>
					<c:param name="page" value="${status.index}"/>
					<a href="${pageContext.request.contextPath}/machine/list?page=${status.index}">${status.index}</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<c:set var="maxPage" value="${machineListResult.maxPage}" />
		<c:if test="${maxViewOffset != maxPage}">
			<a href="${pageContext.request.contextPath}/machine/list?page=${maxPage}" >&gt;&gt;</a>
			
		</c:if>
<%-- 		<a>${viewCount} /${machineCount} 件</a><a>${offset} /${pages} ページ</a><a>&gt;&gt;</a>
 --%>	</div>

 		
	<form action="${pageContext.request.contextPath}/machine/list"
		method="get">
		<input type="submit" name="gotoRegister" value="登録画面へ">
	</form>
	<script src="/resources/js/bootstrap.min.js"></script>
</body>
</html>
