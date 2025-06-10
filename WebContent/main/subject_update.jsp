<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>科目変更画面</title>
<style>
/* 簡単なスタイル調整 */
label {
	display: inline-block;
	width: 80px;
	margin-top: 10px;
}

input[type="text"] {
	width: 200px;
	padding: 5px;
}

.button-area {
	margin-top: 20px;
}
</style>
</head>
<body>
	<h2>科目変更</h2>

	<!-- 変更用フォーム -->
	<form action="/Eteam/main/SubjectUpdateExecute.action" method="post">
		<!-- 科目コード -->
		<label for="cd">科目コード</label>
		<input type="hidden" name="cd"
			value="${subject.cd}" /> <br />

		<!-- 科目名 -->
		<label for="name">科目名<span style="color: red;">*</span></label> <input
			type="text" id="name" name="name" value="${subject.name}"
			maxlength="20" required /> <br />

		<div class="button-area">
			<input type="submit" value="変更" /> <a href="SubjectList.Action">戻る</a>
		</div>
	</form>
</body>
</html>
