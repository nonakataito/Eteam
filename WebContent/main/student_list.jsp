<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="/header.jsp" %>
<!-- メニューとコンテンツを横並びに配置するコンテナ -->
<div class="main-container">
    <!-- 左メニューエリア -->
    <div class="menu-wrapper">
        <%@ include file="../side.jsp" %>
    </div>
        <!-- 右コンテンツエリア -->
    <div class="content-container">
        <h2>学生管理</h2>

        <a href="<c:url value='/main/student_create.jsp'/>">新規登録</a>

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
		<input type="checkbox" name="f3" value="on" />

		<button type="submit">絞り込み</button>

<div>
    検索結果：${studentList.size()}件
</div>



    </div>
</div>