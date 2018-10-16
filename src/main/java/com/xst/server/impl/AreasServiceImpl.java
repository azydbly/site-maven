package com.xst.server.impl;

import com.xst.common.pojo.AjaxResult;
import com.xst.common.pojo.ParamData;
import com.xst.common.util.AppUtil;
import com.xst.common.util.StrUtil;
import com.xst.mapper.AreasMapper;
import com.xst.model.Areas;
import com.xst.model.PuserAreas;
import com.xst.server.AreasService;
import com.xst.server.PuserAreasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

    @Autowired
    private PuserAreasService puserAreasService = new PuserAreasServiceImpl();

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
    public List<Areas> getAreas(List<Integer> idlist) {
        return areasMapper.getAreas(idlist);
    }

    @Override
    public AjaxResult saveAreasZtree(HttpServletRequest request, HttpServletResponse response) {
        ParamData params = new ParamData();
        String userid = params.getString("puserid");
        int puserid = StrUtil.getInteger(userid);
        String data = params.getString("data");
        String result = null;
        boolean returnResult = false;
        puserAreasService.deleteByUserid(StrUtil.getInteger(puserid));
        String[] a = data.split(",");
        for(int i = 0;i < a.length; i++){
            if(!"".equals(a[i])){
                PuserAreas puserAreas = new PuserAreas();
                puserAreas.setPuserid(puserid);
                puserAreas.setAreasid(StrUtil.getInteger(a[i]));
                int resultMap = puserAreasService.insertPuserAndAreas(puserAreas);
                if(resultMap < 1){
                    returnResult = true;
                    break;
                }
            }
        }
        if(returnResult){
            result = "授权失败！";
        }
        return AppUtil.returnObj(result);
    }
}
