package com.xst.controller;

import com.alibaba.fastjson.JSON;
import com.xst.common.annotation.Authority;
import com.xst.common.annotation.ControllerLog;
import com.xst.common.pojo.AjaxResult;
import com.xst.common.pojo.ParamData;
import com.xst.common.util.DataTables;
import com.xst.model.Roles;
import com.xst.model.User;
import com.xst.server.DictitemService;
import com.xst.server.RoleService;
import com.xst.server.UserService;
import com.xst.server.impl.DictitemServiceImpl;
import com.xst.server.impl.RoleServiceImpl;
import com.xst.server.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.List;

/**
 * @ClassName: UserContrller
 * @类描述： UserContrller 用户控制层
 * @Author: xiaoshitou
 * @Email: 15324399524@163.com
 * @CreateDate： 2018/9/17 17:23
 */

@Controller
@RequestMapping("/xst/user/")
public class UserContrller extends BaseController {

    @Autowired
    private UserService userService = new UserServiceImpl();

    @Autowired
    private RoleService roleService = new RoleServiceImpl();

    @Autowired
    private DictitemService dictitemService = new DictitemServiceImpl();

    @Autowired
    private AreasContrller areasContrller;


    @ControllerLog("进入用户 list 页面")
    @RequestMapping("list")
    @Authority(opCode = "1103", opName = "用户列表")
    public String userList(){
        return "system/user/index";
    }

    @ResponseBody
    @ControllerLog("用户 list 页面，分页显示用户")
    @RequestMapping("showPageUser")
    @Authority(opCode = "110301", opName = "查询用户")
    public String showPageUser(@RequestParam(value="state",required=false)String state, @RequestParam(value="fullname",required=false)String fullname, HttpServletRequest request, HttpServletResponse response){
        state = StringUtils.isEmpty(state) ? "" : (" and u.state = " + state);
        return JSON.toJSONString(userService.getPageUserList(DataTables.getInstance(request,state,fullname)));
    }

    @ResponseBody
    @ControllerLog("改变用户状态")
    @RequestMapping("userState")
    @Authority(opCode = "110303", opName = "修改用户状态")
    public AjaxResult changeUserState(HttpServletRequest request, HttpServletResponse response){
        return userService.changeUserState(request,response);
    }

    @ControllerLog("进入用户 add 页面")
    @RequestMapping("add")
    @Authority(opCode = "110304", opName = "添加用户页面")
    public String addUser(HttpServletRequest request, HttpServletResponse response){
        String[] dictionary = {"nation","politics"};
        for(String cnname : dictionary){
            request.setAttribute(cnname + "List",dictitemService.getDistiemList(cnname));
        }
        request.setAttribute("provinceList",areasContrller.getAreasByProvince());
        request.setAttribute("roleList",roleService.getRoleList());
        return "system/user/add";
    }

    @ResponseBody
    @ControllerLog("添加用户")
    @RequestMapping("addUpdate")
    @Authority(opCode = "11030403", opName = "添加用户")
    public AjaxResult addUpdate(User user) throws Exception{
        return userService.addUpdate(user);
    }

    @ControllerLog("身份证号重复验证")
    @RequestMapping("idnumber/validate")
    @Authority(opCode = "11030401", opName = "添加身份证号重复验证")
    public void idNumberValidate(HttpServletRequest request, HttpServletResponse response) throws IOException {
        userService.idNumberValidate(request,response);
    }

    @ControllerLog("进入修用户页面")
    @RequestMapping("edit")
    @Authority(opCode = "110305", opName = "修改用户页面")
    public String edit(HttpServletRequest request, HttpServletResponse response){
        String[] dictionary = {"nation","politics"};
        for(String cnname : dictionary){
            request.setAttribute(cnname + "List",dictitemService.getDistiemList(cnname));
        }
        User user = userService.selectUserById(request,response);
        request.setAttribute("provinceList",areasContrller.getAreasByProvince());
        request.setAttribute("cityList",areasContrller.getAreasByCityByProvince(user.getProvince()));
        request.setAttribute("countyList",areasContrller.getAreasByCountyByCity(user.getCity()));
        request.setAttribute("roleList",roleService.getRoleList());
        request.setAttribute("user",user);
        return "system/user/edit";
    }

    @ResponseBody
    @ControllerLog("修改用户")
    @RequestMapping("editUpdate")
    @Authority(opCode = "11030502", opName = "更新用户")
    public AjaxResult editUpdate(User user){
        return userService.editUpdate(user);
    }

    @ResponseBody
    @ControllerLog("删除用户")
    @RequestMapping("/delete")
    @Authority(opCode = "110302", opName = "删除用户")
    public AjaxResult deleteUsers(@RequestParam("idlist[]") List<Integer> idlist){
        return userService.deleteUser(idlist);
    }


    @ControllerLog("配置用户数据权限页面")
    @RequestMapping("configure")
    @Authority(opCode = "110306", opName = "配置地区权限页面")
    public String Configure(HttpServletRequest request, HttpServletResponse response){
        ParamData params = new ParamData();
        String puserid = params.getString("id");
        request.setAttribute("puserid",puserid);
        return "system/user/configure";
    }

}
