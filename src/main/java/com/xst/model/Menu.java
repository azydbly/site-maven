package com.xst.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @ClassName: Menu
 * @类描述： Menu 菜单实体类
 * @Author: xiaoshitou
 * @Email: 15324399524@163.com
 * @CreateDate： 2018/8/23 9:28
 */

@Table(name = "sys_menu")
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //菜单名称
    private String menuname;

    //菜单opcode
    private int opcode;

    //上级 id
    private int pid;

    //跳转地址
    private String url;

    //图标
    private String iconfont;

    //备注
    private String remark;

    //插入时间
    private Date insertdatetime;

    //修改时间
    private Date operatordatetime;

    //是否停用标识  0 停用 1启用（默认）
    private int state;

    //是否删除 0 删除 1正常
    private int flag;

    //虚拟字段
    private String pname;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMenuname() {
        return menuname;
    }

    public void setMenuname(String menuname) {
        this.menuname = menuname;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIconfont() {
        return iconfont;
    }

    public void setIconfont(String iconfont) {
        this.iconfont = iconfont;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getInsertdatetime() {
        return insertdatetime;
    }

    public void setInsertdatetime(Date insertdatetime) {
        this.insertdatetime = insertdatetime;
    }

    public Date getOperatordatetime() {
        return operatordatetime;
    }

    public void setOperatordatetime(Date operatordatetime) {
        this.operatordatetime = operatordatetime;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public int getOpcode() {
        return opcode;
    }

    public void setOpcode(int opcode) {
        this.opcode = opcode;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }
}
