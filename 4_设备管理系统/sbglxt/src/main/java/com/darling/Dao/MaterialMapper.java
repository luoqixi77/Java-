package com.darling.Dao;

import com.darling.pojo.Material;
import com.darling.vo.MaterialVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MaterialMapper {

    /**
     * 添加设备信息
     * @param mi
     * @return
     */
    public int addMaterialInfo(Material mi);

    /**
     * 根据条件查找设备信息列表
     * @param mv
     * @return
     */
    public List<Material> selectByConditional(MaterialVo mv);

    /**
     * 修改设备信息
     * @param mi
     * @return
     */
    public int editByMid(Material mi);

    /**
     * 删除设备信息
     * @param list
     */
    public void batchDeleteMaterialInfo(List<String> list);

    /**
     * 获取全部的设备名称
     * @return
     */
    public List<Material> selectAllMname();
}
