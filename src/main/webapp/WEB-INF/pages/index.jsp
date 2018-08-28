<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/layouts/base.jsp" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <title>权限管理系统</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0">

    <link rel="stylesheet" type="text/css" href="${ctxstc}/styles/h-ui/css/H-ui.min.css" />
    <link rel="stylesheet" type="text/css" href="${ctxstc}/styles/h-ui.admin/css/H-ui.admin.css" />
    <link rel="stylesheet" type="text/css" href="${ctxstc}/styles/Hui-iconfont/1.0.8/iconfont.css" />
    <link rel="stylesheet" type="text/css" href="${ctxstc}/styles/h-ui.admin/skin/default/skin.css" id="skin" />
    <script src="${ctxstc}/style/js/jquery-1.12.4.min.js"></script>
    <script src="${ctxstc}/styles/h-ui/js/H-ui.js"></script>
    <script src="${ctxstc}/styles/h-ui.admin/js/H-ui.admin.js"></script>
    <script src="${ctxstc}/styles/layer/layer.js"></script>
    <script src="${ctxstc}/style/js/pages/index.js"></script>
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
                                <a href="http://www.h-ui.net/bug.shtml" target="_blank">Bug兼容性汇总</a>
                            </li>
                            <li>
                                <a href="http://www.h-ui.net/websafecolors.shtml" target="_blank">web安全色</a>
                            </li>
                            <li>
                                <a href="http://www.h-ui.net/Hui-3.7-Hui-iconfont.shtml" target="_blank">Hui-iconfont</a>
                            </li>
                            <li>
                                <a href="javascript:;">web工具箱<i class="arrow Hui-iconfont">&#xe6d7;</i></a>
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
                                            <li>
                                                <a href="javascript:;">四级菜单</a>
                                            </li>
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
            <dt><i class="Hui-iconfont">&#xe616;</i> 资讯管理${loginUsrt.idnnumber }<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
            <dd>
                <ul>
                    <li><a data-href="article-list.html" data-title="资讯管理" href="javascript:void(0)">资讯管理</a></li>
                </ul>
            </dd>
        </dl>
        <dl id="menu-picture">
            <dt><i class="Hui-iconfont">&#xe613;</i> 图片管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
            <dd>
                <ul>
                    <li><a data-href="picture-list.html" data-title="图片管理" href="javascript:void(0)">图片管理</a></li>
                </ul>
            </dd>
        </dl>
        <dl id="menu-product">
            <dt><i class="Hui-iconfont">&#xe620;</i> 产品管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
            <dd>
                <ul>
                    <li><a data-href="product-brand.html" data-title="品牌管理" href="javascript:void(0)">品牌管理</a></li>
                    <li><a data-href="product-category.html" data-title="分类管理" href="javascript:void(0)">分类管理</a></li>
                    <li><a data-href="product-list.html" data-title="产品管理" href="javascript:void(0)">产品管理</a></li>
                </ul>
            </dd>
        </dl>
        <dl id="menu-comments">
            <dt><i class="Hui-iconfont">&#xe622;</i> 评论管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
            <dd>
                <ul>
                    <li><a data-href="http://h-ui.duoshuo.com/admin/" data-title="评论列表" href="javascript:;">评论列表</a></li>
                    <li><a data-href="feedback-list.html" data-title="意见反馈" href="javascript:void(0)">意见反馈</a></li>
                </ul>
            </dd>
        </dl>
        <dl id="menu-member">
            <dt><i class="Hui-iconfont">&#xe60d;</i> 会员管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
            <dd>
                <ul>
                    <li><a data-href="member-list.html" data-title="会员列表" href="javascript:;">会员列表</a></li>
                    <li><a data-href="member-del.html" data-title="删除的会员" href="javascript:;">删除的会员</a></li>
                    <li><a data-href="member-level.html" data-title="等级管理" href="javascript:;">等级管理</a></li>
                    <li><a data-href="member-scoreoperation.html" data-title="积分管理" href="javascript:;">积分管理</a></li>
                    <li><a data-href="member-record-browse.html" data-title="浏览记录" href="javascript:void(0)">浏览记录</a></li>
                    <li><a data-href="member-record-download.html" data-title="下载记录" href="javascript:void(0)">下载记录</a></li>
                    <li><a data-href="member-record-share.html" data-title="分享记录" href="javascript:void(0)">分享记录</a></li>
                </ul>
            </dd>
        </dl>
        <dl id="menu-admin">
            <dt><i class="Hui-iconfont">&#xe62d;</i> 管理员管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
            <dd>
                <ul>
                    <li><a data-href="admin-role.html" data-title="角色管理" href="javascript:void(0)">角色管理</a></li>
                    <li><a data-href="admin-permission.html" data-title="权限管理" href="javascript:void(0)">权限管理</a></li>
                    <li><a data-href="admin-list.html" data-title="管理员列表" href="javascript:void(0)">管理员列表</a></li>
                </ul>
            </dd>
        </dl>
        <dl id="menu-tongji">
            <dt><i class="Hui-iconfont">&#xe61a;</i> 系统统计<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
            <dd>
                <ul>
                    <li><a data-href="charts-1.html" data-title="折线图" href="javascript:void(0)">折线图</a></li>
                    <li><a data-href="charts-2.html" data-title="时间轴折线图" href="javascript:void(0)">时间轴折线图</a></li>
                    <li><a data-href="charts-3.html" data-title="区域图" href="javascript:void(0)">区域图</a></li>
                    <li><a data-href="charts-4.html" data-title="柱状图" href="javascript:void(0)">柱状图</a></li>
                    <li><a data-href="charts-5.html" data-title="饼状图" href="javascript:void(0)">饼状图</a></li>
                    <li><a data-href="charts-6.html" data-title="3D柱状图" href="javascript:void(0)">3D柱状图</a></li>
                    <li><a data-href="charts-7.html" data-title="3D饼状图" href="javascript:void(0)">3D饼状图</a></li>
                </ul>
            </dd>
        </dl>
        <dl id="menu-system">
            <dt><i class="Hui-iconfont">&#xe62e;</i> 系统管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
            <dd>
                <ul>
                    <li><a data-href="system-base.html" data-title="系统设置" href="javascript:void(0)">系统设置</a></li>
                    <li><a data-href="system-category.html" data-title="栏目管理" href="javascript:void(0)">栏目管理</a></li>
                    <li><a data-href="system-data.html" data-title="数据字典" href="javascript:void(0)">数据字典</a></li>
                    <li><a data-href="system-shielding.html" data-title="屏蔽词" href="javascript:void(0)">屏蔽词</a></li>
                    <li><a data-href="system-log.html" data-title="系统日志" href="javascript:void(0)">系统日志</a></li>
                </ul>
            </dd>
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
</body>
</html>
