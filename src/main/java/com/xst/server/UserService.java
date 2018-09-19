package com.xst.server;

import com.xst.common.pojo.AjaxResult;
import com.xst.common.util.DataTables;
import com.xst.model.Roles;
import com.xst.model.User;
import org.apache.ibatis.annotations.Param;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @ClassName: UserService
 * @类描述： UserService 用户业务层
 * @Author: xiaoshitou
 * @Email: 15324399524@163.com
 * @CreateDate： 2018/8/23 15:59
 */

public interface UserService {

    //登录系统查询用户是否存在
    AjaxResult selectUserByIdnumber(HttpServletRequest request, HttpServletResponse response);

    //退出系统
    AjaxResult logout(HttpServletRequest request, HttpServletResponse response);

    //锁定账户信息
    AjaxResult lockingUserByIdnumber(HttpServletRequest request, HttpServletResponse response);

    //用户分页显示
    DataTables getPageUserList(DataTables dataTables);

    //改变用户状态
    AjaxResult changeUserState(HttpServletRequest request, HttpServletResponse response);

    //添加用户
    AjaxResult addUpdate(User user);

    //根据角色id 查询用户数量
    int countUserByRoleId(int roleid);

}
