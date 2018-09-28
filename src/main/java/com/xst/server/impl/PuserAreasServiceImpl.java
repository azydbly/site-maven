package com.xst.server.impl;

import com.xst.mapper.PuserAreasMapper;
import com.xst.model.PuserAreas;
import com.xst.server.PuserAreasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: PuserAreasServiceImpl
 * @类描述： PuserAreasServiceImpl
 * @Author: xiaoshitou
 * @Email: 15324399524@163.com
 * @CreateDate： 2018/9/27 17:06
 */

@Service
public class PuserAreasServiceImpl implements PuserAreasService {

    @Autowired
    private PuserAreasMapper puserAreasMapper;

    @Override
    public int deleteByUserid(int puserid) {
        return puserAreasMapper.deleteByUserid(puserid);
    }

    @Override
    public int insertPuserAndAreas(PuserAreas puserAreas) {
        return puserAreasMapper.insertPuserAndAreas(puserAreas);
    }

    @Override
    public List<PuserAreas> quertListByPuserid(int puserid) {
        return puserAreasMapper.quertListByPuserid(puserid);
    }
}
