package com.xst.server;

import com.xst.common.util.DataTables;

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
}
