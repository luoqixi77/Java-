package com.DeviceTest.service;

import com.DeviceTest.Dto.AddDeviceDto;

import java.util.List;

/**
 * @author luoqixi77
 */
public interface DeviceService {
    /**
     * 设备测试中添加设备信息
     * @param addDeviceDto 需要添加的设备信息
     */
    void insertDevice(AddDeviceDto addDeviceDto);

    /**
     * 设备测试中查询设备全部信息
     * @return 返回list集合包裹的全部设备信息
     */
    List<AddDeviceDto> selectDevices();
}
