package com.darling.Dao;

import com.darling.pojo.Store;
import com.darling.vo.StoreVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface StoreMapper {
    /**
     * 更改库存量
     * @param store
     * @return
     */
    int updateTotal(Store store);

    List<Store> findStoreList(StoreVo sv);

    /**
     * 获取设备的库存量
     * @param mid
     * @return
     */
    Integer getTotal(String mid);


    void deleteStore(List<String> list);
}
