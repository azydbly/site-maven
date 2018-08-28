package com.xst.controller;

import com.alibaba.fastjson.JSON;
import com.xst.common.annotation.ControllerLog;
import com.xst.common.util.DataTables;
import com.xst.server.MenuService;
import com.xst.server.impl.MenuServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName: MenuController
 * @类描述: MenuController  菜单控制层
 * @Author: xiaoshitou
 * @Eamil: 15324399524@163.com
 * @CreateDate: 2018/8/24 21:02
 */

@Controller
@RequestMapping("/menu/")
public class MenuController extends BaseController {

    @Autowired
    private MenuService menuService = new MenuServiceImpl();


    @RequestMapping("list")
    @ControllerLog("进入菜单 list 页面")
    public String index(){
        return "system/menu/index";
    }

    @ResponseBody
    @ControllerLog("菜单 list 页面，分页显示菜单")
    @RequestMapping(value = "showPageMenu", produces = "application/json; charset=utf-8")
    public String showPageMenu(@RequestParam(value="state",required=false)String state,HttpServletRequest request, HttpServletResponse response){
        state = StringUtils.isEmpty(state) ? "" : ("a.state=" + state);
        return JSON.toJSONString(menuService.getPageMenuList(DataTables.getInstance(request,state)));
    }
}
