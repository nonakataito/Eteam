<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../header.jsp" %>

<h2>科目削除確認</h2>

<p>以下の科目情報を削除してもよろしいですか？</p>
<p>科目名：${subject.name}（${subject.cd}）</p>

<form action="SubjectDeleteExecute.action" method="post">
  <input type="hidden" name="subject_cd" value="${subject.cd}">
  <input type="hidden" name="subject_name" value="${subject.name}">
  <input type="submit" value="削除">
</form>

<a href="SubjectList.action">戻る</a>

<%@ include file="../footer.jsp" %>
