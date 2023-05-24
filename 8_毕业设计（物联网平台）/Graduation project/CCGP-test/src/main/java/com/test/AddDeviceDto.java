package com.test;

import lombok.Data;

/**
 * @author luoqixi77
 * @version V1.0
 * @date 2023/4/11 8:57
 * @Description TODO
 */
@Data
public class AddDeviceDto {

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
     * 寄存器个数
     */
    private String register;

    /**
     * CRC校验
     */
    private String CRCVerify;

    /**
     * ip地址
     */
    private String ip;
}
