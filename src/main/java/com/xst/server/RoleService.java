package com.xst.server;

import com.xst.common.pojo.AjaxResult;
import com.xst.common.util.DataTables;
import com.xst.model.Roles;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @ClassName: RoleService
 * @类描述： RoleService 角色实现层
 * @Author: xiaoshitou
 * @Email: 15324399524@163.com
 * @CreateDate： 2018/9/14 17:58
 */

public interface RoleService {

    //角色分页显示
    DataTables getPageRoleList(DataTables dataTables);

    //角色名重复验证
    void roleNameValidate(HttpServletRequest request, HttpServletResponse response) throws IOException;

    //添加角色
    AjaxResult addUpdate(Roles role);

    //根据 id 查询角色
    Roles getRolesById(HttpServletRequest request, HttpServletResponse response);

    //更新角色
    AjaxResult editUpdate(Roles role);

    //改变角色状态
    AjaxResult changeRoleState(HttpServletRequest request, HttpServletResponse response);

    //删除角色
    AjaxResult deleteRole(List<Integer> idlist);

    //查询所有角色
    List<Roles> getRoleList();
}
