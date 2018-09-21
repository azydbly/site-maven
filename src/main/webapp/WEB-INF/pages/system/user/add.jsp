<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
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
                <input type="text" class="input-text" name="fullname" maxlength="30"/>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>身份证号：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" id="idnumber" name="idnumber" <%--onpaste = "return false"--%> maxlength="18"/>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>邮箱：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" name="email" maxlength="30"/>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>民族：</label>
            <div class="formControls col-xs-8 col-sm-9">
				<span class="select-box" style="width:41.5%;">
                    <select class="select" size="1" name="nation" style="color:black;">
                        <option value="">--请选择--</option>
                        <c:forEach items="${nationList }" var="nation">
                            <option value="${nation.id }">${nation.name}</option>
                        </c:forEach>
                    </select>
                </span>
                <span class="c-red" style="margin-left: 20px;">*</span>政治面貌：
                <span class="select-box" style="width:41.5%;">
                      <select class="select" size="1" name="political" style="color:black;">
                        <option value="">--请选择--</option>
                        <c:forEach items="${politicsList }" var="political">
                            <option value="${political.id }">${political.name}</option>
                        </c:forEach>
                    </select>
				</span>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>手机号：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" name="tel" maxlength="11"/>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>省市区：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <span class="select-box" style="width:32.8%;">
                    <select class="select" size="1" id="province" name="province" onchange="getProvince(this);" style="color:black;">
                        <option value="">--请选择--</option>
                        <c:forEach items="${provinceList }" var="province">
                            <option value="${province.number }" data-level="${province.level}">${province.name }</option>
                        </c:forEach>
                    </select>
                </span>
                <span class="select-box" style="width:32.8%;">
                    <select class="select" id="city" name="city" size="1" onchange="getCity(this);">
                        <option value="">--请选择--</option>
                    </select>
                </span>
                <span class="select-box" style="width:32.8%;">
                    <select class="select" id="county" name="county" size="1">
                       <option value="">--请选择--</option>
                    </select>
                </span>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3">籍贯：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" name="birthplace" maxlength="200"/>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3">毕业最终院校：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" name="suniversity" maxlength="11"/>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3">毕业最终学历：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" name="seducation" maxlength="11"/>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3">毕业最终专业：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" name="smajor" maxlength="11"/>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3">备注：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" name="remark" maxlength="50"/>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>角色：</label>
            <div class="formControls col-xs-8 col-sm-9">
				<span class="select-box" style="width: 43.8%;">
                    <select class="select" size="1" name="roleid" style="color:black;">
                        <option value="">--请选择--</option>
                        <c:forEach items="${roleList }" var="role">
                            <option value="${role.id }">${role.rolename}</option>
                        </c:forEach>
                    </select>
                </span>
                <span class="c-red" style="margin-left: 20px;">*</span>状态：
                <span class="select-box" style="width: 43.8%;">
                    <select class="select" size="1" name="roleid">
						<option value="1">启用</option>
						<option value="0">禁用</option>
					</select>
				</span>
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