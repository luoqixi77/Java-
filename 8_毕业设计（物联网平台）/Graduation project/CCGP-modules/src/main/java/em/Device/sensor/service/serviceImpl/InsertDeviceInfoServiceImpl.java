package em.Device.sensor.service.serviceImpl;

import em.Device.sensor.Dto.DeviceInfoDto;
import em.Device.sensor.mapper.InsertDeviceInfoMapper;
import em.Device.sensor.service.InsertDeviceInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author luoqixi77
 * @version V1.0
 * @date 2023/4/17 22:28
 * @Description 保存设备信息Service层
 */
@Service
public class InsertDeviceInfoServiceImpl implements InsertDeviceInfoService {

    @Autowired
    private InsertDeviceInfoMapper insertDeviceInfoMapper;

    /**
     * 保存用户填入的设备信息
     * @param deviceInfoDto 需要保存的设备信息
     */
    @Override
    public void insertDeviceInfo(DeviceInfoDto deviceInfoDto){
        insertDeviceInfoMapper.insertDeviceInfo(deviceInfoDto);
    }
}
