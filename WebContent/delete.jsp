<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>コート情報　削除のページ</title>
</head>
<body>
	<h1>コート情報　削除ページ</h1>
	<c:if test="${not empty confirmMessage }">
		<p><c:out value="${confirmMessage }"/></p>
		<form action="DeleteCourt" method="post">
			<p>
				<input type="hidden" name="courtId" value="${court_id}"/>
				<input type="submit" value="削除"/>
			</p>
		</form>
	</c:if>
	<c:if test="${not empty completeMessage }">
		<p><c:out value="${completeMessage }"/></p>
	</c:if>
	<p><a href="TennisCourt">コート検索ページへ</a></p>
</body>
</html>