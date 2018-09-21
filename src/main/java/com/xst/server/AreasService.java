package com.xst.server;

import com.xst.model.Areas;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName: AreasService
 * @类描述: AreasService
 * @Author: xiaoshitou
 * @Eamil: 15324399524@163.com
 * @CreateDate: 2018/9/21 14:53
 */
public interface AreasService {

    //查询下级的省市区县
    List<Areas> getAreasByPid(int pid,int level);

    //查询全部省
    List<Areas> getAreasByProvince();
}
