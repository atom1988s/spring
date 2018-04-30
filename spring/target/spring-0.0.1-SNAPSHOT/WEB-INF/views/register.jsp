<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${!empty messages}">
		<c:forEach items="${messages}" var="message">
			<c:out value="${message }"/><br>
		</c:forEach>
	</c:if>
	<form:form id="machineResisterForm" action="${pageContext.request.contextPath}/machine/${viewMode}" method="post" modelAttribute="machineResisterForm">
		<div class="form-group">
			<label>PC名</label>
			<c:if test="${viewMode == 'register'}">
			<form:input class="form-control" path="name" /><form:errors path="name" cssStyle="color:red"/>
			</c:if>
			<c:if test="${viewMode == 'edit'}">
			<input class="form-control" name="name" value="${machineResisterForm.name}" readonly="readonly"/>
			</c:if>
		</div>
		<div class="form-group">
			<label>シリアルNo</label>
			<form:input class="form-control" path="serialNo" />
		</div>
		<div class="form-group">
			<label>ユーザ</label>
			<form:input class="form-control" path="userId" />
		</div>
		<div class="form-group">
		<label>状況</label>
		<select class="form-control" name="statusId">
 		<c:forEach items="${machineCondition.statusList}" var="statusList" varStatus="varStatus">
				<option value="${statusList.statusId}" ${(statusList.statusId == machineResisterForm.statusId)?"selected":""}>${statusList.statusName}</option>
			</c:forEach>
		</select>
		</div>
		<div class="form-group">
		<label>状態</label>
		<select class="form-control" name="stateId">
 		<c:forEach items="${machineCondition.stateList}" var="stateList" varStatus="varStatus" >
				<option value="${stateList.stateId}" ${(stateList.stateId == machineResisterForm.stateId)?"selected":""}>${stateList.stateName}</option>
		</c:forEach>
		</select>
		</div>
		<input type="hidden" name="delFlg" value=0>
		<c:if test="${viewMode == 'register'}">
		<div class="form-group">
			<input class="btn btn-default" type="submit" name="insert" value="登録">
		</div>
		</c:if>
		<c:if test="${viewMode == 'edit'}">
		<div class="form-group">
			<input class="btn btn-default" type="submit" name="modify" value="編集">
		</div>
		</c:if>		
		<div class="form-group">
			<input class="btn btn-default" type="submit" name="back" value="戻る">
		</div>
	</form:form>

</body>
</html>