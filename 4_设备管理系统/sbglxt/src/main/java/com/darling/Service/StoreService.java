package com.darling.Service;

import com.darling.pojo.Store;
import com.darling.vo.StoreVo;

import java.util.List;

public interface StoreService {
//    public boolean add(Store store);
    public List<Store> findStoreList(StoreVo sv);
    public boolean deleteStore(List<String> list);
}
