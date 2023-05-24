package em.Device.sensor.service.serviceImpl;

import em.Device.sensor.Dto.SerialDeviceServer;
import em.Device.sensor.mapper.SerialDeviceServerMapper;
import em.Device.sensor.service.SerialDeviceServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author luoqixi77
 * @version V1.0
 * @date 2023/5/8 9:19
 * @Description TODO
 */
@Service
public class SerialDeviceServerServiceImpl implements SerialDeviceServerService {

    @Autowired
    private SerialDeviceServerMapper serialDeviceServerMapper;

    /**
     * 保存串口服务器的信息
     * @param serialDeviceServer 串口服务器信息
     */
    @Override
    public void insertSerial(SerialDeviceServer serialDeviceServer) {
        serialDeviceServerMapper.insertSerial();
    }

    /**
     * 获取全部的串口服务器信息
     * @return 使用list集合返回查询到的全部串口服务器信息
     */
    @Override
    public List<SerialDeviceServer> showSerial() {
        return serialDeviceServerMapper.showSerial();
    }

    /**
     * 获取特定的串口服务器信息，用于根据相对应的串口服务器连接相对应的设备
     * @param id 串口服务器id
     * @return 返回查询到的特定的串口服务器id
     */
    @Override
    public SerialDeviceServer getSerialInfo(int id) {
        return serialDeviceServerMapper.getSerialInfo(id);
    }
}
