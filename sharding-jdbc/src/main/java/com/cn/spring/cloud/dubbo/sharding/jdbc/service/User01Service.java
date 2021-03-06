package com.cn.spring.cloud.dubbo.sharding.jdbc.service;

import com.cn.spring.cloud.dubbo.sharding.jdbc.mapper.UserMapper;
import com.cn.spring.cloud.dubbo.sharding.jdbc.entity.UserEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author luozhonghua
 * @since 0.0.1
 */
@Service
public class User01Service {

    @Resource
    private UserMapper userMapper;

    private Long userId;

    @Transactional("mybatisTransactionManager")
    public void updateWithFail() {
        UserEntity user = new UserEntity();
        user.setCityId(1);
        user.setUserName("insertTest");
        user.setAge(10);
        user.setBirth(new Date());

        userMapper.insertSlave(user);

        userId = user.getUserId();

        user.setUserName("insertTest2");
        userMapper.update(user);
        throw new IllegalArgumentException("failed");
    }

    @Transactional("mybatisTransactionManager")
    public void updateWithoutInsertFail() {
        UserEntity one = userMapper.getLimitOne();
        UserEntity user = new UserEntity();
        user.setUserName("insertTest2");
        user.setUserId(one.getUserId());
        userId = one.getUserId();
        userMapper.update(user);
        throw new IllegalArgumentException("failed");
    }

    public Long getUserId() {
        return userId;
    }

}
