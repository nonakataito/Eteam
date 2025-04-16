<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="/header.jsp" %>
<%@include file="/menu.jsp" %>

<form action="Login.action" method="post">
<p>ログイン名　<input type="text" name="login"></p>
<p>パスワード　<input type="password" name="password"></p>
<p><input type="submit" value="ログイン"></p>
</form>

<%@include file="/footer.jsp" %>

 <a href="<c:url value='../mainmenu.jsp'/>">メニュー画面へ</a>
