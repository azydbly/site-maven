package com.xst.server.impl;

import com.xst.mapper.DictitemMapper;
import com.xst.model.Dictitem;
import com.xst.server.DictitemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: DictitemServiceImpl
 * @类描述: DictitemServiceImpl
 * @Author: xiaoshitou
 * @Eamil: 15324399524@163.com
 * @CreateDate: 2018/9/21 11:02
 */

@Service
public class DictitemServiceImpl implements DictitemService {

    @Autowired
    private DictitemMapper dictitemMapper;

    @Override
    public List<Dictitem> getDistiemList(String cnname) {
        return dictitemMapper.getDistiemList(cnname);
    }
}
