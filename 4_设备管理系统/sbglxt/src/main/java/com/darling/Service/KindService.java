package com.darling.Service;


import com.darling.pojo.Kind;

import java.util.List;

public interface KindService {

    /**
     * 查找全部的种类
     * @return
     */
    public List<Kind> findAllKind();

    /**
     * 根据id查找某个种类
     * @param kid
     * @return
     */
    public Kind findByKid(String kid);

    /**
     * 添加设备类别
     * @param kd
     * @return
     */
    public boolean addKind(Kind kd);
}
