<!-- 本ファイルはトップページのJSPです -->

<!-- TODO: 現在は仮の実装です。必要に応じて修正または書き換えてください。 -->

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ include file="header.jsp" %>  <%-- タイトル + CSS --%>

<!-- メニューとコンテンツを横並びに配置するコンテナ -->
<div class="main-container">
    <!-- 左メニューエリア -->
    <div class="menu-wrapper">
        <%@ include file="menu.jsp" %>
    </div>

    <!-- 右コンテンツエリア -->
    <div class="content-container">
        <h1>Topページ</h1>
        <p>学生とコースの管理をするシステムです。</p>
        <p>左のメニューから、各機能を選択してくさい</p>
    </div>
</div>

<%@ include file="footer.jsp" %>
