package com.xst.mapper;

import com.xst.model.RoleMenu;
import com.xst.model.Roles;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName: RoleMapper
 * @类描述： RoleMapper 菜案角色mapper
 * @Author: xiaoshitou
 * @Email: 15324399524@163.com
 * @CreateDate： 2018/9/17 10:26
 */
public interface RoleMenuMapper {

    //根据角色id  查询菜单功能
    List<RoleMenu> getMenuIdByRoleId(@Param("roleid") int roleid);

}

