<!-- 本ファイルはメニューエリアを表示する JSP です。 -->

<!-- TODO: 現在は仮の実装です。必要に応じて修正または書き換えてください。 -->

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- 左メニューエリア -->
<div class="menu-container">
	<h2>メニュー</h2>
	<h3>学生管理</h3>
	<ul class="menu-list">
		<li><a href="<c:url value='student/listAllStudent.jsp'/>">学生一覧</a></li>
		<li><a href="<c:url value='student/addStudent.jsp'/>">学生追加</a></li>
		<li><a href="<c:url value='student/updateStudentSelect.jsp'/>">学生更新</a></li>
		<li><a href="<c:url value='student/deleteStudentSelect.jsp'/>">学生削除</a></li>
	</ul>
</div>
