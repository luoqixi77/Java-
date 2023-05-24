package com.DeviceTest.Utils;

import java.nio.charset.StandardCharsets;

/**
 * @author luoqixi77
 * @version V1.0
 * @date 2023/4/11 22:42
 * @Description TODO
 */
public class Utils {
    /**
     * 将String[]转化为byte[]
     * @param data 传入的String[] 数据
     * @return byte[] 数据
     */
    public byte[] StringToByte(String[] data){
        StringBuilder sb = new StringBuilder();
        for (String str : data) {
            sb.append(str);
        }
        String stringToConvert = sb.toString();
        byte[] byteArray = stringToConvert.getBytes(StandardCharsets.UTF_8);
        return byteArray;
    }

    /**
     * 通过报文生成CRC校验
     * @param data 传入的原始报文信息
     * @return 生成的CRC校验码
     */
    public byte[] getCRC(byte[]  data){
        int crc = 0xFFFF;
        // 存储需要产生校验码的数据
        byte[] buf = new byte[data.length];
        byte[] bup = new byte[2];
        for (int i = 0; i < data.length; i++) {
            //数据的复制
            buf[i] = data[i];
        }
        int len = buf.length;
        for (int pos = 0; pos < len; pos++) {
            if (buf[pos] < 0) {
                //^异或:用于位运算，每个位相同为0，不同为1
                crc ^= (int) buf[pos] + 256;

            } else {
                crc ^= (int) buf[pos];
            }
            for (int i = 8; i != 0; i--) {
                if ((crc & 0x0001) != 0) {
                    //右移运算符
                    crc >>= 1;
                    crc ^= 0xA001;
                } else {
                    crc >>= 1;
                }
            }
        }
        String c = Integer.toHexString(crc);
        if (c.length() == 4) {
            c = c.substring(2, 4) + c.substring(0, 2);
        } else if (c.length() == 3) {
            c = "0" + c;
            c = c.substring(2, 4) + c.substring(0, 2);
        } else if (c.length() == 2) {
            c = "0" + c.substring(1, 2) + "0" + c.substring(0, 1);
        }

        bup[0] = (byte) (Integer.parseInt(c.substring(0, 1), 16) + Integer.parseInt(c.substring(1, 2), 16));
        bup[1] = (byte) (Integer.parseInt(c.substring(2, 3), 16) + Integer.parseInt(c.substring(3, 4), 16));

        return bup;
    }
}
