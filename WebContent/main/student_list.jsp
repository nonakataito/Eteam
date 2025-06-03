<%@page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@include file="/header.jsp" %>
<div class="main-container">
    <div class="menu-wrapper">
        <%@ include file="../side.jsp" %>
    </div>
    <div class="content-container">
        <h2>学生管理</h2>

        <a href="<c:url value='/main/student_create.jsp'/>">新規登録</a>

        <form method="get" action="<c:url value='/main/StudentList.action'/>">
            <label>入学年度</label>
            <select name="f1">
                <c:forEach var="year" begin="2015" end="2035">
                    <option value="${year}" ${param.f1 == year ? 'selected' : ''}>${year}</option>
                </c:forEach>
            </select>

            <label>クラス</label>
            <select name="f2">
                <option value="101">101</option>
                <option value="102">102</option>
                <option value="201">201</option>
                <option value="202">202</option>
            </select>

            <label>在学中</label>
            <input type="checkbox" name="f3" value="on" ${param.f3 == 'on' ? 'checked' : ''} />
            <button type="submit">絞り込み</button>
        </form>

        <div>
            検索結果：${fn:length(studentList)}件
        </div>

        <table border="1">
            <tr><th>番号</th><th>名前</th><th>入学年度</th><th>クラス</th><th>在学中</th></tr>
            <c:forEach var="s" items="${studentList}">
                <tr>
                    <td>${s.no}</td>
                    <td>${s.name}</td>
                    <td>${s.entYear}</td>
                    <td>${s.classNum.class_num}</td>
                    <td><c:choose>
                        <c:when test="${s.attend}">在学</c:when>
                        <c:otherwise>退学</c:otherwise>
                    </c:choose></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
