package em.Device.sensor.mapper;

import em.Device.sensor.Dto.DeviceInfoDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author luoqixi77
 * @version V1.0
 * @date 2023/4/17 22:43
 * @Description 界面显示全部设备Mapper层
 */
@Repository
@Mapper
public interface ShowDeviceDataMapper {
    /**
     * 查询所有设备的所有信息
     * @return 返回一个存储设备实体类的list集合
     */
    List<DeviceInfoDto> selectDeviceInfo();
}
