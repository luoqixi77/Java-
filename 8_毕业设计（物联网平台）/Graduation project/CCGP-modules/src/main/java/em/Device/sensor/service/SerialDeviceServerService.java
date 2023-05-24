package em.Device.sensor.service;


import em.Device.sensor.Dto.SerialDeviceServer;

import java.util.List;

/**
 * @author luoqixi77
 */
public interface SerialDeviceServerService {
    /**
     * 保存串口服务器信息
     * @param serialDeviceServer 串口服务器信息
     */
    void insertSerial(SerialDeviceServer serialDeviceServer);

    /**
     * 展示串口服务器信息
     * @return 返回串口服务器的实体类
     */
    List<SerialDeviceServer> showSerial();

    /**
     * 根据id查询相对应的串口服务器信息
     * @param id 串口服务器id
     * @return 返回查询到的信息
     */
    SerialDeviceServer getSerialInfo(int id);
}
