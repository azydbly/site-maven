package com.xst.server;

import com.xst.common.pojo.AjaxResult;
import com.xst.common.util.DataTables;
import com.xst.model.Menu;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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

    //改变菜单状态
    AjaxResult changeMenuState(HttpServletRequest request, HttpServletResponse response);

    //删除菜单
    AjaxResult deleteMenu(List<Integer> idlist);

    //查询菜单下面是否包含子菜单
    int selectCountMenu(List<Integer> idlist);

    //菜单名重复验证
    void menuNameValidate(HttpServletRequest request, HttpServletResponse response) throws IOException;

    //菜单跳转地址重复验证
    void urlValidate(HttpServletRequest request, HttpServletResponse response) throws IOException;

    //查询所有一级菜单
    List<Menu> selectOneMenu();

    //添加菜单
    AjaxResult addUpdate(Menu menu);

    //根据 id 查询菜单
    Menu getMenuById(HttpServletRequest request, HttpServletResponse response);

    //更新菜单
    AjaxResult editUpdate(Menu menu);

}
