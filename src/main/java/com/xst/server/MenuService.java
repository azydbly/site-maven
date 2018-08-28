package com.xst.server;

import com.xst.common.util.DataTables;
import com.xst.model.Menu;

import java.util.List;

/**
 * @ClassName: MenuService
 * @类描述： MenuService 菜单实现层
 * @Author: xiaoshitou
 * @Email: 15324399524@163.com
 * @CreateDate： 2018/8/28 13:28
 */

public interface MenuService {

    //登录成功查询菜单
    List<Menu> selectLoginMenus();

    //菜单分页显示
    DataTables getPageMenuList(DataTables dataTables);
}
