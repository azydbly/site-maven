<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/layouts/base.jsp" %>
<html>
<head>
    <title>管理系统-登录</title>
    <link rel="stylesheet" type="text/css" href="${ctxstc}/style/css/login.css" />
    <script src="${ctxstc}/style/js/jquery.cookie.js"></script>
    <script src="${ctxstc}/style/js/util/md5.js"></script>
</head>
<body>
<div class="z-login-wrap">
    <div class="z-login-box">
        <div class="z-content z-clearfix">
            <div class="z-title">
                <h1>
                    <img src="${ctxstc}/style/images/login/log03.png">
                    <em>Management System</em>
                </h1>
                <p>©XST</p>
            </div>
            <div class="z-form">
                <input type="hidden" name="message" id="message" value="${message }" />
                <form id="loginForm">
                    <label class="form-item z-clearfix">
                        <input type="text" name="idnumber" id="idnumber" class="form-control" placeholder="请输入身份证号" value="" />
                        <i class="ace-icon fa fa-user"></i>
                    </label>
                    <label class="form-item z-clearfix">
                        <input type="password" name="password" id="password" class="form-control" placeholder="请输入密码" value="" />
                        <i class="ace-icon fa fa-user"></i>
                    </label>
                    <label class="form-item z-clearfix z-code-box" style="margin-bottom: 0px;" id="showVcode"></label>
                    <button type="button" class="z-login-btn" onclick="javascript:login();">登录</button>
                    <label class="inline z-inline">
                        <input type="checkbox" id="setcheck" name="remenber" class="z-switch" style="position: absolute;opacity: 0;" checked="checked">
                        <span class="z-switch" id="remenber"></span>
                        <span>记住登录</span>
                    </label>
                </form>
            </div>
        </div>
    </div>
    <div class="z-shadow"></div>
</div>

<div class="z-loading-wrap">
    <div class="spinner">
        <div class="double-bounce1"></div>
        <div class="double-bounce2"></div>
    </div>
    <div class="z-msg">拼命加速，正在登录中...</div>
</div>
<script src="${ctxstc}/style/js/pages/login.js"></script>
</body>
</html>
