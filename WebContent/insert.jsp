<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>テニスコート情報　登録ページ</title>
</head>
<body>
	<h1>コート情報登録ページ</h1>
	<p><c:out value="${message }"/></p>
	<form action="InsertCourt" method="post">
		<table border="1" summary="コート情報登録フォーム">
			<tr>
				<td>ID</td>
				<td><input type="text" name="id" value=""/></td>
			</tr>
			<tr>
				<td>名前</td>
				<td><input type="text" name="name" value=""/></td>
			</tr>
			<tr>
				<td>市の名前</td>
				<td><input type="text" name="address" value=""/></td>
			</tr>
			<tr>
				<td>コートの金額</td>
				<td><input type="text" name="cost" value=""/></td>
			</tr>
			<tr>
				<td>利用可能時間</td>
				<td><input type="text" name="time" value=""/></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="hidden" name="btn" value="InsertCourt"/>
					<input type="submit" value="登録"/>
				</td>
			</tr>
		</table>
	</form>
	<p><a href="TennisCourt">コート検索ページへ</a></p>
</body>
</html>