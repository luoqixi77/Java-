package em.Device.sensor.service;

import em.Device.sensor.Dto.DeviceInfoDto;

/**
 * @author luoqixi77
 */
public interface DisplaysIndividualDeviceInfoService {
    /**
     * 获取单个设备的信息
     * @param deviceName 查询条件
     * @return 返回设备实体类
     */
    DeviceInfoDto getDeviceInfo(String deviceName);

    /**
     * 更新用户已经保存的设备信息
     * @param deviceInfo 更新后的数据
     */
    void updateDeviceInfo(DeviceInfoDto deviceInfo);
}
