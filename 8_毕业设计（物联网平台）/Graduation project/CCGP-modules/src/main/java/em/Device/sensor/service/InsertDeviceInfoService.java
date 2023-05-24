package em.Device.sensor.service;

import em.Device.sensor.Dto.DeviceInfoDto;

/**
 * @author luoqixi77
 */
public interface InsertDeviceInfoService {
    /**
     * 增加设备数据
     * @param deviceInfo 需要保存的实体类数据
     */
    void insertDeviceInfo(DeviceInfoDto deviceInfo);
}
