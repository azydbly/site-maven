package com.xst.common.interceptor;

import com.xst.common.exception.AjaxLoginException;
import com.xst.common.exception.AjaxPermissionException;
import com.xst.common.exception.LoginException;
import com.xst.common.exception.PermissionException;
import com.xst.common.pojo.Identity;
import com.xst.common.util.Constant;
import com.xst.common.util.CookieUtil;
import com.xst.common.util.DataCache;
import com.xst.common.util.IPUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 权限拦截器
 *
 * @author czh
 */
public class LoginRequestInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private DataCache dataCache;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //启动支持@Autowired注解
        WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext()).getAutowireCapableBeanFactory().autowireBean(this);
        //登录信息验证结果
        String loginResult = validateLogin(request, response);

        String requestType = request.getHeader("X-Requested-With");
        String accept = request.getHeader("Accept");
        //ajax请求
        if (requestType != null && "XMLHttpRequest".equals(requestType) && accept.contains("application/json")) {
            if(StringUtils.isNotEmpty(loginResult)){
                if (StringUtils.isNotEmpty(loginResult)) {
                    throw new AjaxLoginException(401, loginResult);
                }
            }
        }

        if (StringUtils.isNotEmpty(loginResult)) {
            throw new LoginException(401, loginResult);
        }
        return super.preHandle(request, response, handler);
    }


    private String validateLogin(HttpServletRequest request, HttpServletResponse response) {
        String sessionId = CookieUtil.get(Constant.SESSION_IDENTITY_KEY, request);
        if (StringUtils.isEmpty(sessionId)) {
            return "您还没有登陆，请登陆";
        }
        String idnumber = dataCache.getString(sessionId);
        if (StringUtils.isEmpty(idnumber)) {
            return "登陆已失效，请重新登陆";
        }
        Identity identity = (Identity) dataCache.getValue(idnumber + IPUtil.getIpAdd(request));
        if (identity == null) {
            return "登陆已失效，请重新登陆";
        }
        String identitySessionId = identity.getSessionId();
        if (!identitySessionId.equals(sessionId)) {
            CookieUtil.delete(Constant.SESSION_IDENTITY_KEY, request, response);
            return "您的账号已经在其他地方登陆，请重新登陆";
        }

        // 设置登录用户
       // request.setAttribute("loginUser", identity.getLoginUser());
        return null;
    }

    // 校验权限 true有权限， false 没有权限
    private boolean validateOperation(HttpServletRequest request) {
        String sessionId = CookieUtil.get(Constant.SESSION_IDENTITY_KEY, request);
        String username = (String) dataCache.getValue(sessionId);
        Identity identity = (Identity) dataCache.getValue(username + IPUtil.getIpAdd(request));
        boolean isOper = false;
        String url = request.getServletPath();
        String href = null;
        //动态url过滤,如update/{id}
        String dyUrl = url.substring(url.lastIndexOf("/") + 1);
        if (StringUtils.isNumeric(dyUrl)) {
            url = url.substring(0, url.lastIndexOf("/"));
        }
        return isOper;
    }


}
