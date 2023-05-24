package com.darling.mapper;

import com.darling.Utils.SqlSessionUtils;
import com.darling.pojo.User;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class SelectUser {
    @Test
    public void testSelectUserById(){
        SelectMapper mapper = SqlSessionUtils.getSqlSession().getMapper(SelectMapper.class);
        User user = mapper.SelectUserById(1);
        System.out.println(user);
    }
    @Test
    public void testSelectUser(){
        SelectMapper mapper = SqlSessionUtils.getSqlSession().getMapper(SelectMapper.class);
        List<User> users = mapper.selectUser();
        for (User user : users) {
            System.out.println(user);
        }
    }
    @Test
    public void testCount(){
        SelectMapper mapper = SqlSessionUtils.getSqlSession().getMapper(SelectMapper.class);
        Integer count = mapper.count();
        System.out.println(count);
    }
    @Test
    public void testUserToMap(){
        SelectMapper mapper = SqlSessionUtils.getSqlSession().getMapper(SelectMapper.class);
        Map<String, Object> map = mapper.UserToMap(1);
        System.out.println(map);
    }
    @Test
    public void testSelectAll(){
        SelectMapper mapper = SqlSessionUtils.getSqlSession().getMapper(SelectMapper.class);
//        List<Map<String,Object>> list = mapper.selectAll();
        Map<String, Object> map = mapper.selectAll();
        System.out.println(map);
    }
}
