package com.xst.mapper;

import com.xst.model.Menu;
import com.xst.model.Roles;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName: RoleMapper
 * @类描述： RoleMapper 角色mapper
 * @Author: xiaoshitou
 * @Email: 15324399524@163.com
 * @CreateDate： 2018/9/17 10:26
 */
public interface RoleMapper {

    //角色分页显示
    List<Roles> getPageRoleList(@Param("search") String search, @Param("subSQL") String subSQL);

    //验证角色名称是否重复
    Roles selectRoleByRoleName(@Param("rolename") String menuname,@Param("id") String id);

    //添加角色
    int insertRoles(Roles roles);

    //根据 id 查询角色
    Roles getRolesById(@Param("id") int id);

    //更新角色
    int updateRole(Roles role);

    //改变角色状态
    int changeRoleState(@Param("id") int id,@Param("state") int state);

    //删除角色
    int deleteRole(@Param("idlist")List<Integer> idlist);
}

