package em.Device.sensor.Dto;

import lombok.Data;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import javax.persistence.Table;

/**
 * @author luoqixi77
 * @version V1.0
 * @date 2023/4/17 22:06
 * @Description 设备信息实体类
 */
@Data
@Component
@Table(name = "device_info")
public class DeviceInfoDto {

    /**
     * 设备标识（唯一且不能更改）
     */
    private String deviceName;
    /**
     * 设备地址
     */
    private String addressId;
    /**
     * 设备功能码
     */
    private String functionId;
    /**
     * 数据起始地址
     */
    private String startAddress;
    /**
     * 数据长度
     */
    private String dataLength;
    /**
     * 返回报文中数据起始位置
     */
    private Integer dataStartLocation;
    /**
     * 返回报文中数据有效长度
     */
    @Nullable
    private Integer dataLocationLength;
    /**
     * （传感器）采样公式，可以为空
     */
    @Nullable
    private String samplingFormula;

}
