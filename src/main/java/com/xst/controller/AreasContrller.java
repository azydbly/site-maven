package com.xst.controller;

import com.google.gson.Gson;
import com.xst.common.annotation.ControllerLog;
import com.xst.common.util.StrUtil;
import com.xst.model.Areas;
import com.xst.server.AreasService;
import com.xst.server.impl.AreasServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

}
