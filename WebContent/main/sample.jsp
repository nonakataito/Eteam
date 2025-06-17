<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../header.jsp" %> <%-- タイトル + CSS --%>

<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <style>
        .main-container {
            display: flex;
        }
        .menu-wrapper {
            width: 200px; /* 必要に応じて調整 */
        }
        .content-container {
            flex: 1;
            text-align: center;
            padding: 40px;
        }
        .content-container img {
            width: 150px;
            margin-top: 20px;
        }
        h2 {
            margin-bottom: 20px;
        }
    </style>
</head>
<body>
<div class="main-container">
	<!-- 左メニューエリア -->
    <div class="menu-wrapper">
        <%@ include file="../side.jsp" %>
    </div>

        <!-- 右コンテンツエリア -->
        <div class="content-container">
            <h2>現在開発中です<br>出来るまでお待ちください</h2>
            <img src="<%= request.getContextPath() %>/images/kouzi.png" alt="開発中画像">
        </div>
    </div>

    <%@ include file="../footer.jsp" %>
</body>
</html>
