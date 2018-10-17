package com.xst.common.pojo;

import com.xst.model.Menu;
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

    private List<Menu> operationList;

    private List<Menu> operationListByIndex;

    public List<Menu> getOperationListByIndex() {
        return operationListByIndex;
    }

    public void setOperationListByIndex(List<Menu> operationListByIndex) {
        this.operationListByIndex = operationListByIndex;
    }

    public List<Menu> getOperationList() {
        return operationList;
    }

    public void setOperationList(List<Menu> operationList) {
        this.operationList = operationList;
    }

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
