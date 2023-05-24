package com.darling.Service.ServiceImpl;


import com.darling.Dao.StoreMapper;
import com.darling.Service.StoreService;
import com.darling.pojo.Store;
import com.darling.vo.StoreVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreServiceImpl implements StoreService {
    @Autowired
    private StoreMapper storeMapper;

//    @Override
//    public boolean add(Store store) {
//        try {
//            int result = storeMapper.add(store);
//            if (result > 0) {
//                return true;
//            }
//            return false;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
//    }

    /**
     * 查询库存
     * @param sv
     * @return
     */
    @Override
    public List<Store> findStoreList(StoreVo sv) {
        try {
            return storeMapper.findStoreList(sv);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean deleteStore(List<String> list) {
        try {
            storeMapper.deleteStore(list);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
