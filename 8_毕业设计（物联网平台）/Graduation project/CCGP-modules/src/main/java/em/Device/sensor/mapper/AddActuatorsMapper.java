package em.Device.sensor.mapper;

import em.Device.sensor.Dto.Actuators;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author luoqixi77
 * @version V1.0
 * @date 2023/5/10 11:57
 * @Description TODO
 */
@Repository
@Mapper
public interface AddActuatorsMapper {

    /**
     * 保存采集器信息
     * @param actuators 采集器信息
     */
    void insertAct(Actuators actuators);

    /**
     * 获取采集器列表
     * @return list集合封装的采集器信息
     */
    List<Actuators> showAllActuators();

    /**
     * 根据开关名字查询
     * @param actName 开关名字
     * @return 返回对应的开关对象
     */
    Actuators showActuators(String actName);

}
