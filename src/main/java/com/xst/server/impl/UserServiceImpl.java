package com.xst.server.impl;

import ch.qos.logback.core.rolling.helper.IntegerTokenConverter;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xst.common.pojo.AjaxResult;
import com.xst.common.pojo.Identity;
import com.xst.common.pojo.ParamData;
import com.xst.common.util.*;
import com.xst.controller.BaseController;
import com.xst.mapper.UserMapper;
import com.xst.model.Lock;
import com.xst.model.Menu;
import com.xst.model.User;
import com.xst.server.LockService;
import com.xst.server.UserService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * @ClassName: UserServiceImpl
 * @类描述： UserServiceImpl 用户业务实现层
 * @Author: xiaoshitou
 * @Email: 15324399524@163.com
 * @CreateDate： 2018/8/24 10:20
 */

@Service
public class UserServiceImpl implements UserService {

    /**日志*/
    public static Logger logger = LoggerFactory.getLogger(BaseController.class);

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private LockService lockService = new LockServiceImpl();

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Autowired
    private DataCache dataCache;

    @Override
    public AjaxResult selectUserByIdnumber(HttpServletRequest request, HttpServletResponse response) {
        ParamData params = new ParamData();
        String idnumber = params.getString("idnumber");
        String password = params.getString("password");
        String type = params.getString("type");
        String result = null;
        String data = null;
        User user = userMapper.queryByUsername(idnumber);
        if(user == null){
            result = "用户名不存在！";
        }else{
            Boolean flag = false;
            // 1 cookie 没有值或者cookie 中的password 用户自己更改过，0 是cookie 有值
            if("1".equals(type)){
                PasswordUtil passwordUtil = new PasswordUtil();
                flag = passwordUtil.LoginPassword(user.getPassword(),password,user.getSalt());
            }
            if ("0".equals(type)){
                if(user.getPassword().equals(password)){
                    flag = true;
                }else{
                    flag = false;
                }
            }
            if(flag){
                boolean userResult = false;
                if(user.getState() == 0){
                    result = "账户已停用，禁止登陆！";
                }else if(user.getState() == 1){
                    userResult = true;
                }else if(user.getState() == 2){
                    Lock lock = lockService.queryByUserId(idnumber);
                    if(lock != null){
                        Date now = new Date();
                        try {
                            Date dt1 = sdf.parse(sdf.format(now));
                            Date dt2 = sdf.parse(lock.getOperatordatetime());
                            if (dt2.getTime() <= dt1.getTime()) {
                                lockService.updateFlagById(lock.getId());
                                userMapper.updateStateById(user.getId(),1);
                                userResult = true;
                            } else {
                                long time = dt1.getTime() - dt2.getTime();
                                long nd = 1000 * 24 * 60 * 60;
                                long nh = 1000 * 60 * 60;
                                long nm = 1000 * 60;
                                long ss = 1000;
                                // 计算差多少天
                                long day = time / nd;
                                // 计算差多少小时
                                long hour = time % nd / nh;
                                // 计算差多少分钟
                                long min = time % nd % nh / nm;
                                // 计算差多少秒
                                long mins = time % nd % nh % nm / ss;
                                // 计算差多少秒//输出结果
                                String message = "";
                                if(day != 0){
                                    message += day + "天";
                                }
                                if(hour != 0){
                                    message += hour + "小时";
                                }
                                if(min != 0){
                                    message += min + "分";
                                }
                                if(mins != 0){
                                    message += mins + "秒";
                                }
                                result = "账户已经锁定，剩余锁定时间" + message;
                            }
                        }catch(Exception e){
                            logger.error("比较锁定时间转换出错：" + e);
                        }
                    }else{
                        result = "未查询到锁定时间，请联系管理员！";
                    }
                }else{
                    result = "登录发生未知错误，请联系管理员！";
                }
                if(userResult){
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

                    //登录成功，把用户密码传入前台，存入 cookie
                    data = user.getPassword();
                }
            }else{
                result = "密码错误！";
            }
        }
        return AppUtil.returnObj(result,data);
    }


    @Override
    public AjaxResult lockingUserByIdnumber(HttpServletRequest request, HttpServletResponse response) {
        ParamData params = new ParamData();
        String userId = params.getString("userId");
        Date now = new Date();
        userMapper.updateStateById(StrUtil.getInteger(userId),2);
        Lock lock = new Lock();
        Date afterDate = new Date(now.getTime() + 600000);

        lock.setUserid(StrUtil.getInteger(userId));
        lock.setLocking("访问页面过于频繁");
        lock.setInsertdatetime(sdf.format(now));
        lock.setOperatordatetime(sdf.format(afterDate));
        lockService.insertByMal(lock);

        return AppUtil.returnObj(null);
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


    @Override
    public DataTables getPageUserList(DataTables dataTables) {
        PageHelper.startPage(dataTables.getPageNum(), dataTables.getLength()); // 核心分页代码
        PageHelper.orderBy("convert(fullname using gbk) COLLATE gbk_chinese_ci asc");

        if(!org.springframework.util.StringUtils.isEmpty(dataTables.getColumn())){
            PageHelper.orderBy(dataTables.getColumn() + " " + dataTables.getOrder());
        }

        PageInfo<User> pageInfo = new PageInfo<User>(userMapper.getPageUserList(dataTables.getSearch(), dataTables.getSubSQL()));
        dataTables.setRecordsTotal(pageInfo.getTotal());
        dataTables.setRecordsFiltered(pageInfo.getTotal());
        dataTables.setData(pageInfo.getList() != null ? pageInfo.getList() : new ArrayList<Object>());
        return dataTables;
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
