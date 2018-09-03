package com.xst.server.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xst.common.pojo.AjaxResult;
import com.xst.common.pojo.ParamData;
import com.xst.common.util.AppUtil;
import com.xst.common.util.DataTables;
import com.xst.common.util.StrUtil;
import com.xst.controller.UtilController;
import com.xst.mapper.MenuMapper;
import com.xst.model.Menu;
import com.xst.server.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Struct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @ClassName: MenuServiceImpl
 * @类描述： MenuServiceImpl
 * @Author: xiaoshitou
 * @Email: 15324399524@163.com
 * @CreateDate： 2018/8/28 13:29
 */

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;


    @Autowired
    private UtilController utilController;

    @Override
    public List<Menu> selectLoginMenus() {
        return menuMapper.selectLoginMenus();
    }

    @Override
    public DataTables getPageMenuList(DataTables dataTables) {
        PageHelper.startPage(dataTables.getPageNum(), dataTables.getLength()); // 核心分页代码
        PageHelper.orderBy("convert(b.menuname using gbk) COLLATE gbk_chinese_ci asc,convert(a.menuname using gbk) COLLATE gbk_chinese_ci asc");

        if(!StringUtils.isEmpty(dataTables.getColumn())){
            PageHelper.orderBy(dataTables.getColumn() + " " + dataTables.getOrder());
        }

        PageInfo<Menu> pageInfo = new PageInfo<Menu>(menuMapper.getPageMenuList(dataTables.getSearch(), dataTables.getSubSQL()));
        dataTables.setRecordsTotal(pageInfo.getTotal());
        dataTables.setRecordsFiltered(pageInfo.getTotal());
        dataTables.setData(pageInfo.getList() != null ? pageInfo.getList() : new ArrayList<Object>());
        return dataTables;
    }

    @Override
    public AjaxResult changeMenuState(HttpServletRequest request, HttpServletResponse response) {
        ParamData params = new ParamData();
        String id = params.getString("id");
        String state = params.getString("state");
        String result = null;
        int returnResult = menuMapper.changeMenuState(StrUtil.getInteger(id),StrUtil.getInteger(state));
        if(returnResult < 1){
            result = "操作失败";
        }
        return AppUtil.returnObj(result);
    }

    @Override
    public AjaxResult deleteMenu(List<Integer> idlist) {
        String result = null;
        if(selectCountMenu(idlist) < 1){
            if(menuMapper.deleteMenu(idlist) < 1){
                result = "操作失败";
            }
        }else{
            result = "菜单下面存在子菜单，操作失败";
        }
        return AppUtil.returnObj(result);
    }

    @Override
    public int selectCountMenu(List<Integer> idlist) {
        return menuMapper.selectCountMenu(idlist);
    }

    @Override
    public void menuNameValidate(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ParamData params = new ParamData();
        String menuname = params.getString("menuname");
        String id = params.getString("id");
        Menu menu;
        if(id == null){
            menu = menuMapper.selecetMenuByMenuNameOrUrl(menuname,null);
        }else{
            menu = null;
        }
        utilController.validateReturn(request,response,menu);
    }

    @Override
    public void urlValidate(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ParamData params = new ParamData();
        String url = params.getString("url");
        String id = params.getString("id");
        Menu menu;
        if(id == null){
            menu = menuMapper.selecetMenuByMenuNameOrUrl(null,url);
        }else{
            menu = null;
        }
        utilController.validateReturn(request,response,menu);
    }

    @Override
    public List<Menu> selectOneMenu() {
        return menuMapper.selectOneMenu();
    }

    @Override
    public AjaxResult addUpdate(HttpServletRequest request, HttpServletResponse response) {
        ParamData params = new ParamData();
        String result = null;
        String menuname = params.getString("menuname");
        String pid = params.getString("pid");
        String url = params.getString("url");
        String state = params.getString("state");
        String remark = params.getString("remark");

        Menu menu = new Menu();
        menu.setMenuname(menuname);
        menu.setPid(StrUtil.getInteger(pid));
        menu.setUrl(url);
        menu.setState(StrUtil.getInteger(state));
        menu.setRemark(remark);
        menu.setInsertdatetime(new Date());
        menu.setOperatordatetime(new Date());
        int returnResult = menuMapper.insertMenu(menu);
        if(returnResult < 1){
            result = "添加失败";
        }
        return AppUtil.returnObj(result);
    }


}
