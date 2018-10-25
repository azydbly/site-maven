<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/layouts/ztree.jsp" %>
<html>
<head>
<title>角色配置权限</title>
</head>
<body>
<script src="${ctxstc}/style/js/pages/system/role/jurisdiction.js"></script>
<div class="content_wrap">
    <input type="hidden" id="roleid" value="${roleid}" />
    <div>
        <ul id="treeJurisdiction" class="ztree"></ul>
    </div>
    <div class="hide-ztree">
        <input type="submit" onclick="zTreeOnClick()" value="提交">
    </div>
</div>
</body>
</html>