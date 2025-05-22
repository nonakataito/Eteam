<%@page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../header.jsp" %>

<h2>学生情報変更</h2>

<form action="StudentUpdate.action" method="post">
  <table>
    <tr>
      <td><label>入学年度</label></td>
      <td><input type="text" name="ent_year" value="${entYear}" readonly></td>
    </tr>

    <tr>
      <td><label>学生番号</label></td>
      <td><input type="text" name="no" value="${no}" readonly></td>
    </tr>

    <tr>
      <td><label>氏名</label></td>
      <br>
      <td><input type="text" name="name" value="${name}" maxlength="30" required></td>
    </tr>

    <tr>
      <td><label>クラス</label></td>
      <br>
      <td>
        <select name="class_num">
          <c:forEach var="cls" items="${classList}">
            <option value="${cls}" <c:if test="${cls == class_num}">selected</c:if>>${cls}</option>
          </c:forEach>
        </select>
      </td>
    </tr>

    <tr>
      <td><label>在学中</label></td>
      <td><input type="checkbox" name="is_attend" <c:if test="${is_attend}">checked</c:if>></td>
    </tr>

    <tr>
      <td colspan="2">
        <input type="submit" name="login" value="変更">
        <a href="StudentList.action">戻る</a>
      </td>
    </tr>
  </table>
</form>

<%@include file="../footer.jsp" %>
