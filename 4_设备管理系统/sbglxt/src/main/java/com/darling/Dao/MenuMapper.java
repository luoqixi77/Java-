package com.darling.Dao;


import com.darling.pojo.Menu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MenuMapper {
    List<Menu> findMenuList(Integer utype);
}
