package com.meng.spring.dao;

public interface BookDao {

    Integer updateBookPrice(Integer bookId);

    void update(Integer bookId);

    void updateUserPrice(Integer userId,Integer price);
}
