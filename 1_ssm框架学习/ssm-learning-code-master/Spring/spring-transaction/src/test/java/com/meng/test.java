package com.meng;

import com.meng.spring.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

//指定当前测试类在Spring环境中执行，此时就可以通过注入的方式直接获取IOC容器中bean
@RunWith(SpringJUnit4ClassRunner.class)
//设置Spring测试环境中的配置文件
@ContextConfiguration("classpath:spring-jdbc.xml")
public class test {

    @Autowired
    private JdbcTemplate jdbcTemplate;
@Test
    public void test_1(){
    String sql="insert into one_user values(null,?,?,?,?,?)";
    jdbcTemplate.update(sql,"darling","222222",23,"女","23333@33.com");
}

    @Test
//查询一条数据为一个实体类对象
    public void testSelectEmpById(){
        String sql = "select * from one_user where id = ?";
        User emp = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>
                (User.class), 1);
        System.out.println(emp);
    }

    @Test
    //查询多条数据为一个list集合
    public void testSelectList(){
        String sql = "select * from one_user";
        List<User> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>
                (User.class));
        list.forEach(emp -> System.out.println(emp));
    }


    @Test
//查询单行单列的值
    public void selectCount(){
        String sql = "select count(id) from one_user";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
        System.out.println(count);
    }

}
