package em.Device.sensor.service.serviceImpl;

import em.Device.sensor.Dto.DeviceInfoDto;
import em.Device.sensor.mapper.DisplaysIndividualDeviceInfoMapper;
import em.Device.sensor.service.DisplaysIndividualDeviceInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author luoqixi77
 * @version V1.0
 * @date 2023/4/18 22:06
 * @Description 获取单个设备数据的Service层实现类
 */
@Service
public class DisplaysIndividualDeviceInfoServiceImpl implements DisplaysIndividualDeviceInfoService {

    @Autowired
    private DisplaysIndividualDeviceInfoMapper displaysIndividualDeviceInfoMapper;

    /**
     * 获取单个设备的数据信息
     * @param deviceName 传入的查询条件
     * @return 返回一个DeviceInfoDto类型的实体类
     */
    @Override
    public DeviceInfoDto getDeviceInfo(String deviceName) {
        return displaysIndividualDeviceInfoMapper.selectIndividualDeviceInfo(deviceName);
    }

    /**
     * 更新用户保存的数据信息
     * @param deviceInfo 更新后的数据
     */
    @Override
    public void updateDeviceInfo(DeviceInfoDto deviceInfo) {
        displaysIndividualDeviceInfoMapper.updateDeviceInfo(deviceInfo);
    }
}
