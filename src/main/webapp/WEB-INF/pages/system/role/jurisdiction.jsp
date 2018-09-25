<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/layouts/ztree.jsp" %>
<html>
<head>
<title>角色配置权限</title>
</head>
<body>
<script src="${ctxstc}/style/js/pages/system/user/jurisdiction.js"></script>
<div class="content_wrap">
    <form class="form form-horizontal" id="form-member-add">
        <div class="zTreeDemoBackground left">
            <ul id="treeJurisdiction" class="ztree"></ul>
        </div>
        <div class="hide-ztree">
            <input type="submit" value="提交">
        </div>
    </form>
</div>
</body>
</html>