package com.xst.controller;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.xst.common.annotation.Authority;
import com.xst.common.annotation.ControllerLog;
import com.xst.common.pojo.AjaxResult;
import com.xst.common.pojo.ParamData;
import com.xst.common.util.DataTables;
import com.xst.common.util.StrUtil;
import com.xst.model.*;
import com.xst.server.MenuService;
import com.xst.server.RoleMenuService;
import com.xst.server.impl.MenuServiceImpl;
import com.xst.server.impl.RoleMenuServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: MenuController
 * @类描述: MenuController  菜单控制层
 * @Author: xiaoshitou
 * @Eamil: 15324399524@163.com
 * @CreateDate: 2018/8/24 21:02
 */

@Controller
@RequestMapping("/xst/menu/")
public class MenuController extends BaseController {

    @Autowired
    private MenuService menuService = new MenuServiceImpl();

    @Autowired
    private RoleMenuService roleMenuService = new RoleMenuServiceImpl();


    @ControllerLog("进入菜单 list 页面")
    @RequestMapping("list")
    @Authority(opCode = "1101", opName = "菜单管理")
    public String menuList(){
        return "system/menu/index";
    }

    @ResponseBody
    @ControllerLog("菜单 list 页面，分页显示菜单")
    @RequestMapping("showPageMenu")
    @Authority(opCode = "110101", opName = "查询菜单")
    public String showPageMenu(@RequestParam(value="state",required=false)String state,@RequestParam(value="menuname",required=false)String menuname, HttpServletRequest request, HttpServletResponse response){
        state = StringUtils.isEmpty(state) ? "" : (" and a.state = " + state);
        menuname = StringUtils.isEmpty(menuname) ? "" : (" and b.menuname = '" + menuname + "'");
        return JSON.toJSONString(menuService.getPageMenuList(DataTables.getInstance(request,state,menuname)));
    }

    @ResponseBody
    @ControllerLog("改变菜单状态")
    @RequestMapping("menuState")
    @Authority(opCode = "110105", opName = "修改菜单状态")
    public AjaxResult changeMenuState(HttpServletRequest request, HttpServletResponse response){
        return menuService.changeMenuState(request,response);
    }

    @ControllerLog("进入菜单 add 页面")
    @RequestMapping("add")
    @Authority(opCode = "110102", opName = "添加菜单页面")
    public String addMeun(HttpServletRequest request, HttpServletResponse response){
        request.setAttribute("menuList",menuService.selectOneMenu());
        return "system/menu/add";
    }

    @ResponseBody
    @ControllerLog("添加菜单")
    @RequestMapping("addUpdate")
    @Authority(opCode = "11010203", opName = "添加菜单")
    public AjaxResult addUpdate(Menu menu){
        return menuService.addUpdate(menu);
    }

    @RequestMapping("edit")
    @ControllerLog("进入菜单 edit 页面")
    @Authority(opCode = "110103", opName = "修改菜单页面")
    public String editMeun(HttpServletRequest request, HttpServletResponse response){
        request.setAttribute("menuList",menuService.selectOneMenu());
        request.setAttribute("menu",menuService.getMenuById(request,response));
        return "system/menu/edit";
    }

    @ResponseBody
    @RequestMapping("editUpdate")
    @ControllerLog("修改菜单")
    @Authority(opCode = "11010303", opName = "更新菜单")
    public AjaxResult editUpdate(Menu menu){
        return menuService.editUpdate(menu);
    }

    @ResponseBody
    @ControllerLog("删除菜单")
    @RequestMapping("/delete")
    @Authority(opCode = "110104", opName = "删除菜单")
    public AjaxResult deleteMenu(@RequestParam("idlist[]") List<Integer> idlist){
        return menuService.deleteMenu(idlist);
    }

    @ControllerLog("菜单名重复验证")
    @RequestMapping("menuname/validate")
    public void menuNameValidate(HttpServletRequest request, HttpServletResponse response) throws IOException {
        menuService.menuNameValidate(request,response);
    }

    @ResponseBody
    @ControllerLog("菜单跳转地址重复验证")
    @RequestMapping("url/validate")
    public void urlValidate(HttpServletRequest request, HttpServletResponse response) throws IOException {
        menuService.urlValidate(request,response);
    }

    @ResponseBody
    @ControllerLog("拼接菜单的ztree")
    @RequestMapping(value = "getZtreeMenu", produces = "application/json; charset=utf-8")
    public String getZtreeMenu() {
        ParamData params = new ParamData();
        String roleid = params.getString("id");
        List<Menu> list = menuService.selectLoginMenus();
        List<RoleMenu> listRoleMenu = roleMenuService.getMenuIdByRoleId(StrUtil.getInteger(roleid));
        List<ZtreeNode> ztreeNodeJson = new ArrayList<ZtreeNode>();
        for(int i = 0; i < list.size(); i++){
            ZtreeNode ztreeNode = new ZtreeNode();
            ztreeNode.setId(list.get(i).getOpcode());
            ztreeNode.setName(list.get(i).getMenuname());
            ztreeNode.setpId(list.get(i).getPid());
            if(StrUtil.getInteger(list.get(i).getOpcode()) < 9999){
                ztreeNode.setOpen(true);
            }
            for(int j = 0; j < listRoleMenu.size(); j++){
                if(listRoleMenu.get(j).getMenuid() == list.get(i).getOpcode()){
                    ztreeNode.setChecked(true);
                }
            }
            ztreeNodeJson.add(ztreeNode);
        }
        Gson gson = new Gson();
        String json = gson.toJson(ztreeNodeJson);
        return json;
    }
}
