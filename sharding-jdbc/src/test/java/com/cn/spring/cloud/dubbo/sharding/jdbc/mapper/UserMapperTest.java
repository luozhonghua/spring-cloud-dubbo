package com.cn.spring.cloud.dubbo.sharding.jdbc.mapper;

import com.cn.spring.cloud.dubbo.sharding.jdbc.costants.SqlConstants;
import com.cn.spring.cloud.dubbo.sharding.jdbc.entity.UserEntity;
import com.cn.spring.cloud.dubbo.sharding.jdbc.mapper.UserMapper;
import com.cn.spring.cloud.dubbo.sharding.jdbc.service.User01Service;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Resource
    private DataSource mybatisDataSource;

    @Resource
    private User01Service user01Service;

    private UserEntity user;

    @Before
    public void setup() throws Exception {
        create();
        clear();
        init();
    }

    private void clear() {
        userMapper.deleteAll();
    }

    private void init() {
        user = new UserEntity();
        user.setUserId(1L);
        user.setCityId(1);
        user.setUserName("insertTest");
        user.setAge(10);
        user.setBirth(new Date());
    }

    private void create() throws SQLException {
        executeUpdate(mybatisDataSource, SqlConstants.USER_CREATE_SQL);
    }

    private void executeUpdate(final DataSource dataSource, final String sql) throws SQLException {
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.executeUpdate();
        }
    }

    private void testUp() throws Exception {
        assertTrue(userMapper.insert(user) > 0);
    }

    private void tearDown() throws Exception {
        assertTrue(userMapper.delete(1L) > 0);
    }

    @Test
    public void getAll() throws Exception {
        testUp();
        List<UserEntity> all = userMapper.getAll();
        assertTrue(all.size() > 0);
        tearDown();
    }

    @Test
    public void betchSave() throws Exception{

        for(int i=0;i<10;i++){
            UserEntity user = new UserEntity();
            user.setCityId(i);
            user.setUserName("insertTest"+i);
            user.setAge(10);
            user.setBirth(new Date());
            userMapper.insertSlave(user);
        }
        List<UserEntity> all = userMapper.getAll();
        for(UserEntity u:all){
            System.out.println(u.getUserName()+"  "+ u.getCityId());
        }
    }

    @Test
    public void getOneSlave() throws Exception {
        UserEntity user = new UserEntity();
        user.setCityId(3);
        user.setUserName("insertTest2");
        user.setAge(10);
        user.setBirth(new Date());
        userMapper.insertSlave(user);
        List<UserEntity> all = userMapper.getAll();
        for(UserEntity u:all){
           System.out.println(u.getUserName()+"  "+ u.getCityId());
        }
       // assertTrue(userMapper.insertSlave(user) > 0);
         Long userId = user.getUserId();
        System.out.println("Generated Key--userId:" + userId);
        // UserEntity one = userMapper.getOne(userId);
        //assertEquals("insertTest", one.getUserName());
      //  assertTrue(userMapper.delete(userId) > 0);
    }

    @Test
    public void getOne() throws Exception {
        testUp();
        UserEntity one = userMapper.getOne(1L);
        assertEquals("insertTest", one.getUserName());
        tearDown();
    }

    @Test
    public void update() throws Exception {
         testUp();
        UserEntity user = new UserEntity();
        user.setUserId(1L);
        user.setUserName("insertTest2");
        assertTrue(userMapper.update(user) > 0);
        UserEntity one = userMapper.getOne(1L);
         assertEquals("insertTest2", one.getUserName());
         tearDown();
    }

    @Test
    public void updateFailure() {
        try {
            user01Service.updateWithFail();
        } catch (Exception e) {
            System.out.println("rollback");
        }
        UserEntity one = userMapper.getOne(user01Service.getUserId());
        assertTrue(one == null);
    }

    @Test
    public void updateWithoutInsertFailure() {
        try {
            UserEntity user = new UserEntity();
            user.setCityId(1);
            user.setUserName("insertTest");
            user.setAge(10);
            user.setBirth(new Date());
            userMapper.insertSlave(user);
            user01Service.updateWithoutInsertFail();
        } catch (Exception e) {
            System.out.println("rollback");
        }
        UserEntity one = userMapper.getOne(user01Service.getUserId());
        assertEquals("insertTest", one.getUserName());
    }

}