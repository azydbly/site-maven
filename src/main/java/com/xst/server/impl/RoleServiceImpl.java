package com.xst.server.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xst.common.controller.ValidateRemoteController;
import com.xst.common.pojo.AjaxResult;
import com.xst.common.pojo.ParamData;
import com.xst.common.util.AppUtil;
import com.xst.common.util.DataTables;
import com.xst.common.util.StrUtil;
import com.xst.mapper.RoleMapper;
import com.xst.model.Menu;
import com.xst.model.Roles;
import com.xst.server.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

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

    @Autowired
    private ValidateRemoteController validateRemoteController;

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

    @Override
    public void roleNameValidate(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ParamData params = new ParamData();
        String rolename = params.getString("rolename");
        String id = params.getString("id");
        Roles role = roleMapper.selectRoleByRoleName(rolename,id);
        validateRemoteController.validateReturn(request,response,role);
    }

    @Override
    public AjaxResult addUpdate(Roles role) {
        String result = null;
        role.setInsertdatetime(new Date());
        role.setOperatordatetime(new Date());
        int returnResult = roleMapper.insertRoles(role);
        if(returnResult < 1){
            result = "添加失败";
        }
        return AppUtil.returnObj(result);
    }

    @Override
    public Roles getRolesById(HttpServletRequest request, HttpServletResponse response) {
        ParamData params = new ParamData();
        String id = params.getString("id");
        return roleMapper.getRolesById(StrUtil.getInteger(id));
    }

    @Override
    public AjaxResult editUpdate(Roles role) {
        String result = null;
        role.setOperatordatetime(new Date());
        int returnResult = roleMapper.updateRole(role);
        if(returnResult < 1){
            result = "更新失败";
        }
        return AppUtil.returnObj(result);
    }
}
