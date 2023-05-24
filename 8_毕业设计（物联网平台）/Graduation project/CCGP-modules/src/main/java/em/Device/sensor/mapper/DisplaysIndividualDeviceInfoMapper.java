package em.Device.sensor.mapper;

import em.Device.sensor.Dto.DeviceInfoDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author luoqixi77
 * @version V1.0
 * @date 2023/4/18 22:01
 * @Description 显示单个设备的数据的Mapper层
 */
@Repository
@Mapper
public interface DisplaysIndividualDeviceInfoMapper {
    /**
     * 查询单个设备的相关信息
     * @param deviceName 设备标识名
     * @return 返回一个DeviceInfoDto类型的数据
     */
    DeviceInfoDto selectIndividualDeviceInfo(String deviceName);

    /**
     * 更新设备信息
     * @param deviceInfoDto 传入的新设备信息
     */
    void updateDeviceInfo(DeviceInfoDto deviceInfoDto);
}
