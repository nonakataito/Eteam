<%@page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/header.jsp" %>

<link rel="stylesheet" type="text/css" href="<c:url value='/css/style.css'/>">

<div class="login-container">
    <div class="login-box">
        <h2>ログイン</h2>
        <form action="main/LoginExecute.action" method="post">
            <div class="form-group">
                <label for="id">ID</label>
                <input type="text" name="id" id="id" required>
            </div>
            <div class="form-group">
                <label for="password">パスワード</label>
                <input type="password" name="password" id="password" required>
            </div>
            <div class="form-submit">
                <input type="submit" value="ログイン">
            </div>
        </form>
    </div>
</div>

<%@include file="../footer.jsp" %>
