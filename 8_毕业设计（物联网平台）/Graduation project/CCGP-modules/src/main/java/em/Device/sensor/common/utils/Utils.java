package em.Device.sensor.common.utils;

import em.Device.sensor.Dto.Actuators;
import em.Device.sensor.Dto.DeviceInfoDto;
import em.Device.sensor.Dto.DeviceMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.List;

/**
 * @author luoqixi77
 * @version V1.0
 * @date 2023/4/18 10:28
 * @Description Netty向设备发送信息并接收信息的工具类
 */
@Component
public class Utils {

    @Autowired
    private DeviceMessages deviceMessages;

    /**
     * 将DeviceInfo的数据赋值给DeviceMessages
     * @param deviceInfo 获取的DeviceInfo数据
     * @return 返回一个DeviceMessages数据
     */
    private DeviceMessages getDeviceMessages(DeviceInfoDto deviceInfo) {
        String addressId = deviceInfo.getAddressId();
        String functionId = deviceInfo.getFunctionId();
        String startAddress = deviceInfo.getStartAddress();
        String dataLength = deviceInfo.getDataLength();
        deviceMessages.setAddressId(addressId);
        deviceMessages.setFunctionId(functionId);
        deviceMessages.setStartAddress(startAddress);
        deviceMessages.setDataLength(dataLength);
        return deviceMessages;
    }

    /**
     * 将取出的List集合的DeviceInfoDto信息转化为DeviceMessages类型的数据
     *
     * @param deviceInfoDto 数据库取出的设备信息
     * @return 返回一个DeviceMessages类型的报文信息，不包含CRC校验
     */
    public DeviceMessages deviceInfoToMessage(List<DeviceInfoDto> deviceInfoDto) {
        for (DeviceInfoDto dev : deviceInfoDto) {
            return getDeviceMessages(dev);
        }
        return null;
    }

    /**
     * 将取出的单个设备数据转为DeviceMessages类型的数据
     * @param deviceInfo 从数据库中取出的单个设备的数据
     * @return 返回一个DeviceMessages类型的数据
     */
    public DeviceMessages singerDeviceInfoToMessages(DeviceInfoDto deviceInfo){
        return getDeviceMessages(deviceInfo);
    }



    /**
     * 将DeviceMessages类型的数据转化为byte[]类型，然后进行CRC校验，再将CRC校验添加到byte[]中
     *
     * @param deviceMessages 传入的DeviceMessages报文信息
     * @return 一串完整的设备报文信息，包括CRC校验
     */
    public byte[] getDeviceMessages(DeviceMessages deviceMessages) {
        //将DeviceMessages数据类型转化为byte[]类型，
        byte[] bytes = {Byte.parseByte(deviceMessages.getAddressId()), Byte.parseByte(deviceMessages.getFunctionId()), Byte.parseByte(deviceMessages.getStartAddress()), Byte.parseByte(deviceMessages.getDataLength())};
        //获取改设备报文的CRC校验
        byte[] crc = getCRC(bytes);
        deviceMessages.setCrcChecks(crc);
        //将CRC校验加到数据报文中，形成八帧设备报文
        bytes = new byte[]{Byte.parseByte(deviceMessages.getAddressId()), Byte.parseByte(deviceMessages.getFunctionId()), Byte.parseByte(deviceMessages.getStartAddress()), Byte.parseByte(deviceMessages.getDataLength()), deviceMessages.getCrcChecks()[0], deviceMessages.getCrcChecks()[1]};
        return bytes;
        /**
         * [0x120x120x120x120x12]
         * [0x12,0x12,0x12,0x12]====4
         * [1212121212]
         * [12,12,12,12]
         * 00 00 05 03 03 02
         */
    }


    /**
     * 通过报文生成CRC校验
     *
     * @param data 传入的原始报文信息
     * @return 生成的CRC校验码
     */
    public byte[] getCRC(byte[] data) {
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

    /**
     * 将十六进制的byte[]转化为十进制的String类型数据
     * @param bytes 传入的需要转化的byte[]数据
     * @return 返回十进制的String类型的数据
     */
    public String hexBytesToDecString(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            hexString.append(String.format("%02X", b));
        }
        int num = Integer.parseInt(hexString.toString(), 16);
        return Integer.toString(num);
    }

    /**
     * 将服务器返回的报文根据用户填的有效数据起始地址取出有效数据，然后放到新的byte[]中，用于返回给前台展示数据
     * @param start 用户填写的有效数据起始地址
     * @param bytes 从服务器返回的报文数据
     * @return 返回一个list集合的byte[]
     */
    public List<byte[]> takeOutValidData(Integer start, byte[] bytes) {
        byte[] result1 = new byte[2];
        byte[] result2 = new byte[2];
        byte[] result3 = new byte[2];
        byte[] result4 = new byte[2];
        result1=new byte[]{bytes[start-1],bytes[start]};
        result2=new byte[]{bytes[start+1],bytes[start+2]};
        result3=new byte[]{bytes[start+3],bytes[start+4]};
        result4=new byte[]{bytes[start+5],bytes[start+6]};
        List<byte[]> list = new ArrayList<byte[]>();
        list.add(result1);
        list.add(result2);
        list.add(result3);
        list.add(result4);
        return list;
    }

    /**
     * 将list集合中的byte[]取出并放入String[]，便于传回前台
     * @param list 封装的list集合的byte[]
     * @return 返回一个String[]类型的数据，用于直接返回给前台（已经由十六进制转化为十进制）
     */
    public String[] listBytesToString(List<byte[]> list){
        byte[] bytes1 = list.get(0);
        byte[] bytes2 = list.get(1);
        byte[] bytes3 = list.get(2);
        byte[] bytes4 = list.get(3);
        String s1=null,s2=null,s3=null,s4=null;
        if (bytes1!=null){
             s1 = hexBytesToDecString(bytes1);
        }
        if (bytes2!=null){
             s2 = hexBytesToDecString(bytes2);
        }
        if (bytes3 != null) {
             s3 = hexBytesToDecString(bytes3);
        }
        if (bytes4 != null) {
             s4 = hexBytesToDecString(bytes4);
        }
        String[] strings = {s1, s2, s3, s4};
        return strings;
    }

    /**
     * 打开设备
     * @param actuators 执行器参数
     * @param ip 服务器的ip
     * @param port 服务器端口
     * @throws IOException 连接服务器出错或者设备不存在
     */
    public void actSendOpenMsg(Actuators actuators,String ip,int port) throws IOException {
        String openId1 = actuators.getOpenId1();
        String openId2 = actuators.getOpenId2();
        actSendMsg(actuators,ip,port,openId1,openId2);
    }

    /**
     * 关闭设备
     * @param actuators 执行器参数
     * @param ip 服务器的ip
     * @param port 服务器端口
     * @throws IOException 连接服务器出错或者设备不存在
     */
    public void actSendCloseMsg(Actuators actuators,String ip,int port) throws IOException {
        String closeId1 = actuators.getCloseId1();
        String closeId2 = actuators.getCloseId2();
        actSendMsg(actuators, ip, port, closeId1, closeId2);
    }

    /**
     * 执行器发送socket请求工具类
     * @param actuators 执行器参数
     * @param ip 服务器的ip
     * @param port 服务器端口
     * @param Id1 执行器开关的报文
     * @param Id2 执行器开关的报文
     * @throws IOException 连接服务器出错或者设备不存在
     */
    public void actSendMsg(Actuators actuators,String ip,int port,String Id1,String Id2) throws IOException {
        String actAddress = actuators.getActAddress();
        String registerId1 = actuators.getRegisterId1();
        String registerId2 = actuators.getRegisterId2();
        byte[] bytes={Byte.parseByte(actAddress),0x05, Byte.parseByte(registerId1), Byte.parseByte(registerId2), Byte.parseByte(Id1), Byte.parseByte(Id2)};
        //使用socket向某个设备发送数据
        Socket socket = new Socket(ip, port);
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(bytes);
        socket.close();
    }

}
