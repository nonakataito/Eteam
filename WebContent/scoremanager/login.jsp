<%@page contentType="text/html; charset=UTF-8"%>
<%@include file="/scoremanager/header.jsp"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<form action="<c:url value='/scoremanager/LoginExecute.action' />"
	method="post">
	<p>
		ID <input type="text" name="id">
	</p>
	<p>
		パスワード <input type="password" name="password">
	</p>
	<p>
		<input type="submit" value="ログイン">
	</p>
</form>

<%@include file="/scoremanager/footer.jsp"%>

<a href="<c:url value='/main/menu.jsp'/>">メニュー画面へ</a>


