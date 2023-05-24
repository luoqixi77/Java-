package com.darling.Service.ServiceImpl;

import com.darling.Dao.MaterialMapper;
import com.darling.Service.MaterialService;
import com.darling.pojo.Material;
import com.darling.vo.MaterialVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialServiceImpl implements MaterialService {

    @Autowired
    private MaterialMapper materialMapper;

    /**
     * 添加设备信息
     *
     * @param mi
     * @return
     */
    @Override
    public boolean addMaterialInfo(Material mi) {
        try {
            int result = materialMapper.addMaterialInfo(mi);
            if (result > 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 根据条件查找设备信息列表
     *
     * @param mv
     * @return
     */
    @Override
    public List<Material> findMaterialInfoListByPage(MaterialVo mv) {
        List<Material> list = materialMapper.selectByConditional(mv);
        return list;
    }

    /**
     * 修改设备信息
     *
     * @param mi
     * @return
     */
    @Override
    public boolean updateMaterialInfo(Material mi) {
        try {
            int result = materialMapper.editByMid(mi);
            if (result > 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 删除设备信息
     *
     * @param list
     * @return
     */
    public boolean deleteMaterialInfo(List<String> list) {
        try {
            materialMapper.batchDeleteMaterialInfo(list);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 获取全部的设备名称
     * @return
     */
    public List<Material> findAllMname() {
        try {
            List<Material> list = materialMapper.selectAllMname();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
