<%@page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../header.jsp" %>

<h2>学生情報変更</h2>

<!-- 学生リスト表示 -->

<!-- 単一学生の編集フォーム -->


    <form action="StudentUpdateExecute.action" method="post">
        <!-- ★★ 重要！学生番号（変更キーになる）と学校CDはhiddenで渡す ★★ -->
        <input type="hidden" name="no" value="${student.no}">
        <input type="hidden" name="school_cd" value="${student.school.cd}">

        名前：<input type="text" name="name" value="${student.name}"><br>

        クラス：
        <select name="class_num">
            <c:forEach var="cls" items="${classList}">
                <option value="${cls.class_num}"
                    <c:if test="${cls.class_num == student.classNum.class_num}">selected</c:if>>
                    ${cls.class_num}
                </option>
            </c:forEach>
        </select><br>

        在籍：
        <input type="checkbox" name="is_attend"
            <c:if test="${student.attend}">checked</c:if>> <br>

        <input type="submit" value="変更">
    </form>

    <br>
    <a href="StudentList.action">戻る</a>
</body>
</html>