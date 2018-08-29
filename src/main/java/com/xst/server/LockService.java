package com.xst.server;

import com.xst.model.Lock;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: LockService
 * @类描述： LockService 锁定账户实现类
 * @Author: xiaoshitou
 * @Email: 15324399524@163.com
 * @CreateDate： 2018/8/29 15:25
 */
public interface LockService {

    //锁定账户
    int insertByMal(Lock lock);

    //根据用户id  查询锁
    Lock queryByUserId(String idnumber);

    //更新锁的状态
    int updateFlagById(int id);

}
