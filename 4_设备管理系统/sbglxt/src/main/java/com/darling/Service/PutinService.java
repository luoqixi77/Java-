package com.darling.Service;

import com.darling.pojo.Putin;
import com.darling.vo.PutinVo;

import java.util.List;

public interface PutinService {
    public boolean addPutin(Putin pi);

    public List<Putin> findPutinList(PutinVo pv);
}
