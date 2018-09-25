package com.xst.model;

/**
 * @ClassName: PuserAreas
 * @类描述: PuserAreas  用户 省市区县id
 * @Author: xiaoshitou
 * @Eamil: 15324399524@163.com
 * @CreateDate: 2018/9/25 20:23
 */
public class PuserAreas {

    //用户id
    private int puserid;

    //省市区县id
    private int areasid;

    public int getPuserid() {
        return puserid;
    }

    public void setPuserid(int puserid) {
        this.puserid = puserid;
    }

    public int getAreasid() {
        return areasid;
    }

    public void setAreasid(int areasid) {
        this.areasid = areasid;
    }
}
