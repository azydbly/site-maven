package com.xst.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @ClassName: Lock
 * @类描述： Lock 锁定账户实体类
 * @Author: xiaoshitou
 * @Email: 15324399524@163.com
 * @CreateDate： 2018/8/29 15:20
 */

@Table(name = "edu_lock")
public class Lock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //用户id
    private int userid;

    //锁定原因
    private String locking;

    //锁定时间
    private String insertdatetime;

    //解锁时间
    private String operatordatetime;

    //标识
    private int flag;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getLocking() {
        return locking;
    }

    public void setLocking(String locking) {
        this.locking = locking;
    }

    public String getInsertdatetime() {
        return insertdatetime;
    }

    public void setInsertdatetime(String insertdatetime) {
        this.insertdatetime = insertdatetime;
    }

    public String getOperatordatetime() {
        return operatordatetime;
    }

    public void setOperatordatetime(String operatordatetime) {
        this.operatordatetime = operatordatetime;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }
}
