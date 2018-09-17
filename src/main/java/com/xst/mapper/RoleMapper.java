package com.xst.mapper;

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
}
