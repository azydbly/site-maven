package com.xst.controller;

import com.alibaba.fastjson.JSON;
import com.xst.common.annotation.Authority;
import com.xst.common.annotation.ControllerLog;
import com.xst.common.pojo.AjaxResult;
import com.xst.common.pojo.ParamData;
import com.xst.common.util.DataTables;
import com.xst.model.Menu;
import com.xst.model.Roles;
import com.xst.server.RoleService;
import com.xst.server.impl.RoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static java.awt.SystemColor.menu;

/**
 * @ClassName: RoleController
 * @类描述： RoleController  角色控制层
 * @Author: xiaoshitou
 * @Email: 15324399524@163.com
 * @CreateDate： 2018/9/14 17:42
 */

@Controller
@RequestMapping("/xst/roles/")
public class RoleController  extends BaseController{

    @Autowired
    private RoleService roleService = new RoleServiceImpl();


    @ControllerLog("进入角色 list 页面")
    @RequestMapping("list")
    @Authority(opCode = "1102", opName = "角色管理")
    public String roleList(){
        return "system/role/index";
    }

    @ResponseBody
    @ControllerLog("角色 list 页面，分页显示角色")
    @RequestMapping("showPageRole")
    @Authority(opCode = "110201", opName = "查询角色")
    public String showPageRole(@RequestParam(value="state",required=false)String state,HttpServletRequest request, HttpServletResponse response){
        state = StringUtils.isEmpty(state) ? "" : (" and state = " + state);
        return JSON.toJSONString(roleService.getPageRoleList(DataTables.getInstance(request,state)));
    }

    @ControllerLog("进入添加角色页面")
    @RequestMapping("add")
    @Authority(opCode = "110204", opName = "添加角色页面")
    public String add(){
        return "system/role/add";
    }

    @ControllerLog("角色名重复验证")
    @RequestMapping("rolename/validate")
    @Authority(opCode = "11020401", opName = "添加角色名称重复验证")
    public void roleNameValidate(HttpServletRequest request, HttpServletResponse response) throws IOException {
        roleService.roleNameValidate(request,response);
    }

    @ResponseBody
    @ControllerLog("添加角色")
    @RequestMapping("addUpdate")
    @Authority(opCode = "11020402", opName = "添加角色")
    public AjaxResult addUpdate(Roles role){
        return roleService.addUpdate(role);
    }

    @ControllerLog("进入修改角色页面")
    @RequestMapping("edit")
    @Authority(opCode = "110205", opName = "修改角色页面")
    public String edit(HttpServletRequest request, HttpServletResponse response){
        request.setAttribute("role",roleService.getRolesById(request,response));
        return "system/role/edit";
    }

    @ResponseBody
    @ControllerLog("修改角色")
    @RequestMapping("editUpdate")
    @Authority(opCode = "11020502", opName = "更新角色")
    public AjaxResult editUpdate(Roles role){
        return roleService.editUpdate(role);
    }

    @ResponseBody
    @ControllerLog("改变角色状态")
    @RequestMapping("roleState")
    @Authority(opCode = "110203", opName = "修改角色状态")
    public AjaxResult changeRoleState(HttpServletRequest request, HttpServletResponse response){
        return roleService.changeRoleState(request,response);
    }

    @ResponseBody
    @ControllerLog("删除角色")
    @RequestMapping("/delete")
    @Authority(opCode = "110202", opName = "删除")
    public AjaxResult deleteRoles(@RequestParam("idlist[]") List<Integer> idlist){
        return roleService.deleteRole(idlist);
    }

    @ControllerLog("配置角色权限页面")
    @RequestMapping("jurisdiction")
    @Authority(opCode = "110206", opName = "配置角色权限页面")
    public String Jurisdiction(HttpServletRequest request, HttpServletResponse response){
        ParamData params = new ParamData();
        String roleid = params.getString("id");
        request.setAttribute("roleid",roleid);
        return "system/role/jurisdiction";
    }

}
