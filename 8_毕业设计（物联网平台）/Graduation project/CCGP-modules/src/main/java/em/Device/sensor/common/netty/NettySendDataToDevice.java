package em.Device.sensor.common.netty;

import em.Device.sensor.Dto.DeviceMessages;
import em.Device.sensor.Dto.SerialDeviceServer;
import em.Device.sensor.common.utils.Utils;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.InetSocketAddress;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author luoqixi77
 * @version V1.0
 * @date 2023/4/18 22:30
 * @Description 使用Netty向设备发送数据类
 */
@Component
public class NettySendDataToDevice {
    @Autowired
    private Utils utils;

    @Autowired
    private NettyClient nettyClient;

    String[] strings;

    /**
     * 将数据库中获取的设备报文，算出CRC校验码，然后通过轮询的方式向服务器发送数据，并接收服务器返回的数据
     * @param deviceMessages 向设备发送的设备报文
     * @param dataStartLocation 服务器返回报文数据的有效数据起始地址
     * @param serialDeviceServer 串口服务器的相关信息
     * @return 可以直接传给前台的String[]的数据
     */
    public String[] sendMessageToDevice(DeviceMessages deviceMessages, Integer dataStartLocation,SerialDeviceServer serialDeviceServer) {
        //将DeviceMessages数据进行CRC校验，并组成完整的数据报文
        byte[] finalBytes = utils.getDeviceMessages(deviceMessages);
        //创建ByteBuf对象并写入数据
        ByteBuf buffer = Unpooled.buffer();
        ByteBuf byteBuf = buffer.writeBytes(finalBytes);
        //将请求添加到队列中
        nettyClient.addRequest(byteBuf);
        // 创建定时器，每隔五秒执行一次此方法
        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
        InetSocketAddress address = new InetSocketAddress(serialDeviceServer.getIp(), serialDeviceServer.getPort());
        executor.scheduleAtFixedRate(() -> nettyClient.sendNextRequest(address), 0, 5, TimeUnit.SECONDS);
        //接收到服务器返回的数据
        nettyClient.setResponseHandler(msg -> {
            //将返回的数据转化为byte数组
            int i = msg.readableBytes();
            byte[] reBytes = new byte[i];
            msg.readBytes(reBytes);
            //将返回的byte数组做分解，取出有效数据，然后转换为String类型的十进制数据返回
            List<byte[]> bytes = utils.takeOutValidData(dataStartLocation, reBytes);
            strings = utils.listBytesToString(bytes);
        });
        return strings;
    }
}
