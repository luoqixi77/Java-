package com.darling.Service;

import com.darling.pojo.Material;
import com.darling.vo.MaterialVo;

import java.util.List;

public interface MaterialService {
    public boolean addMaterialInfo(Material mi);

    public List<Material> findMaterialInfoListByPage(MaterialVo mv);

    public boolean updateMaterialInfo(Material mi);

    public boolean deleteMaterialInfo(List<String> list);

    public List<Material> findAllMname();
}
