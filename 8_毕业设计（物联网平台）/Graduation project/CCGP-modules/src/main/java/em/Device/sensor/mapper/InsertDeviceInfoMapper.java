package em.Device.sensor.mapper;

import em.Device.sensor.Dto.DeviceInfoDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author luoqixi77
 * @version V1.0
 * @date 2023/4/17 22:19
 * @Description 保存设备信息Mapper层
 */
@Repository
@Mapper
public interface InsertDeviceInfoMapper {
    /**
     * 保存信息
     * @param deviceInfoDto 保存的设备信息
     */
    void insertDeviceInfo(DeviceInfoDto deviceInfoDto);
}
