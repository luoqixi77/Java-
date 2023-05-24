package com.darling.Dao;

import com.darling.pojo.Putin;
import com.darling.vo.PutinVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface PutinMapper {
    public int addPutin(Putin pi);

    public List<Putin> findPutinList(PutinVo pv);
}
