package com.xst.server.impl;

import com.xst.common.pojo.AjaxResult;
import com.xst.common.pojo.ParamData;
import com.xst.common.util.AppUtil;
import com.xst.common.util.StrUtil;
import com.xst.mapper.RoleMenuMapper;
import com.xst.model.RoleMenu;
import com.xst.server.RoleMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

    @Override
    public int deleteByRoleid(int roleid) {
        return roleMenuMapper.deleteByRoleid(roleid);
    }

    @Override
    public AjaxResult saveAreasZtree(HttpServletRequest request, HttpServletResponse response) {
        ParamData params = new ParamData();
        String roleid = params.getString("roleid");
        String data = params.getString("data");
        deleteByRoleid(StrUtil.getInteger(roleid));
        String[] a = data.split(",");
        String result = null;
        boolean returnResult = false;
        for(int i = 0;i < a.length; i++){
            if(!"".equals(a[i])){
                RoleMenu roleMenu = new RoleMenu();
                roleMenu.setRoleid(StrUtil.getInteger(roleid));
                roleMenu.setMenucope(StrUtil.getInteger(a[i]));
                int resultMap = insertMenuCope(roleMenu);
                if(resultMap < 1){
                    returnResult = true;
                    break;
                }
            }
        }
        if(returnResult){
            result = "授权失败！";
        }
        return AppUtil.returnObj(result);
    }

    @Override
    public int insertMenuCope(RoleMenu roleMenu) {
        return roleMenuMapper.insertMenuCope(roleMenu);
    }
}
