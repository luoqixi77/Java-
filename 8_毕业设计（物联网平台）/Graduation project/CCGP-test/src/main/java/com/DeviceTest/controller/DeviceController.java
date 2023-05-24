package com.DeviceTest.controller;

import com.DeviceTest.Utils.Utils;
import com.DeviceTest.Dto.AddDeviceDto;
import gm.common.Return.JwtAuthenticationResponse;
import gm.common.Return.ResultCode;
import com.DeviceTest.Handler.MyClientHandler;
import com.DeviceTest.Utils.MessageReceivedCallback;
import com.DeviceTest.service.DeviceService;
import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;

/**
 * @author luoqixi77
 * @version V1.0
 * @date 2023/4/11 20:54
 * @Description 增加设备
 */
@RestController("/test")
public class DeviceController implements MessageReceivedCallback {

    @Autowired
    private DeviceService deviceService;

    private byte[] receivedByte;

    private String ip;

    private int port;

    /**
     * 利用报文增加设备
     *
     * @param adddeviceDto 设备实体
     * @param ips 410s的IP地址
     * @param ports 410s的端口号
     * @return 设备实体信息和成功码200
     * @throws InterruptedException 异常
     */
    @PostMapping("/device/add")
    public ResponseEntity<JwtAuthenticationResponse> addDevice(@RequestBody AddDeviceDto adddeviceDto, @RequestParam String ips, @RequestParam int ports) throws InterruptedException {
        ip = ips;
        port = ports;
        deviceService.insertDevice(adddeviceDto);
        return ResponseEntity.ok().body(new JwtAuthenticationResponse(adddeviceDto, ResultCode.SUCCESS));
    }

    @Override
    public void onMessageReceived(byte[] reByte) {
        receivedByte = reByte;
    }

    /**
     * 查询所有的设备报文，获取到CRC校验后发送到设备端，实现显示数据
     * @return 成功返回一个200状态码+显示数据的10进制报文信息
     * @throws InterruptedException 抛出异常
     */
    @GetMapping("/device/view")
    public ResponseEntity<JwtAuthenticationResponse> showView() throws InterruptedException {
        List<AddDeviceDto> addDeviceDtos = deviceService.selectDevices();
        //将list集合的addDeviceDtos里面的报文一个个取出，分别放到byte[]中
        Utils utils = new Utils();
        Bootstrap bootstrap = new Bootstrap();
        ArrayList<String[]> list = new ArrayList<>();
        for (AddDeviceDto adddeviceDto : addDeviceDtos) {
            //每一次for循环取出实体类类型的集合中的一个元素，放到string[]数组中，然后转为byte[]发送出去
            String[] strings = {adddeviceDto.getAddress(), adddeviceDto.getFunction(), adddeviceDto.getStartAddress(), adddeviceDto.getRegister()};
            byte[] bytes = utils.StringToByte(strings);
            byte[] crc = utils.getCRC(bytes);
            byte[] finalByte = {bytes[0], bytes[1], bytes[2], bytes[3], crc[0], crc[1]};
            ByteBuf buf = Unpooled.wrappedBuffer(finalByte);
            //创建netty客户端bootstrap
            bootstrap
                    .group(new NioEventLoopGroup())
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<>() {
                        @Override
                        protected void initChannel(Channel ch) {
                            ch.pipeline().addLast(new MyClientHandler(buf));
                        }
                    });
            //创建连接
            Channel channel = bootstrap.connect(new InetSocketAddress(ip, port))
                    .sync()
                    .channel();
            //将报文的第5位和第6位取出
            byte a = receivedByte[4];
            byte b = receivedByte[5];
            //取出的报文为hex文件，需要转为十进制
            String rea = Integer.toString(Integer.parseInt(String.format("%02x", a), 16));
            String reb = Integer.toString(Integer.parseInt(String.format("%02x", b), 16));
            String[] strings1 = {rea, reb};
            list.add(strings1);
            if (receivedByte.length==0){
                //关闭客户端连接
                channel.close();
            }
        }
        //返回数据和成功状态码
        return ResponseEntity.ok(new JwtAuthenticationResponse(list,ResultCode.SUCCESS));
    }
}
