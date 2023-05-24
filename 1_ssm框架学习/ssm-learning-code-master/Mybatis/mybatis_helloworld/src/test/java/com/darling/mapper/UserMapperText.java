package com.darling.mapper;

import com.darling.pojo.User;
import com.darling.utils.SqlSessionUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


public class UserMapperText {
    @Test
    public void testInsert() throws IOException {
        //获取核心配置文件的输入流
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        //获取SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();
        //获取SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        //获取sql的会话对象SqlSession(默认不直接提交事务，自动提交事务需添加参数true)，是mybatis提供的操作数据库的对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取UserMapper的代理实现类对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //调用mapper接口中的方法，实现添加用户信息的功能
        int i = mapper.insertUser();
        System.out.println(i);
        //提交事务
        sqlSession.commit();
        //关闭会话
        sqlSession.close();
    }

    @Test
    public void testUpdate(){
        //通过SqlSessionUtils工具类获取UserMapper的代理实现类对象
        UserMapper mapper = SqlSessionUtils.getSqlSession().getMapper(UserMapper.class);
        mapper.updateUser();
        SqlSessionUtils.getSqlSession().close();
    }
    @Test
    public void testDelete(){
        UserMapper mapper = SqlSessionUtils.getSqlSession().getMapper(UserMapper.class);
        mapper.deleteUser();
        SqlSessionUtils.getSqlSession().close();
    }

    @Test
    public void testSelectById(){
        UserMapper mapper = SqlSessionUtils.getSqlSession().getMapper(UserMapper.class);
        User user = mapper.selectUserById();
        System.out.println(user);
    }

    @Test
    public void testSelectUserAll(){
        UserMapper mapper = SqlSessionUtils.getSqlSession().getMapper(UserMapper.class);
        List<User> list = mapper.selectUserAll();
        list.forEach(System.out::println);
    }
}
