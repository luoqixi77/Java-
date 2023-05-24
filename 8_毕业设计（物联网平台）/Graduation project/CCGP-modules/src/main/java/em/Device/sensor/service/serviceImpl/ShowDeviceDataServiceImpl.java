package em.Device.sensor.service.serviceImpl;

import em.Device.sensor.Dto.DeviceInfoDto;
import em.Device.sensor.mapper.ShowDeviceDataMapper;
import em.Device.sensor.service.ShowDeviceDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author luoqixi77
 * @version V1.0
 * @date 2023/4/18 8:26
 * @Description TODO
 */
@Service
public class ShowDeviceDataServiceImpl implements ShowDeviceDataService {

    @Autowired
    private ShowDeviceDataMapper showDeviceDataMapper;

    /**
     * 查询数据库中保存的所有设备信息
     * @return 返回一个list集合的DeviceInfoDto实体类型的数据
     */
    @Override
    public List<DeviceInfoDto> selectDeviceInfo() {
        List<DeviceInfoDto> deviceInfoDtos = showDeviceDataMapper.selectDeviceInfo();
        if (deviceInfoDtos != null && deviceInfoDtos.size() > 0) {
            return deviceInfoDtos;
        }
        return null;
    }
}
