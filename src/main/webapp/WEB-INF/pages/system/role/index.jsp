<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/layouts/common.jsp" %>
<%@ include file="/WEB-INF/layouts/commonList.jsp" %>
<html>
<head>
    <title>系统管理</title>
</head>
<body>
<nav class="breadcrumb">
    <i class="Hui-iconfont"></i> 首页 <span class="c-gray en">&gt;</span>系统管理 <span class="c-gray en">&gt;</span>角色管理
    <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" >
        <i class="Hui-iconfont">&#xe68f;</i>
    </a>
</nav>
<div class="page-container wrapper wrapper-content animated fadeInUp">
    <div class="cl pd-5 bg-1 bk-gray mt-20">
        <span class="l">
            <a href="javascript:;" onclick="delAll(getDTSelect(), '/menu/delete', reloadTable)" class="btn btn-danger radius">
                <i class="Hui-iconfont">&#xe6e2;</i> 批量删除
            </a>
            <a href="javascript:;" onclick="add('添加角色','/menu/add','893','380')" class="btn btn-primary radius">
                <i class="Hui-iconfont">&#xe600;</i> 添加角色
            </a>
        </span>
    </div>
    <div class="cl pd-5 bg-1 bk-gray mt-20" style="">
        <div class="r">
            状态:
            <select id="state" class="select_list">
                <option value="">--请选择--</option>
                <option value="0">禁用</option>
                <option value="1">启用</option>
            </select>
            <span>角色名称：</span>
            <input type="text" class="input-text input_span select_list" placeholder="角色名称" id="search">
            <button type="submit" id="doSearch" class="btn btn-success radius"><i class="Hui-iconfont">&#xe665;</i> 搜索</button>
        </div>
    </div>
    <div class="mt-20">
        <table class="table table-border table-bordered table-hover table-bg table-sort" id="table_id_example" width="100%" >
            <thead>
                <tr class="text-c">
                    <th>序号</th>
                    <th class="col-md-list-1">
                        <input id="input-0" type="checkbox" name="all"><label for="input-0"></label>
                    </th>
                    <th class="col-md-list-5">角色名称</th>
                    <th class="col-md-list-5">角色描述</th>
                    <th class="col-md-list-3">插入时间</th>
                    <th class="col-md-list-3">更新时间</th>
                    <th class="col-md-list-2">状态</th>
                    <th class="col-md-list-2">操作</th>
                </tr>
            </thead>
            <tfoot>
                <tr class="text-c">
                    <th>序号</th>
                    <th class="col-md-list-1">
                        <input id="input-0" type="checkbox" name="all"><label for="input-0"></label>
                    </th>
                    <th class="col-md-list-5">角色名称</th>
                    <th class="col-md-list-5">角色描述</th>
                    <th class="col-md-list-3">插入时间</th>
                    <th class="col-md-list-3">更新时间</th>
                    <th class="col-md-list-2">状态</th>
                    <th class="col-md-list-2">操作</th>
                </tr>
            </tfoot>
        </table>
    </div>
</div>
<script src="${ctxstc}/styles/h-ui.admin/js/H-ui.admin.js"></script>
<script src="${ctxstc}/style/js/pages/system/role/role.js"></script>
</body>
</html>
