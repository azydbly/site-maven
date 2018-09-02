<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/layouts/common.jsp" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <title>权限管理系统</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0">
</head>
<body>
<header class="navbar-wrapper">
    <div class="navbar navbar-fixed-top">
        <div class="container-fluid cl">
            <a class="logo navbar-logo f-l mr-10 hidden-xs">综合管理平台</a>
            <span class="logo navbar-slogan f-l mr-10 hidden-xs">3.0</span>
            <a aria-hidden="false" class="nav-toggle Hui-iconfont visible-xs" href="javascript:;">&#xe667;</a>
            <nav class="nav navbar-nav">
                <ul class="cl">
                    <li class="dropDown dropDown_hover">
                        <a href="javascript:;" class="dropDown_A">工具 <i class="Hui-iconfont">&#xe6d5;</i></a>
                        <ul class="dropDown-menu menu radius box-shadow">
                            <li>
                                <a href="http://www.h-ui.net/bug.shtml" target="_blank"><i class="Hui-iconfont">&#xe64a;</i> Bug兼容性汇总</a>
                            </li>
                            <li>
                                <a href="http://www.h-ui.net/websafecolors.shtml" target="_blank"><i class="Hui-iconfont">&#xe62a;</i> web安全色</a>
                            </li>
                            <li>
                                <a href="javascript:;"><i class="Hui-iconfont">&#xe681;</i> web工具箱<i class="arrow Hui-iconfont">&#xe6d7;</i></a>
                                <ul class="menu">
                                    <li>
                                        <a href="http://www.h-ui.net/tools/jsformat.shtml" target="_blank">JS/HTML格式化工具</a>
                                    </li>
                                    <li>
                                        <a href="http://www.h-ui.net/tools/HTMLtoJS.shtml" target="_blank">HTML/JS转换工具</a>
                                    </li>
                                    <li>
                                        <a href="http://www.h-ui.net/tools/cssformat.shtml" target="_blank">CSS代码格式化工具</a>
                                    </li>
                                    <li>
                                        <a href="http://www.h-ui.net/tools/daxiaoxie.shtml" target="_blank">字母大小写转换工具</a>
                                    </li>
                                    <li>
                                        <a href="http://www.h-ui.net/tools/fantizhuanhuan.shtml" target="_blank">繁体字、火星文转换</a>
                                    </li>
                                    <li>
                                        <a href="javascript:;">三级菜单<i class="arrow Hui-iconfont">&#xe6d7;</i></a>
                                        <ul class="menu">
                                            <li>
                                                <a href="javascript:;">四级菜单</a>
                                            </li>
                                        </ul>
                                    </li>
                                </ul>
                            </li>
                        </ul>
                    </li>
                </ul>
            </nav>
            <nav id="Hui-userbar" class="nav navbar-nav navbar-userbar hidden-xs">
                <ul class="cl">
                    <li>超级管理员&nbsp;&nbsp;</li>
                    <li class="dropDown dropDown_hover">
                        <img width="40px;" height="40px;" class="round" src="${ctxstc}/style/images/index/welcome.gif">
                        <a href="#" class="dropDown_A">admin <i class="Hui-iconfont">&#xe6d5;</i></a>
                        <ul class="dropDown-menu menu radius box-shadow">
                            <li>

                                <a href="javascript:;" onClick="myselfinfo()"><i class="Hui-iconfont">&#xe705;</i> 个人信息</a>
                            </li>
                            <li>
                                <a href="javascript:druid()" target="_blank"><i class="Hui-iconfont">&#xe62e;</i> Druid监控</a>
                            </li>
                            <li>
                                <a href="javascript:logout()"><i class="Hui-iconfont">&#xe726;</i> 退出</a>
                            </li>
                        </ul>
                    </li>
                    <li id="Hui-msg">
                        <a href="#" title="消息">
                            <span class="badge badge-danger">10</span><i class="Hui-iconfont" style="font-size:18px">&#xe68a;</i>
                        </a>
                    </li>
                    <li id="Hui-skin" class="dropDown right dropDown_hover">
                        <a href="javascript:;" class="dropDown_A" title="换肤">
                            <i class="Hui-iconfont" style="font-size:18px">&#xe62a;</i>
                        </a>
                        <ul class="dropDown-menu menu radius box-shadow">
                            <li><a href="javascript:;" data-val="default" title="默认（绿色）">默认（绿色）</a></li>
                            <li><a href="javascript:;" data-val="blue" title="蓝色">蓝色</a></li>
                            <li><a href="javascript:;" data-val="red" title="红色">红色</a></li>
                            <li><a href="javascript:;" data-val="yellow" title="黄色">黄色</a></li>
                            <li><a href="javascript:;" data-val="orange" title="橙色">橙色</a></li>
                            <li><a href="javascript:;" data-val="black" title="黑色">黑色</a></li>
                        </ul>
                    </li>
                </ul>
            </nav>
        </div>
    </div>
</header>
<aside class="Hui-aside">
    <div class="menu_dropdown bk_2">
        <dl id="menu-article">
            <c:if test="${not empty menuList}">
                <c:forEach items="${menuList }" var="menu">
                    <c:if test="${menu.pid == 0 }">
                        <dt>
                            <i class="Hui-iconfont">${menu.iconfont }</i> ${menu.menuname }<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
                        </dt>
                        <dd>
                            <ul>
                                <li>
                                    <c:forEach items="${menuList }" var="submenu">
                                        <c:if test="${submenu.pid == menu.id }">
                                            <a data-href="${ctx }${submenu.url }" data-title="${submenu.menuname }" href="javascript:void(0)">${submenu.menuname }</a>
                                        </c:if>
                                    </c:forEach>
                                </li>
                            </ul>
                        </dd>
                    </c:if>
                </c:forEach>
            </c:if>
        </dl>
    </div>
</aside>
<div class="dislpayArrow hidden-xs">
    <a class="pngfix" href="javascript:void(0);" onClick="displaynavbar(this)"></a>
</div>
<section class="Hui-article-box">
    <div id="Hui-tabNav" class="Hui-tabNav hidden-xs">
        <div class="Hui-tabNav-wp">
            <ul id="min_title_list" class="acrossTab cl">
                <li class="active">
                    <span title="我的桌面" data-href="">我的桌面</span>
                    <em></em>
                </li>
            </ul>
        </div>
        <div class="Hui-tabNav-more btn-group"><a id="js-tabNav-prev" class="btn radius btn-default size-S" href="javascript:;"><i class="Hui-iconfont">&#xe6d4;</i></a><a id="js-tabNav-next" class="btn radius btn-default size-S" href="javascript:;"><i class="Hui-iconfont">&#xe6d7;</i></a></div>
    </div>
    <div id="iframe_box" class="Hui-article">
        <div class="show_iframe">
            <div style="display:none" class="loading"></div>
            <%@include file="main.jsp" %>
          <%--  <iframe scrolling="yes" frameborder="0" src="${ctx}/main.jsp"></iframe>--%>
        </div>
    </div>
</section>
<div class="contextMenu" id="Huiadminmenu">
    <ul>
        <li id="closethis">关闭当前 </li>
        <li id="closeother">关闭其他 </li>
        <li id="closeall">关闭全部 </li>
    </ul>
</div>
<script src="${ctxstc}/styles/h-ui.admin/js/H-ui.admin.js"></script>
<script src="${ctxstc}/style/js/pages/index.js"></script>
</body>
</html>
