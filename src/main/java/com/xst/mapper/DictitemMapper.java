package com.xst.mapper;

import com.xst.model.Dictitem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName: DictitemMapper
 * @类描述: DictitemMapper
 * @Author: xiaoshitou
 * @Eamil: 15324399524@163.com
 * @CreateDate: 2018/9/21 10:51
 */
public interface DictitemMapper {

    //根据字典名称查询详情
    List<Dictitem> getDistiemList(@Param("cnname") String cnname);

}
