package com.DeviceTest.Dto;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @author luoqixi77
 * @version V1.0
 * @date 2023/4/11 8:57
 * @Description TODO
 */
@Data
@Component
public class AddDeviceDto {

    /**
     * 传感名称
     */
    private String name;

    /**
     *标识名
     */
    private String identification;

    /**
     * 地址码
     */
    private String address;

    /**
     * 功能码
     */
    private String function;

    /**
     * 起始地址
     */
    private String startAddress;

    /**
     * 数据长度
     */
    private String register;

}
