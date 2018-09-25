package com.xst.controller;

import com.google.gson.Gson;
import com.xst.common.annotation.ControllerLog;
import com.xst.common.util.StrUtil;
import com.xst.mapper.ZtreeNode;
import com.xst.model.Areas;
import com.xst.server.AreasService;
import com.xst.server.impl.AreasServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: AraesContrller
 * @类描述: AraesContrller
 * @Author: xiaoshitou
 * @Eamil: 15324399524@163.com
 * @CreateDate: 2018/9/21 14:55
 */

@Controller
@RequestMapping("/areas/")
public class AreasContrller extends BaseController {

    @Autowired
    private AreasService areasService = new AreasServiceImpl();


    @ResponseBody
    @ControllerLog("根据id查询下一级")
    @RequestMapping(value = "getAreasByPid", produces = "application/json; charset=utf-8")
    public String getAreasByPid(String pid,String level){
        List<Areas> list = areasService.getAreasByPid(StrUtil.getInteger(pid),StrUtil.getInteger(level));
        Gson gson = new Gson();
        String json = gson.toJson(list);
        return json;
    }

    @ResponseBody
    @ControllerLog("查询全部省")
    public List<Areas> getAreasByProvince(){
        List<Areas> list = areasService.getAreasByProvince();
        return list;
    }

    @ResponseBody
    @ControllerLog("根据省份id查询全部市")
    public List<Areas> getAreasByCityByProvince(int pid){
        List<Areas> list = areasService.getAreasByCityByProvince(pid);
        return list;
    }

    @ResponseBody
    @ControllerLog("根据市id查询全部区县")
    public List<Areas> getAreasByCountyByCity(int pid){
        List<Areas> list = areasService.getAreasByCountyByCity(pid);
        return list;
    }

    @ResponseBody
    @ControllerLog("根据全部省市区县")
    @RequestMapping(value = "getAreas", produces = "application/json; charset=utf-8")
    public String getAreas(){
        List<Areas> list = areasService.getAreas();
        List<ZtreeNode> l = new ArrayList<ZtreeNode>();
        for(int i = 0; i < list.size(); i++){
            ZtreeNode ztreeNode = new ZtreeNode();
            ztreeNode.setId(list.get(i).getNumber());
            ztreeNode.setName(list.get(i).getName());
            ztreeNode.setpId(list.get(i).getPid());
            l.add(ztreeNode);

        }
        Gson gson = new Gson();
        String json = gson.toJson(l);
        System.out.println("-=------" + json);
        return json;
    }

}
