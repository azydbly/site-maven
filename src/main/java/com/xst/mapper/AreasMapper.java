package com.xst.mapper;

import com.xst.model.Areas;
import org.apache.ibatis.annotations.Param;

import javax.annotation.security.PermitAll;
import java.util.List;

/**
 * @ClassName: AreasMapper
 * @类描述: AreasMapper 省市区实体类
 * @Author: xiaoshitou
 * @Eamil: 15324399524@163.com
 * @CreateDate: 2018/9/21 14:49
 */
public interface AreasMapper {

    //查询下级的省市区县
    List<Areas> getAreasByPid(@Param("pid") int pid,@Param("level") int level);

    //查询全部省
    List<Areas> getAreasByProvince();

    //根据省份id查询全部市
    List<Areas> getAreasByCityByProvince(@Param("pid") int pid);

    //根据市id查询全部区县
    List<Areas> getAreasByCountyByCity(@Param("pid") int pid);

    //根据全部省市区县
    List<Areas> getAreas();
}
