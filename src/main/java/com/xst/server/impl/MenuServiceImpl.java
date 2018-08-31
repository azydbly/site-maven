package com.xst.server.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xst.common.util.DataTables;
import com.xst.mapper.MenuMapper;
import com.xst.model.Menu;
import com.xst.server.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
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
}
