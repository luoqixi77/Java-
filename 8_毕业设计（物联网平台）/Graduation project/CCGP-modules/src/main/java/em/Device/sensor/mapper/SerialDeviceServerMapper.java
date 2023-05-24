package em.Device.sensor.mapper;

import em.Device.sensor.Dto.SerialDeviceServer;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author luoqixi77
 * @version V1.0
 * @date 2023/5/8 10:40
 * @Description 串口服务器的相对应数据库连接操作
 */
@Repository
@Mapper
public interface SerialDeviceServerMapper {

    /**
     * 向数据库添加串口服务器信息
     */
    void insertSerial();

    /**
     * 查询全部的串口服务器信息
     * @return 使用list接收返回的数据
     */
    List<SerialDeviceServer> showSerial();

    /**
     * 根据传来的id查询特定的串口服务器信息
     * @param id 设备id
     * @return 返回查到的信息
     */
    SerialDeviceServer getSerialInfo(int id);
}
