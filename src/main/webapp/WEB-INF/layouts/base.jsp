<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%-- 项目绝对路径 --%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<%--静态资源路径 --%>
<c:set var="ctxstc" value="${pageContext.request.contextPath}/static"/>
<script>baselocation='${ctx}';</script>

<script src="${ctxstc}/styles/jquery/1.9.1/jquery.js"></script>

<script src="${ctxstc}/styles/layer/layer.js"></script>