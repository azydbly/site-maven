package com.xst.server;

import com.xst.common.pojo.AjaxResult;
import com.xst.common.util.DataTables;
import com.xst.model.Roles;
import com.xst.model.User;
import org.apache.ibatis.annotations.Param;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
    AjaxResult addUpdate(User user) throws Exception;

    //根据角色id 查询用户数量（停用角色时使用）
    int countUserByRoleId(int roleid);

    //根据角色id 查询用户数量（批量删除角色时使用）
    int countUserByRoleIds(List<Integer> idlist);

    //省份证号重复验证
    void idNumberValidate(HttpServletRequest request, HttpServletResponse response) throws IOException;

}
