package com.xst.server.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xst.common.util.DataTables;
import com.xst.mapper.RoleMapper;
import com.xst.model.Roles;
import com.xst.server.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;

/**
 * @ClassName: RoleServiceImpl
 * @类描述： RoleServiceImpl  角色实现层
 * @Author: xiaoshitou
 * @Email: 15324399524@163.com
 * @CreateDate： 2018/9/14 17:59
 */

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public DataTables getPageRoleList(DataTables dataTables) {
        PageHelper.startPage(dataTables.getPageNum(), dataTables.getLength()); // 核心分页代码
        PageHelper.orderBy("convert(rolename using gbk) COLLATE gbk_chinese_ci asc");

        if(!StringUtils.isEmpty(dataTables.getColumn())){
            PageHelper.orderBy(dataTables.getColumn() + " " + dataTables.getOrder());
        }

        PageInfo<Roles> pageInfo = new PageInfo<Roles>(roleMapper.getPageRoleList(dataTables.getSearch(), dataTables.getSubSQL()));
        dataTables.setRecordsTotal(pageInfo.getTotal());
        dataTables.setRecordsFiltered(pageInfo.getTotal());
        dataTables.setData(pageInfo.getList() != null ? pageInfo.getList() : new ArrayList<Object>());
        return dataTables;
    }
}
