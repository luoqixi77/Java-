package em.Device.sensor.service.serviceImpl;

import em.Device.sensor.Dto.Actuators;
import em.Device.sensor.mapper.AddActuatorsMapper;
import em.Device.sensor.service.AddActuatorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author luoqixi77
 * @version V1.0
 * @date 2023/5/10 11:56
 * @Description TODO
 */
@Service
public class AddActuatorsServiceImpl implements AddActuatorsService {

    @Autowired
    private AddActuatorsMapper addActuatorsMapper;

    /**
     * 保存采集器信息
     * @param actuators 采集器信息
     */
    @Override
    public void insertAct(Actuators actuators) {
        addActuatorsMapper.insertAct(actuators);
    }

    /**
     * 查询采集器的信息
     * @return 返回全部的采集器信息
     */
    @Override
    public List<Actuators> showAllActuators() {
        return addActuatorsMapper.showAllActuators();
    }

    /**
     * 根据开关名字查询
     * @param actName 开关名字
     * @return 返回对应的开关对象
     */
    @Override
    public Actuators showActuators(String actName) {
        Actuators actuators = addActuatorsMapper.showActuators(actName);
        if (actuators!=null){
            return actuators;
        }
        return null;
    }
}
