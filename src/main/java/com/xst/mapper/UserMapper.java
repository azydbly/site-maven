package com.xst.mapper;

import com.xst.model.User;
import org.apache.ibatis.annotations.Param;

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
}
