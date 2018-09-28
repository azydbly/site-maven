<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/layouts/ztree.jsp" %>
<html>
<head>
<title>用户配置数据</title>
</head>
<body>
<script src="${ctxstc}/style/js/pages/system/user/configure.js"></script>
<div class="content_wrap">
    <input type="hidden" id="puserid" value="${puserid}" />
    <div class="zTreeDemoBackground left">
        <ul id="treeRegion" class="ztree"></ul>
    </div>
    <div class="hide-ztree">
        <input type="submit" onclick="zTreeOnClick()" value="提交">
    </div>
</div>
</body>
</html>