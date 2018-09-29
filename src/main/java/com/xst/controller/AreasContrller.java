package com.xst.controller;

import com.google.gson.Gson;
import com.xst.common.annotation.ControllerLog;
import com.xst.common.pojo.AjaxResult;
import com.xst.common.pojo.ParamData;
import com.xst.common.util.StrUtil;
import com.xst.model.PuserAreas;
import com.xst.model.ZtreeNode;
import com.xst.model.Areas;
import com.xst.server.AreasService;
import com.xst.server.PuserAreasService;
import com.xst.server.impl.AreasServiceImpl;
import com.xst.server.impl.PuserAreasServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
@RequestMapping("/xst/areas/")
public class AreasContrller extends BaseController {

    @Autowired
    private AreasService areasService = new AreasServiceImpl();

    @Autowired
    private PuserAreasService puserAreasService = new PuserAreasServiceImpl();


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
        ParamData params = new ParamData();
        String puserid = params.getString("id");
        List<Integer> listObject = new ArrayList<Integer>();
        for(int i = 1; i <= 3; i++){
            listObject.add(i);
        }
        List<Areas> list = areasService.getAreas(listObject);
        List<PuserAreas> listPuserAreas = puserAreasService.quertListByPuserid(StrUtil.getInteger(puserid));
        List<ZtreeNode> ztreeNodeJson = new ArrayList<ZtreeNode>();
        for(int i = 0; i < list.size(); i++){
            ZtreeNode ztreeNode = new ZtreeNode();
            ztreeNode.setId(list.get(i).getNumber());
            ztreeNode.setName(list.get(i).getName());
            ztreeNode.setpId(list.get(i).getPid());
            for(int j = 0; j < listPuserAreas.size(); j++){
                if(listPuserAreas.get(j).getAreasid() == list.get(i).getNumber()){
                    ztreeNode.setChecked(true);
                }
            }
            ztreeNodeJson.add(ztreeNode);
        }
        Gson gson = new Gson();
        String json = gson.toJson(ztreeNodeJson);
        return json;
    }


    @ResponseBody
    @ControllerLog("保存用户地区数据")
    @RequestMapping("saveAreasZtree")
    public AjaxResult saveAreasZtree(HttpServletRequest request, HttpServletResponse response){
        return areasService.saveAreasZtree(request,response);
    }

}
