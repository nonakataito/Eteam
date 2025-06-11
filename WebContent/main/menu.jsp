<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<%-- タイトル + CSS --%>



<!-- メニューとコンテンツを横並びに配置するコンテナ -->
<div class="main-container">
	<!-- 左メニューエリア -->
	<div class="menu-wrapper">
		<%@ include file="../side.jsp"%>
	</div>

	<!-- 右コンテンツエリア -->
	<div class="content-container">
		<h2>メニュー</h2>
		<div class="menu-links">

			<!-- 学生管理 -->
			<div class="menu-block student">
				<div class="menu-title">学生管理</div>
				<div class="menu-items">
					<a href="StudentList.action">学生管理</a>
				</div>
			</div>

			<!-- 成績管理 -->
			<div class="menu-block grade">
				<div class="menu-title">成績管理</div>
				<div class="menu-items">
					<a href="<c:url value='/sample.jsp'/>">成績登録</a> <a
						href="<c:url value='/sample.jsp'/>">成績参照</a>
				</div>
			</div>

			<!-- 科目管理 -->
			<div class="menu-block subject">
				<div class="menu-title">科目管理</div>
				<div class="menu-items">
					<a href="SubjectList.action">科目管理</a>
				</div>
			</div>

		</div>


	</div>
</div>

<%@ include file="../footer.jsp"%>
