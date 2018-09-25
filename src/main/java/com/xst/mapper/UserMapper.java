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

    //用户分页显示
    List<User> getPageUserList(@Param("search") String search, @Param("subSQL") String subSQL);

    //改变用户状态
    int changeUserState(@Param("id") int id,@Param("state") int state,@Param("lockid") int lockid);

    //添加用户
    int insertUser(User user);

    //根据角色id 查询用户数量（停用角色时使用）
    int countUserByRoleId(@Param("roleid") int roleid);

    //根据角色id 查询用户数量（批量删除角色时使用）
    int countUserByRoleIds(@Param("idlist") List<Integer> idlist);

    //验证身份证号是否重复
    User selectUserByIdNumber(@Param("idnumber") String idnumber,@Param("id") String id);

    //根据用户id查询用户
    User selectUserById(@Param("id") int id);

    //更改用户锁定状态
    int updateStateById(@Param("state") int state,@Param("lockid") int lockid,@Param("id") int id);

}
