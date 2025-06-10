<!-- 本ファイルはメニューエリアを表示する JSP です。 -->

<!-- TODO: 現在は仮の実装です。必要に応じて修正または書き換えてください。 -->

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- 左メニューエリア -->
<div class="menu-container">
	<ul class="menu-list">
		<a href="<c:url value='/main/menu.jsp'/>">メニュー</a>
		<br>
		<a href="<c:url value='StudentList.action'/>">学生管理</a>
		<br>
		成績管理
		<br>
		　<a href="<c:url value='sample.jsp'/>">成績登録</a>
		<br>
		　<a href="<c:url value='sample.jsp'/>">成績参照</a>
		<br>
		<a href="<c:url value='SubjectList.action'/>">科目管理</a>
	</ul>
</div>