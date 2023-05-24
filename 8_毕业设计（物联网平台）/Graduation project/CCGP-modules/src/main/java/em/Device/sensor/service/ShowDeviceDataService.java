package em.Device.sensor.service;

import em.Device.sensor.Dto.DeviceInfoDto;

import java.util.List;

/**
 * @author luoqixi77
 */
public interface ShowDeviceDataService {
    /**
     * 查询数据库中的所有设备信息
     * @return 返回一个list集合包裹的DeviceInfoDto实体类型的数据
     */
    List<DeviceInfoDto> selectDeviceInfo();
}
