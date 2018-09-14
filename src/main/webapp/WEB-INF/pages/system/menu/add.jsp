<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/layouts/common.jsp" %>
<html>
<head>
<title>添加菜单</title>
</head>
<body>
<article class="page-container">
	<form class="form form-horizontal" id="form-member-add">
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>菜单名称：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" id="menuname" name="menuname">
			</div>
		</div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>上级菜单：</label>
            <div class="formControls col-xs-8 col-sm-9">
				<span class="select-box">
					<select class="select" size="1" id="pid" name="pid">
						<option value="0">顶级菜单</option>
						<c:forEach items="${menuList }" var="menu">
                            <option value="${menu.getId() }">${menu.getMenuname() }</option>
                        </c:forEach>
					</select>
				</span>
            </div>
        </div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">地址：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" id="url" name="url">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">状态：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<span class="select-box">
					<select class="select" size="1" name="state" />
						<option value="1">启用</option>
						<option value="0">禁用</option>
					</select>
				</span>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">备注：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" name="remark" />
			</div>
		</div>
		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
				<input class="btn btn-primary radius" type="submit" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
				<button onClick="layer_close();" class="btn btn-default radius" type="button">&nbsp;&nbsp;取消&nbsp;&nbsp;</button>
			</div>
		</div>
	</form>
</article>
<script src="${ctxstc}/styles/h-ui.admin/js/H-ui.admin.js"></script>
<script src="${ctxstc}/style/js/pages/system/menu/menuAdd.js"></script>
</body>
</html>