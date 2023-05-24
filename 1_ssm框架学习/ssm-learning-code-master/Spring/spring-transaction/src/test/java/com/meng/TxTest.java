package com.meng;


import com.meng.spring.controller.BookController;
import com.meng.spring.dao.BookDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:tx-annatation.xml")
public class TxTest {
    @Autowired
    private BookController bookController;

    @Test
    public void test_1(){
        bookController.buyBook(1,1);
    }
}
