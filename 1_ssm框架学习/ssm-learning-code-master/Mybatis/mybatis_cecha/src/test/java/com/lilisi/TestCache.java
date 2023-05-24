package com.lilisi;

import com.lilisi.Utils.SqlSessionUtils;
import com.lilisi.mapper.CacheMapper;
import com.lilisi.pojo.Emp;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class TestCache {
    /**
     * mybatis的一级缓存：
     * SqlSession级别的，即通过同一个SqlSession查询的数据会被缓存
     * 再次通过同一个SqlSession来查询同一条数据，会从缓存中获取
     */
    @Test
    public void testGetSelectUserById(){
        CacheMapper mapper1 = SqlSessionUtils.getSqlSession().getMapper(CacheMapper.class);
        System.out.println(mapper1.getSelectUserById(1));
        System.out.println(mapper1.getSelectUserById(1));
        CacheMapper mapper2 = SqlSessionUtils.getSqlSession().getMapper(CacheMapper.class);
        System.out.println(mapper2.getSelectUserById(1));
    }
    @Test
    public void testGetSelectUser() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession1 = build.openSession();
        CacheMapper mapper = sqlSession1.getMapper(CacheMapper.class);
        Emp emp1 = mapper.getSelectUserById(5);
        System.out.println(emp1);

        SqlSession sqlSession2 = build.openSession();
        CacheMapper mapper2 = sqlSession1.getMapper(CacheMapper.class);
        Emp emp2 = mapper.getSelectUserById(5);
        System.out.println(emp1);
    }
}
