package com.xst.server;

import com.xst.model.RoleMenu;

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

}
