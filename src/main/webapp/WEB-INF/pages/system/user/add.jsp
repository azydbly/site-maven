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
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>性别：</label>
            <div class="formControls col-xs-8 col-sm-9 skin-minimal">
                <div class="radio-box">
                    <input type="radio" id="sex-1" name="sex" value="男" checked />
                    <label for="sex-1">男</label>
                </div>
                <div class="radio-box">
                    <input type="radio" id="sex-2" name="sex" value="女" />
                    <label for="sex-2">女</label>
                </div>
            </div>
        </div>
        <div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>民族：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" name="nation" maxlength="10" />
			</div>
		</div>
        <div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>手机号：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" name="tel" maxlength="11" />
			</div>
		</div>
        <div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>省：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" name="province" maxlength="11" />
			</div>
		</div>
        <div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>市：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" name="city" maxlength="11" />
			</div>
		</div>
        <div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>区县：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" name="county" maxlength="11" />
			</div>
		</div>
        <div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>籍贯：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" name="birthplace" maxlength="200" />
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">角色：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" name="roleid" maxlength="11" />
			</div>
		</div>
        <div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">政治面貌：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" name="political" maxlength="11" />
			</div>
		</div>
        <div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">毕业最终院校：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" name="suniversity" maxlength="11" />
			</div>
		</div>
        <div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">毕业最终院校：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" name="suniversity" maxlength="11" />
			</div>
		</div>
        <div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">毕业最终学历：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" name="seducation" maxlength="11" />
			</div>
		</div>
        <div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">毕业最终专业：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" name="smajor" maxlength="11" />
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
		<div class="row cl hide">
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