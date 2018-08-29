package com.xst.server.impl;

import com.xst.mapper.LockMapper;
import com.xst.mapper.MenuMapper;
import com.xst.model.Lock;
import com.xst.server.LockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName: LockServiceImpl
 * @类描述： LockServiceImpl
 * @Author: xiaoshitou
 * @Email: 15324399524@163.com
 * @CreateDate： 2018/8/29 15:26
 */

@Service
public class LockServiceImpl implements LockService {

    @Autowired
    private LockMapper lockMapper;

    @Override
    public int insertByMal(Lock lock) {
        return lockMapper.insertByMal(lock);
    }

    @Override
    public Lock queryByUserId(String idnumber) {
        return lockMapper.queryByUserId(idnumber);
    }

    @Override
    public int updateFlagById(int id) {
        return lockMapper.updateFlagById(id);
    }
}
