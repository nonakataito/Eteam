<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

	<title>学生情報登録</title>

	</head>
	<body>
	<h2>学生情報登録</h2>
<form action="StudentCreateExecute.action" method="post">
	<label>入学年度</label>
	<select name="ent_year">
		<c:forEach var="year" begin="2015" end="2035">
			<option value="${year}"
				<c:if test="${param.f1 == year.toString()}">selected</c:if>
	    	>${year}</option>
		</c:forEach>
	</select>
	<label>学生番号</label>
	<input type="text" name="no" maxlength="10"required placeholder ="学生番号を入力してください。">

	<label>氏名</label>
	<input type="text" name="name" maxlength="30" required placeholder="名前を入力してください。">

	<label>クラス</label>
	    <select name="class_num">
	    <option value="101">101</option>
	    <option value="102">102</option>
	    <option value="201">201</option>
	    <option value="202">202</option>
	    </select>
	<button type="submit"name="end">登録をして終了</button>
</form>

 <a href="../main/student_list.jsp">戻る</a>


</body>
</html>