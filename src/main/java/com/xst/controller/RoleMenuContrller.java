package com.xst.controller;

import com.google.gson.Gson;
import com.xst.common.annotation.ControllerLog;
import com.xst.common.pojo.AjaxResult;
import com.xst.common.pojo.ParamData;
import com.xst.common.util.StrUtil;
import com.xst.model.Menu;
import com.xst.model.RoleMenu;
import com.xst.model.ZtreeNode;
import com.xst.server.MenuService;
import com.xst.server.RoleMenuService;
import com.xst.server.impl.MenuServiceImpl;
import com.xst.server.impl.RoleMenuServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: RoleMenuContrller
 * @类描述: RoleMenuContrller  角色绑定菜单功能控制
 * @Author: xiaoshitou
 * @Eamil: 15324399524@163.com
 * @CreateDate: 2018/10/17 14:06
 */

@Controller
@RequestMapping("/xst/roleMenu/")
public class RoleMenuContrller extends BaseController {

    @Autowired
    private MenuService menuService = new MenuServiceImpl();

    @Autowired
    private RoleMenuService roleMenuService = new RoleMenuServiceImpl();


    @ResponseBody
    @ControllerLog("拼接菜单的ztree")
    @RequestMapping(value = "getZtreeMenu", produces = "application/json; charset=utf-8")
    public String getZtreeMenu() {
        ParamData params = new ParamData();
        String roleid = params.getString("roleid");
        List<Menu> list = menuService.selectLoginMenus();
        List<RoleMenu> listRoleMenu = roleMenuService.getMenuIdByRoleId(StrUtil.getInteger(roleid));
        List<ZtreeNode> ztreeNodeJson = new ArrayList<ZtreeNode>();
        for(int i = 0; i < list.size(); i++){
            ZtreeNode ztreeNode = new ZtreeNode();
            ztreeNode.setId(list.get(i).getOpcode());
            ztreeNode.setName(list.get(i).getMenuname());
            ztreeNode.setpId(list.get(i).getPid());
            if(StrUtil.getInteger(list.get(i).getOpcode()) < 10){
                ztreeNode.setOpen(true);
            }
            for(int j = 0; j < listRoleMenu.size(); j++){
                if(listRoleMenu.get(j).getMenucope() == list.get(i).getOpcode()){
                    ztreeNode.setChecked(true);
                }
            }
            ztreeNodeJson.add(ztreeNode);
        }
        Gson gson = new Gson();
        String json = gson.toJson(ztreeNodeJson);
        return json;
    }



    @ResponseBody
    @ControllerLog("保存角色授权菜单功能")
    @RequestMapping("saveRoleZtree")
    public AjaxResult saveRoleZtree(HttpServletRequest request, HttpServletResponse response) {
        return roleMenuService.saveAreasZtree(request,response);
    }

}
