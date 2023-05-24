package com.DeviceTest.dao;

import com.DeviceTest.Dto.AddDeviceDto;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author luoqixi77
 * @version V1.0
 * @date 2023/4/12 9:23
 * @Description TODO
 */
@Repository
public interface DeviceDao {
    /**
     * 设备测试中添加设备报文，存储设备
     * @param addDeviceDto 添加的设备信息
     */
    void insertDevice(AddDeviceDto addDeviceDto);

    /**
     * 设备测试中查询设备信息
     * @return 查询到的设备信息
     */
    List<AddDeviceDto> selectDevice();
}
