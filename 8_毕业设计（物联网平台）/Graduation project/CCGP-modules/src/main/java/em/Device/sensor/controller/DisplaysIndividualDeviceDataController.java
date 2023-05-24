package em.Device.sensor.controller;

import em.Device.sensor.Dto.DeviceInfoDto;
import em.Device.sensor.Dto.DeviceMessages;
import em.Device.sensor.common.netty.NettySendDataToDevice;
import em.Device.sensor.Dto.SerialDeviceServer;
import em.Device.sensor.service.DisplaysIndividualDeviceInfoService;
import em.Device.sensor.common.utils.Utils;
import em.Device.sensor.service.SerialDeviceServerService;
import gm.common.Return.JwtAuthenticationResponse;
import gm.common.Return.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author luoqixi77
 * @version V1.0
 * @date 2023/4/18 21:59
 * @Description 显示单个设备的信息的Controller层
 */

@RestController
@RequestMapping("/mod/2")
public class DisplaysIndividualDeviceDataController {

    @Autowired
    private SerialDeviceServerService serialDeviceServerService;

    @Autowired
    private DisplaysIndividualDeviceInfoService displaysIndividualDeviceInfoService;

    @Autowired
    private Utils utils;

    @Autowired
    private NettySendDataToDevice nettySendDataToDevice;


    String[] strings;

    /**
     * 处理HTTP请求中的Get请求，获取单个设备的传感信息
     * @param deviceName 前台发来的设备标识，使用其去数据库查询数据
     * @param id 前台传来的串口服务器id
     * @return 返回String类型的数据
     */
    @GetMapping("/device/select/single")
    public ResponseEntity<JwtAuthenticationResponse> displaysDeviceInfo(@RequestParam String deviceName,@RequestParam Integer id) {
        //根据deviceName查询设备信息
        DeviceInfoDto deviceInfo = displaysIndividualDeviceInfoService.getDeviceInfo(deviceName);
        Integer dataStartLocation = deviceInfo.getDataStartLocation();
        //根据id查询串口服务器信息
        SerialDeviceServer serialInfo = serialDeviceServerService.getSerialInfo(id);
        //将设备信息列表转化为DeviceMessages类型的数据
        DeviceMessages deviceMessages = utils.singerDeviceInfoToMessages(deviceInfo);
        strings = nettySendDataToDevice.sendMessageToDevice(deviceMessages, dataStartLocation,serialInfo);
        //返回一个String数组，包含获取的信息
        return ResponseEntity.ok(new JwtAuthenticationResponse(strings, ResultCode.SUCCESS));
    }
}
