<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/layouts/base.jsp" %>
<link rel="stylesheet" type="text/css" href="${ctxstc}/styles/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="${ctxstc}/styles/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="${ctxstc}/styles/Hui-iconfont/1.0.8/iconfont.css" />
<script src="${ctxstc}/style/js/error/mal_request.js"></script>
<article class="page-404 minWP text-c">
    <p class="error-title"><i class="Hui-iconfont va-m">&#xe688;</i>
        <span class="va-m"> 拦截</span>
    </p>
    <input type="hidden" id="loginUser" value="${loginUser.idnumber }" />
    <p class="error-description"></p>
</article>