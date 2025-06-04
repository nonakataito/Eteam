<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../header.jsp" %> <%-- タイトル + CSS --%>

<!-- メニューとコンテンツを横並びに配置するコンテナ -->
<div class="main-container">
    <!-- 左メニューエリア -->
    <div class="menu-wrapper">
        <%@ include file="../side.jsp" %>
    </div>

    <!-- 右コンテンツエリア -->
    <div class="content-container">
        <h2>メニュー</h2>
        <div class="menu-links">
            <!-- 横並び -->
            <a href="StudentList.action">学生管理</a>
            <a href="<c:url value='/sample.jsp'/>">成績管理</a>
            <a href="SubjectList.action">科目管理</a>

            <!-- 改行してインデント -->
            <br>&emsp;&emsp;&emsp;
            　<a href="<c:url value='/sample.jsp'/>">成績登録</a>
            <br>&emsp;&emsp;&emsp;
            　<a href="<c:url value='/sample.jsp'/>">成績参照</a>
        </div>
    </div>
</div>

<%@ include file="../footer.jsp" %>
