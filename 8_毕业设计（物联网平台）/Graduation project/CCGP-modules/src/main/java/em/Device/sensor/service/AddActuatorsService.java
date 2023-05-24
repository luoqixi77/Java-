package em.Device.sensor.service;

import em.Device.sensor.Dto.Actuators;

import java.util.List;

/**
 * @author luoqixi77
 * @version V1.0
 * @date 2023/5/10 11:55
 * @Description TODO
 */
public interface AddActuatorsService {

    /**
     * 保存采集器信息
     * @param actuators 采集器信息
     */
    void insertAct(Actuators actuators);

    /**
     * 获取采集器的信息
     * @return 返回对应的采集器信息
     */
    List<Actuators> showAllActuators();

    /**
     * 根据开关名字查询
     * @param actName 开关名字
     * @return 返回对应的开关对象
     */
    Actuators showActuators(String actName);



}
