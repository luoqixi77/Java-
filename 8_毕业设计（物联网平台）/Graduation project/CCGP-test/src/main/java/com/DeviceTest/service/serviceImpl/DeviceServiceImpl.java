package com.DeviceTest.service.serviceImpl;

import com.DeviceTest.Dto.AddDeviceDto;
import com.DeviceTest.dao.DeviceDao;
import com.DeviceTest.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author luoqixi77
 * @version V1.0
 * @date 2023/4/12 9:22
 * @Description TODO
 */
@Service
public class DeviceServiceImpl implements DeviceService {

    @Autowired
    private DeviceDao deviceDao;

    @Override
    public void insertDevice(AddDeviceDto addDeviceDto) {
        deviceDao.insertDevice(addDeviceDto);
    }

    @Override
    public List<AddDeviceDto> selectDevices() {
        List<AddDeviceDto> list = deviceDao.selectDevice();
        if (list != null && list.size() > 0) {
            return list;
        }
        return null;
    }
}
