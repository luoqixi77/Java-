package com.meng.spring.service.impl;

import com.meng.spring.dao.BookDao;
import com.meng.spring.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
//@Transactional
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;
    @Override
    public void buyBook(Integer userId, Integer bookId) {
        //查询图书价格
        Integer price=bookDao.updateBookPrice(bookId);
        //更新图书库存
        bookDao.update(bookId);
        //更新用户余额
        bookDao.updateUserPrice(userId,price);
    }
}
