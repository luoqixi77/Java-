package em.Device.sensor.Dto;

import lombok.Data;

import javax.persistence.Table;

/**
 * @author luoqixi77
 * @version V1.0
 * @date 2023/5/10 10:14
 * @Description 采集器实体类
 */
@Table(name = "act_info")
@Data
public class Actuators {

    /**
     * 01    05   00   01   FF   00
     * 地址 功能码   端口       开关
     */
    /**
     * 采集器的标识名
     */
    private String actName;
    /**
     * 采集器的设备名
     */
    private String deviceName;
    /**
     * 采集器的地址
     */
    private String actAddress;
    /**
     * 采集器的端口号
     */
    private String registerId1;
    /**
     * 采集器的端口号
     */
    private String registerId2;
    /**
     * 打开设备所对应的报文
     */
    private String openId1;
    /**
     * 打开设备所对应的报文
     */
    private String openId2;
    /**
     * 关闭设备所对应的报文
     */
    private String closeId1;
    /**
     * 关闭设备所对应的报文
     */
    private String closeId2;



}
