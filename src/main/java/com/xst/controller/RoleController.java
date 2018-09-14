package com.xst.controller;

import com.xst.common.annotation.ControllerLog;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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


    @RequestMapping("list")
    @ControllerLog("进入角色 list 页面")
    public String menuList(){
        return "system/role/index";
    }
}
