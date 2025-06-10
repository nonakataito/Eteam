<%@page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../header.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>科目管理画面</title>
    <link rel="stylesheet" href="css/subject.css">
</head>
<body>
<div class="main-container">
    <div class="menu-wrapper">
        <%@ include file="../side.jsp" %>
    </div>

    <div class="subject-table-wrapper">
        <h2>科目管理</h2>

        <div class="new-register">
            <a href="subjectRegister.jsp" onclick="event41()">新規登録</a>
        </div>

        <table>
            <thead>
                <tr>
                    <th>科目コード</th>
                    <th>科目名</th>
                    <th>操作</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="subject" items="${subjectList}">
                    <tr>
                        <td><c:out value="${subject.cd}" /></td>
                        <td><c:out value="${subject.name}" /></td>
                        <td>
                            <a class="action-link" href="/Eteam/main/SubjectUpdate.action?code=${subject.cd}" onclick="event42()">変更</a>
                            <a class="action-link" href="subjectDelete.jsp?code=${subject.cd}" onclick="event43()">削除</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div>

<script>
    function event41() {
        console.log("イベント41: 新規登録リンク押下");
    }
    function event42() {
        console.log("イベント42: 科目変更リンク押下");
    }
    function event43() {
        console.log("イベント43: 科目削除リンク押下");
    }
</script>

<%@ include file="../footer.jsp" %>
</body>
</html>
