package com.xst.server.impl;

import com.xst.mapper.RoleMenuMapper;
import com.xst.model.RoleMenu;
import com.xst.server.RoleMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: RoleMenuServiceImpl
 * @类描述： RoleMenuServiceImpl
 * @Author: xiaoshitou
 * @Email: 15324399524@163.com
 * @CreateDate： 2018/10/16 20:00
 */

@Service
public class RoleMenuServiceImpl implements RoleMenuService {

    @Autowired
    private RoleMenuMapper roleMenuMapper;

    @Override
    public List<RoleMenu> getMenuIdByRoleId(int roleid) {
        return roleMenuMapper.getMenuIdByRoleId(roleid);
    }
}
