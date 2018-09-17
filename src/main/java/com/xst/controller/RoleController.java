package com.xst.controller;

import com.alibaba.fastjson.JSON;
import com.xst.common.annotation.ControllerLog;
import com.xst.common.util.DataTables;
import com.xst.server.RoleService;
import com.xst.server.impl.RoleServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName: RoleController
 * @类描述： RoleController  角色控制层
 * @Author: xiaoshitou
 * @Email: 15324399524@163.com
 * @CreateDate： 2018/9/14 17:42
 */

@Controller
@RequestMapping("/role/")
public class RoleController  extends BaseController{

    private RoleService roleService = new RoleServiceImpl();


    @RequestMapping("list")
    @ControllerLog("进入角色 list 页面")
    public String menuList(){
        return "system/role/index";
    }

    @ResponseBody
    @ControllerLog("角色 list 页面，分页显示角色")
    @RequestMapping("showPageRole")
    public String showPageRole(@RequestParam(value="state",required=false)String state,HttpServletRequest request, HttpServletResponse response){
        state = StringUtils.isEmpty(state) ? "" : ("state = " + state);
        return JSON.toJSONString(roleService.getPageRoleList(DataTables.getInstance(request,state)));
    }

}
