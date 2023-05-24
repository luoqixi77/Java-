package com.darling.Dao;


import com.darling.pojo.Kind;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface KindMapper {
    /**
     * 查找全部的分类
     * @return
     */
    public List<Kind> selectAll();

    /**
     * 根据id查找某个种类
     * @param kid
     * @return
     */
    public Kind selectByKid(String kid);

    /**
     * 添加设备类别
     * @param kd
     * @return
     */
    public int addKind(Kind kd);
}
