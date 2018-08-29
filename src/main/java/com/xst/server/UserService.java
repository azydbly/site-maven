package com.xst.server;

import com.xst.common.pojo.AjaxResult;
import com.xst.common.pojo.ParamData;
import com.xst.common.util.AppUtil;
import com.xst.common.util.PasswordUtil;
import com.xst.mapper.UserMapper;
import com.xst.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName: UserService
 * @类描述： UserService 用户业务层
 * @Author: xiaoshitou
 * @Email: 15324399524@163.com
 * @CreateDate： 2018/8/23 15:59
 */

public interface UserService {

    AjaxResult selectUserByIdnumber(HttpServletRequest request, HttpServletResponse response);

    AjaxResult logout(HttpServletRequest request, HttpServletResponse response);

    AjaxResult lockingUserByIdnumber(HttpServletRequest request, HttpServletResponse response);
}
