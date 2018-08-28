package com.xst.controller;

import com.xst.common.annotation.ControllerLog;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @ControllerLog("登录之后跳转主页")
    @RequestMapping("index")
    public void index(){

    }
}
