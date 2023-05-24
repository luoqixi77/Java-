package em.Device.sensor.controller;

import em.Device.sensor.Dto.DeviceInfoDto;
import em.Device.sensor.Dto.DeviceMessages;
import em.Device.sensor.common.netty.NettySendDataToDevice;
import em.Device.sensor.Dto.SerialDeviceServer;
import em.Device.sensor.service.SerialDeviceServerService;
import em.Device.sensor.service.ShowDeviceDataService;
import em.Device.sensor.common.utils.Utils;
import gm.common.Return.JwtAuthenticationResponse;
import gm.common.Return.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author luoqixi77
 * @version V1.0
 * @date 2023/4/17 22:38
 * @Description 展示全部设备信息Controller层
 */
@RestController
@RequestMapping("/mod/5")
public class ShowDeviceDataController {
    @Autowired
    private SerialDeviceServerService serialDeviceServerService;

    @Autowired
    private ShowDeviceDataService showDeviceDataService;

    @Autowired
    private DeviceInfoDto deviceInfoDto;

    @Autowired
    private Utils utils;

    @Autowired
    private NettySendDataToDevice nettySendDataToDevice;

    String[] strings;


    /**
     * 处理Http的Get请求
     * @param id 串口服务器id
     * @return 返回响应实体
     */
    @GetMapping("/device/select/all")
    public ResponseEntity<JwtAuthenticationResponse> showDevices(@RequestParam Integer id) {
        //服务器返回数据时，有效数据的位置
        Integer dataStartLocation = deviceInfoDto.getDataStartLocation();
        //获取设备信息列表
        List<DeviceInfoDto> deviceInfoDtos = showDeviceDataService.selectDeviceInfo();
        //获取串口服务器信息
        SerialDeviceServer serialInfo = serialDeviceServerService.getSerialInfo(id);
        //将设备信息列表转化为DeviceMessages类型的数据
        DeviceMessages deviceMessages = utils.deviceInfoToMessage(deviceInfoDtos);
        strings = nettySendDataToDevice.sendMessageToDevice(deviceMessages, dataStartLocation,serialInfo);
        //返回响应实体
        return ResponseEntity.ok(new JwtAuthenticationResponse(this.strings, ResultCode.SUCCESS));
    }
}
