package com.xst.mapper;

import com.xst.model.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName: MenuMapper
 * @类描述： MenuMapper
 * @Author: xiaoshitou
 * @Email: 15324399524@163.com
 * @CreateDate： 2018/8/28 13:30
 */
public interface MenuMapper {

    //登录成功查询菜单
    List<Menu> selectLoginMenus();

    //菜单分页显示
    List<Menu> getPageMenuList(@Param("search") String search, @Param("subSQL") String subSQL);
}
