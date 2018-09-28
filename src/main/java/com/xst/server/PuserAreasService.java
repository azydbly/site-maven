package com.xst.server;

import com.xst.model.PuserAreas;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName: PuserAreasService
 * @类描述： PuserAreasService
 * @Author: xiaoshitou
 * @Email: 15324399524@163.com
 * @CreateDate： 2018/9/27 17:06
 */
public interface PuserAreasService {

    //根据用户id  删除权限
    int deleteByUserid(int puserid);

    //插入数据
    int insertPuserAndAreas(PuserAreas puserAreas);

    //根据用户id  查询全部授权id
    List<PuserAreas> quertListByPuserid(int puserid);
}
