package com.xst.server.impl;

import com.xst.common.pojo.AjaxResult;
import com.xst.common.pojo.Identity;
import com.xst.common.pojo.ParamData;
import com.xst.common.util.*;
import com.xst.mapper.UserMapper;
import com.xst.model.User;
import com.xst.server.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName: UserServiceImpl
 * @类描述： UserServiceImpl 用户业务实现层
 * @Author: xiaoshitou
 * @Email: 15324399524@163.com
 * @CreateDate： 2018/8/24 10:20
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private DataCache dataCache;

    @Override
    public AjaxResult selectUserByIdnumber(HttpServletRequest request, HttpServletResponse response) {
        ParamData params = new ParamData();
        String idnumber = params.getString("idnumber");
        String password = params.getString("password");
        String result = null;
        User user = userMapper.queryByUsername(idnumber);
        if(user == null){
            result = "用户名不存在！";
        }else{
            PasswordUtil passwordUtil = new PasswordUtil();
            Boolean flag = passwordUtil.LoginPassword(user.getPassword(),password,user.getSalt());
            if(flag){
                String loginIp = params.getString("loginIp");
                // 更新登录IP和登录时间
                user.setLoginIp(loginIp);
                user.setLoginTime(DateUtil.getCurDateTime());
                userMapper.updateLastByIdnumber(user);

                Identity identity = new Identity();
                identity.setLoginUser(user);
                identity.setLoginIp(loginIp);
                String sessionId = getSessionId(idnumber, identity.getLoginIp());
                identity.setSessionId(sessionId);

                dataCache.setValue(idnumber + loginIp, identity);
                dataCache.setValue(sessionId, idnumber);
                CookieUtil.set(Constant.SESSION_IDENTITY_KEY, sessionId, response);
            }else{
                result = "密码错误！";
            }
        }
        return AppUtil.returnObj(result);
    }

    @Override
    public AjaxResult logout(HttpServletRequest request, HttpServletResponse response) {
        String sessionId = CookieUtil.get(Constant.SESSION_IDENTITY_KEY, request);
        if (StringUtils.isNotEmpty(sessionId)) {
            dataCache.remove(sessionId);
            String userName = (String) dataCache.getValue(sessionId);
            if (StringUtils.isNotEmpty(userName)) {
                dataCache.remove(userName + IPUtil.getIpAdd(request));
            }
            CookieUtil.delete(Constant.SESSION_IDENTITY_KEY, request, response);
        }
        return AppUtil.returnObj(null);
    }

    private String getSessionId(String userName, String ip) {
        String str = userName + "_" + System.currentTimeMillis() + "_" + ip;
        try {
            return MD5Util.encrypt(str);
        } catch (Exception e) {
            return "生成token错误";
        }
    }
}
