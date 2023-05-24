package com.darling.mapper;

import com.darling.Utils.SqlSessionUtils;
import com.darling.pojo.User;
import org.junit.Test;

import java.util.List;

public class SpecialSqlTest {
    @Test
    public void testSpecialSql(){
        SpecialSql mapper = SqlSessionUtils.getSqlSession().getMapper(SpecialSql.class);
        List<User> list = mapper.SpecialSelect("a");
        for (User user : list) {
            System.out.println(user);
        }
    }
    @Test
    public void testSpecialDelete(){
        SpecialSql mapper = SqlSessionUtils.getSqlSession().getMapper(SpecialSql.class);
        mapper.deletes("4,5");
    }
    @Test
    public void testSelectTableName(){
        SpecialSql mapper = SqlSessionUtils.getSqlSession().getMapper(SpecialSql.class);
        List<User> list = mapper.selectTableName("one_user");
        for (User user : list) {
            System.out.println(user);
        }
    }
    @Test
    public void testInsertUser(){
        SpecialSql mapper = SqlSessionUtils.getSqlSession().getMapper(SpecialSql.class);
        User user = new User(null, "fuluola", "555555", 19, "女", "123@qq.com");
        mapper.insertUser(user);
        System.out.println(user);
    }

}
