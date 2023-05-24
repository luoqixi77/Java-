package com.darling.Service.ServiceImpl;

import com.darling.Dao.KindMapper;
import com.darling.Service.KindService;
import com.darling.pojo.Kind;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KindServiceImpl implements KindService {
    @Autowired
    private KindMapper kindMapper;

    /**
     * 查找全部的种类
     *
     * @return
     */
    @Override
    public List<Kind> findAllKind() {
        List<Kind> list = kindMapper.selectAll();
        return list;
    }

    /**
     * 根据id查找某个种类
     *
     * @param kid
     * @return
     */
    @Override
    public Kind findByKid(String kid) {
        Kind kind = kindMapper.selectByKid(kid);
        return kind;
    }

    /**
     * 添加设备类别
     *
     * @param kd
     * @return
     */
    @Override
    public boolean addKind(Kind kd) {
        try {
            int result = kindMapper.addKind(kd);
            if (result > 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
