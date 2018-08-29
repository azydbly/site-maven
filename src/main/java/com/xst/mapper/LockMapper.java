package com.xst.mapper;

import com.xst.model.Lock;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: LockMapper
 * @类描述： LockMapper
 * @Author: xiaoshitou
 * @Email: 15324399524@163.com
 * @CreateDate： 2018/8/29 15:27
 */
public interface LockMapper {

    //锁定账户
    int insertByMal(Lock lock);

    //根据用户id  查询锁
    Lock queryByUserId(@Param("idnumber") String idnumber);

    //更新锁的状态
    int updateFlagById(@Param("id")int id);

}
