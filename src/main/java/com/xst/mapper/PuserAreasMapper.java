package com.xst.mapper;

import com.xst.model.Areas;
import com.xst.model.PuserAreas;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName: AreasMapper
 * @类描述: AreasMapper 用户省市区实体类
 * @Author: xiaoshitou
 * @Eamil: 15324399524@163.com
 * @CreateDate: 2018/9/21 14:49
 */
public interface PuserAreasMapper {

    //根据用户id  删除权限
    int deleteByUserid(@Param("puserid") int puserid);

    //插入数据
    int insertPuserAndAreas(PuserAreas puserAreas);

    //根据用户id  查询全部授权id
    List<PuserAreas> quertListByPuserid(@Param("puserid") int puserid);
}
