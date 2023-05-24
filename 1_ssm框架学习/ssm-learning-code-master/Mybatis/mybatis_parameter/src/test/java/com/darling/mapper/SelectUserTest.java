package com.darling.mapper;

import com.darling.Utils.SqlSessionUtils;
import com.darling.pojo.User;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class SelectUserTest {
    @Test
    public void testSelectUserByUsername(){
        UserMapper mapper = SqlSessionUtils.getSqlSession().getMapper(UserMapper.class);
        User user=mapper.selectUserByUsername("admin");
        System.out.println(user);
    }
    @Test
    public void testLoginIn(){
        UserMapper mapper = SqlSessionUtils.getSqlSession().getMapper(UserMapper.class);
        User user=mapper.loginin("admin","123456");
        System.out.println(user);
    }
    @Test
    public void testLoginMap(){
        UserMapper mapper = SqlSessionUtils.getSqlSession().getMapper(UserMapper.class);
        Map<String,Object> map =new HashMap<>();
        map.put("username","admin");
        map.put("password","123456");
        User user=mapper.loginMap(map);
        System.out.println(user);
    }
    @Test
    public void testInsert(){
        UserMapper mapper = SqlSessionUtils.getSqlSession().getMapper(UserMapper.class);
        User user = new User(null,"lady","777777",21,"女","123@qq.com");
        mapper.insert(user);
        System.out.println(user);
    }
    @Test
    public void testLoginParam(){
        UserMapper mapper = SqlSessionUtils.getSqlSession().getMapper(UserMapper.class);
        User user=mapper.loginParam("admin","123456");
        System.out.println(user);
    }
}
