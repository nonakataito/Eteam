<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>学生管理</title>
</head>
<body>
<h2>得点管理システム</h2>

<div>
    <form action="StudentListAction" method="get">
        <label>入学年度</label>
        <select name="f1">
            <option value="">-----</option>
            <c:forEach var="year" items="${enrollmentYears}">
                <option value="${year}" ${param.f1 == year ? 'selected' : ''}>${year}</option>
            </c:forEach>
        </select>

        <label>クラス</label>
        <select name="f2">
            <option value="">-----</option>
            <c:forEach var="cls" items="${classes}">
                <option value="${cls}" ${param.f2 == cls ? 'selected' : ''}>${cls}</option>
            </c:forEach>
        </select>

        <label>在学中</label>
        <input type="checkbox" name="f3" value="on" ${param.f3 == 'on' ? 'checked' : ''} />

        <button type="submit">絞り込み</button>
        <a href="StudentRegisterAction">新規登録</a>
    </form>
</div>

<div>
    検索結果：${studentList.size()}件
</div>

<c:choose>
    <c:when test="${not empty studentList}">
        <table border="1">
            <thead>
                <tr>
                    <th>入学年度</th>
                    <th>学生番号</th>
                    <th>氏名</th>
                    <th>クラス</th>
                    <th>在学中</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="student" items="${studentList}">
                    <tr>
                        <td>${student.entYear}</td>
                        <td>${student.studentNo}</td>
                        <td>${student.studentName}</td>
                        <td>${student.classNo}</td>
                        <td><c:choose>
                                <c:when test="${student.attendFlag}">〇</c:when>
                                <c:otherwise>×</c:otherwise>
                            </c:choose></td>
                        <td><a href="StudentUpdateAction?studentNo=${student.studentNo}">変更</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:when>
    <c:otherwise>
        <div>学生情報はありません</div>
    </c:otherwise>
</c:choose>

</body>
</html>
