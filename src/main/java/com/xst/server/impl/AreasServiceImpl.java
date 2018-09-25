package com.xst.server.impl;

import com.xst.mapper.AreasMapper;
import com.xst.mapper.ZtreeNode;
import com.xst.model.Areas;
import com.xst.server.AreasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: AreasServiceImpl
 * @类描述: AreasServiceImpl
 * @Author: xiaoshitou
 * @Eamil: 15324399524@163.com
 * @CreateDate: 2018/9/21 14:54
 */

@Service
public class AreasServiceImpl implements AreasService {

    @Autowired
    private AreasMapper areasMapper;

    @Override
    public List<Areas> getAreasByPid(int pid,int level) {
        return areasMapper.getAreasByPid(pid,level);
    }

    @Override
    public List<Areas> getAreasByProvince() {
        return areasMapper.getAreasByProvince();
    }

    @Override
    public List<Areas> getAreasByCityByProvince(int pid) {
        return areasMapper.getAreasByCityByProvince(pid);
    }

    @Override
    public List<Areas> getAreasByCountyByCity(int pid) {
        return areasMapper.getAreasByCountyByCity(pid);
    }

    @Override
    public List<Areas> getAreas() {
        return areasMapper.getAreas();
    }
}
