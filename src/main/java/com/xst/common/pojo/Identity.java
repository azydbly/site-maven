package com.xst.common.pojo;

import com.xst.model.User;

import java.util.List;

/**
 * 封装Session
 * @author CZH
 */

public class Identity {

	private String sessionId;

	private String loginIp;

	private User loginUser;


    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    public User getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(User loginUser) {
        this.loginUser = loginUser;
    }

}
