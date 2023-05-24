package com.meng.test;

import com.github.pagehelper.PageHelper;
import com.meng.Utils.SqlSessionUtils;
import com.meng.mapper.EmpMapper;
import com.meng.pojo.Emp;
import org.junit.Test;

import java.util.List;

public class PageTest {
    @Test
    public void testPage(){
        EmpMapper mapper = SqlSessionUtils.getSqlSession().getMapper(EmpMapper.class);
        //查询功能之前开启分页功能
        PageHelper.startPage(1,4);
        List<Emp> list = mapper.selectByExample(null);
        for (Emp emp : list) {
            System.out.println(emp);
        }
    }
}
