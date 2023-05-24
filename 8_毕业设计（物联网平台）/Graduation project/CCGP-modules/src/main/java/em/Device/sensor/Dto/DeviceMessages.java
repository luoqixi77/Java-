package em.Device.sensor.Dto;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @author luoqixi77
 * @version V1.0
 * @date 2023/4/18 10:18
 * @Description 设备报文实体类
 */
@Data
@Component
public class DeviceMessages {

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
     * 返回报文中数据结束位置
     */
    private Integer dataLocationLength;
    /**
     * 报文的CRC校验信息+报文信息
     */
    private byte[] crcChecks;

}
