package com.darling.Service.ServiceImpl;


import com.darling.Dao.PutinMapper;
import com.darling.Dao.StoreMapper;
import com.darling.Service.PutinService;
import com.darling.pojo.Putin;
import com.darling.pojo.Store;
import com.darling.vo.PutinVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PutinServiceImpl implements PutinService {
    @Autowired
    private PutinMapper putinMapper;

    @Autowired
    private StoreMapper storeMapper;

    /**
     * 设备入库，入库完了还要更新仓库表
     *
     * @param pi
     * @return
     */
    @Override
    public boolean addPutin(Putin pi) {
        try {
            int ires = putinMapper.addPutin(pi);
            Store store = new Store(pi.getMid(), pi.getPaccount());
            int ures = storeMapper.updateTotal(store);
            if (ires > 0 && ures > 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 查询设备入库信息
     *
     * @param pv
     * @return
     */
    @Override
    public List<Putin> findPutinList(PutinVo pv) {
        List<Putin> list = putinMapper.findPutinList(pv);
        return list;
    }
}
