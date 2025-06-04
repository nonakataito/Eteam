<%@page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../header.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>科目管理画面</title>
</head>
<body>
<div class="main-container">
	<div class="menu-wrapper">
    <%@ include file="../side.jsp" %>
    </div>

    <!-- 1. 画面タイトル -->
    <h2>科目管理</h2>

    <!-- 2. 新規登録リンク -->
    <a href="subjectRegister.jsp" onclick="event41()">新規登録</a>

    <!-- 3. 科目一覧テーブル -->
    <table border="1">
        <thead>
            <tr>
                <!-- 4. ヘッダ(科目コード) -->
                <th>科目コード</th>
                <!-- 5. ヘッダ(科目名) -->
                <th>科目名</th>
                <th>操作</th>
            </tr>
        </thead>
        <tbody>
            <!-- 追加: subjectList をループして表示 -->
            <c:forEach var="subject" items="${subjectList}">
                <tr>
                    <!-- 6. 科目情報(科目コード) -->
                    <td><c:out value="${subject.cd}" /></td>
                    <!-- 7. 科目情報(科目名) -->
                    <td><c:out value="${subject.name}" /></td>
                    <td>
                        <!-- 8. 科目情報変更リンク -->
                        <a href="/Eteam/main/SubjectUpdate.action?code=${subject.cd}" onclick="event42()">変更</a>
                        <!-- 9. 科目情報削除リンク -->
                        <a href="subjectDelete.jsp?code=${subject.cd}" onclick="event43()">削除</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
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
