<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="/header.jsp" %>

<form action="Account.LoginExecute.action" method="post">
<p>ID　<input type="text" name="id"></p>
<p>パスワード　<input type="password" name="password"></p>
<p><input type="submit" value="ログイン"></p>
</form>

<%@include file="../footer.jsp" %>

 <a href="<c:url value='/main/menu.jsp'/>">メニュー画面へ</a>


