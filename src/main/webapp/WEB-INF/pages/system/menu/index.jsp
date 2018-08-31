<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/layouts/common.jsp" %>
<%@ include file="/WEB-INF/layouts/commonList.jsp" %>
<html>
<head>
    <title>系统管理</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont"></i> 首页 <span class="c-gray en">&gt;</span>系统管理 <span class="c-gray en">&gt;</span>菜单管理 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
    <div class="cl pd-5 bg-1 bk-gray mt-20">
		<span class="l">
            <a href="javascript:;" onclick="delAll(getDTSelect(), 'delMenu.action', reloadTable)" class="btn btn-danger radius">
                <i class="Hui-iconfont">&#xe6e2;</i> 批量删除
            </a>
            <a href="javascript:;" onclick="add('添加菜单','selPid.action','893','400')" class="btn btn-primary radius">
                <i class="Hui-iconfont">&#xe600;</i> 添加菜单
            </a>
		</span>
        <div class="r">
            状态:
            <select id="state" style="width:80px; height:30px;">
                <option value="">--请选择--</option>
                <option value="1">启用</option>
                <option value="2">禁用</option>
            </select>&nbsp;&nbsp;
            菜单名称:<input type="text" class="input-text" style="width:200px" placeholder="菜单名称" id="search">&nbsp;&nbsp;
            <button type="submit" id="doSearch" class="btn btn-success radius"><i class="Hui-iconfont">&#xe665;</i> 搜索</button>
        </div>
    </div>
    <div class="mt-20">
        <table class="table table-border table-bordered table-hover table-bg table-sort" width="100%" >
            <thead>
                <tr class="text-c">
                    <th>序号</th>
                    <th class="col-md-list-1">
                        <input id="input-0" type="checkbox" name="all"><label for="input-0"></label>
                    </th>
                    <th class="col-md-list-5">菜单名称</th>
                    <th class="col-md-list-5">上级菜单</th>
                    <th>网址</th>
                    <th class="col-md-list-3">插入时间</th>
                    <th class="col-md-list-3">更新时间</th>
                    <th class="col-md-list-2">状态</th>
                    <th class="col-md-list-2">操作</th>
                </tr>
            </thead>
        </table>
    </div>
</div>
<script src="${ctxstc}/styles/jquery.contextmenu/jquery.contextmenu.r2.js"></script>
<script src="${ctxstc}/style/js/pages/system/menu.js"></script>
</body>
</html>
