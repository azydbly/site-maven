<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/layouts/common.jsp" %>
<html>
<head>
<title>添加用户</title>
</head>
<body>
<article class="page-container">
	<form class="form form-horizontal" id="form-member-add">
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>用户姓名：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" name="fullname" maxlength="30" />
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>身份证号：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" id="idnumber" name="idnumber" maxlength="18" />
			</div>
		</div>
        <div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>邮箱：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" id="email" name="email" maxlength="30" />
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">地址：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" id="url" name="url" maxlength="50" />
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>状态：</label>
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
				<input type="text" class="input-text" name="remark" maxlength="50" />
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
<script src="${ctxstc}/style/js/pages/system/user/add.js"></script>
</body>
</html>