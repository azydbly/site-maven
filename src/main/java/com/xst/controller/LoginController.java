package com.xst.controller;

import com.xst.common.annotation.Authority;
import com.xst.common.annotation.ControllerLog;
import com.xst.common.pojo.AjaxResult;
import com.xst.common.pojo.Identity;
import com.xst.common.pojo.ParamData;
import com.xst.common.util.AppUtil;
import com.xst.common.util.DataCache;
import com.xst.common.util.IPUtil;
import com.xst.common.util.PasswordUtil;
import com.xst.mapper.UserMapper;
import com.xst.model.User;
import com.xst.server.MenuService;
import com.xst.server.UserService;
import com.xst.server.impl.MenuServiceImpl;
import com.xst.server.impl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.chrono.IsoEra;
import java.util.List;

/**
 * @ClassName: LoginController
 * @类描述： LoginController  登录
 * @Author: xiaoshitou
 * @Email: 15324399524@163.com
 * @CreateDate： 2018/8/22 16:48
 */

@Controller
@RequestMapping("/xst/admin/")
public class LoginController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private UserService userService = new UserServiceImpl();

    @Autowired
    private MenuService menuService = new MenuServiceImpl();

    @Autowired
    private UserMapper userMapper;



    @ResponseBody
    @ControllerLog("登录系统")
    @RequestMapping("login")
    public AjaxResult login(HttpServletRequest request, HttpServletResponse response) {
        return userService.selectUserByIdnumber(request,response);
    }

    @ControllerLog("登录成功欢迎页")
    @RequestMapping("welcome")
    @Authority(opCode = "1", opName = "系统主界面")
    public String welcome(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("menuList", menuService.selectLoginMenus());
        return "index";
    }

    @ResponseBody
    @ControllerLog("强刷页面进行账号锁定")
    @RequestMapping("lock")
    public AjaxResult lock(HttpServletRequest request, HttpServletResponse response) {
        return userService.lockingUserByIdnumber(request,response);
    }



    @ResponseBody
    @ControllerLog("退出")
    @RequestMapping("logout")
    public AjaxResult logout(HttpServletRequest request,HttpServletResponse response) {
        return userService.logout(request,response);
    }

    @ResponseBody
    @ControllerLog("获取用户登录盐值加密密码")
    @RequestMapping("loginPassword")
    public AjaxResult loginPassword(HttpServletRequest request, HttpServletResponse response) {
        String result = null;
        try{
            ParamData params = new ParamData();
            String idnumber = params.getString("idnumber");
            String password = params.getString("password");
            User user = userMapper.queryByUsername(idnumber);
            if(user != null){
                PasswordUtil passwordUtil = new PasswordUtil();
                result = passwordUtil.Md5LoginPassword(password,user.getSalt());
            }
        } catch (Exception e) {
            logger.error("用户登录根据用户名密码，查询密码通过盐值加密异常：{} " + e);
        }
        return AppUtil.returnObj(result);
    }

}
