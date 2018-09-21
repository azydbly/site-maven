package com.xst.server;

import com.xst.model.Dictitem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName: DictitemService
 * @类描述: DictitemService
 * @Author: xiaoshitou
 * @Eamil: 15324399524@163.com
 * @CreateDate: 2018/9/21 11:02
 */
public interface DictitemService {

    //根据字典名称查询详情
    List<Dictitem> getDistiemList(String cnname);
}
