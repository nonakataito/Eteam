<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <title>得点管理システム</title>
    <link rel="stylesheet" type="text/css" href="<c:url value='/css/style.css'/>">
</head>
<body>

<!-- 上部タイトルエリア -->
<div class="header-wrapper">
    <h1>得点管理システム</h1>
    <div class="header">
        <c:if test="${not empty sessionScope.user}">
            <!-- ログインしている場合のみ表示 -->
            <div class="user-info">
                <span>${sessionScope.user.name} さん</span>
                <a href="<c:url value='/main/logout.jsp'/>">ログアウト</a>
            </div>
        </c:if>
    </div>
</div>

<!-- 必要に応じてこのファイルの最後に </body> や </html> を close するかは include 先で判断 -->
