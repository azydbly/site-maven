package com.xst.mapper;

import com.xst.model.Menu;
import com.xst.model.Roles;
import com.xst.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName: UserMapper
 * @类描述： UserMapper 用户mapper
 * @Author: xiaoshitou
 * @Email: 15324399524@163.com
 * @CreateDate： 2018/8/23 15:34
 */
public interface UserMapper {

    //根据身份证号查询信息
    User queryByUsername(@Param("idnumber") String idnumber);

    //登录成功之后更新最后登录时间和最后登录Ip
    int updateLastByIdnumber(User user);

    //更改用户状态
    int updateStateById(@Param("id")int id,@Param("state")int state);

    //用户分页显示
    List<User> getPageUserList(@Param("search") String search, @Param("subSQL") String subSQL);

    //改变用户状态
    int changeUserState(@Param("id") int id,@Param("state") int state);

    //添加用户
    int insertUser(User user);

    //根据角色id 查询用户数量（停用角色时使用）
    int countUserByRoleId(@Param("roleid") int roleid);

    //根据角色id 查询用户数量（批量删除角色时使用）
    int countUserByRoleIds(@Param("idlist") List<Integer> idlist);
}
