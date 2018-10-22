package com.xst.server;

import com.xst.common.pojo.AjaxResult;
import com.xst.model.RoleMenu;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @ClassName: RoleMenuService
 * @类描述： RoleMenuService
 * @Author: xiaoshitou
 * @Email: 15324399524@163.com
 * @CreateDate： 2018/10/16 20:00
 */
public interface RoleMenuService {

    //根据角色id  查询菜单功能
    List<RoleMenu> getMenuIdByRoleId(int roleid);

    //根据角色id  删除权限
    int deleteByRoleid(int roleid);

    //保存角色权限数据
    AjaxResult saveAreasZtree(HttpServletRequest request, HttpServletResponse response);

    //插入数据
    int insertMenuCope(RoleMenu roleMenu);

}
