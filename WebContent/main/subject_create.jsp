<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>科目情報登録</h2>
<form action="SubjectCreateExecute.action" method="post">
	<label>科目コード</label>

	<input type="text" name="cd" maxlength="3" required placeholder ="科目コードを入力してください。">

	<label>科目名</label>
	<input type="text" name="name" maxlength="20" required placeholder="科目名を入力してください。">



	<input type ="submit" value="登録">
</form>

 <a href="SubjectList.action">戻る</a>

</body>
</html>