package com.DeviceTest.Utils;

/**
 * 回调接口
 * @author 洛琪希77
 */
public interface MessageReceivedCallback {
    /**
     * 回调方法
     * @param reByte 回调方法中的参数
     */
    void onMessageReceived(byte[] reByte);
}
