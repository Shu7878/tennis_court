<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>テニスコート一覧 確認画面</title>
</head>
<body>
	<h1>テニスコート一覧　確認ページ</h1>
	<form action="TennisCourt" method="post">
		<p>検索したい市区町村を入力してください</p>
		<p>(例：茨木市　※漢字に誤りがあると適切に処理されないことがあります。)</p>
		<p>
			<input type="text" name="paramAddress" value=""/>
			<input type="hidden" name="btn" value="NameSearch"/>
			<input type="submit" value="検索"/>
		</p>
	</form>
		<c:if test="${not empty requestScope.message }">
			<p class = "message"> ${requestScope.message}</p>
		</c:if>
		<c:if test = "${not empty requestScope.courtList}">
		<h2>検索結果</h2>
		<table border = "1" summary = "検索結果をまとめたもの">
				<tr>
					<th>ID</th>
					<th>名前</th>
					<th>場所</th>
					<th>利用金額（１時間あたり）</th>
					<th>利用可能時間</th>
					<th>&nbsp;</th>
				</tr>
				<c:forEach var = "court" items = "${requestScope.courtList }">
				<tr>
					<td><c:out value = "${court.court_id }"/></td>
					<td><c:out value = "${court.court_name }"/></td>
					<td><c:out value = "${court.court_address }"/></td>
					<td><c:out value = "${court.court_cost } 円"/></td>
					<td><c:out value = "${court.court_time }"/></td>
					<td>
						<form action="DeleteCourt" method="get">
							<input type="hidden" name="courtId" value="${court.court_id }"/>
							<input type="submit" value="削除"/>
						</form>
					</td>
				</tr>
			</c:forEach>
		</table>
		</c:if>

</body>
</html>