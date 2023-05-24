package em.Device.sensor.controller;

import em.Device.sensor.Dto.DeviceInfoDto;
import em.Device.sensor.service.DisplaysIndividualDeviceInfoService;
import gm.common.Return.JwtAuthenticationResponse;
import gm.common.Return.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author luoqixi77
 * @version V1.0
 * @date 2023/4/19 8:50
 * @Description 展示设备存储的信息，可以修改设备信息
 */
@RestController
@RequestMapping("/mod/1")
public class DisplayDeviceInfoController {

    @Autowired
    private DisplaysIndividualDeviceInfoService displaysIndividualDeviceInfoService;

    /**
     * 处理HTTP请求的Get请求，获取保存在数据库中的数据信息
     * @param deviceName 前台发来的设备标识，根据标识去查询单个设备的信息
     * @return 如果能够查询到，就返回设备信息和成功状态码，查询不到就返回空码
     */
    @GetMapping("device/select/info")
    public ResponseEntity<JwtAuthenticationResponse> displayDeviceInfo(@RequestParam String deviceName){
        DeviceInfoDto deviceInfo = displaysIndividualDeviceInfoService.getDeviceInfo(deviceName);
        if (deviceInfo == null){
            return ResponseEntity.ok(new JwtAuthenticationResponse(ResultCode.PARAM_IS_BLANK));
        }
        return ResponseEntity.ok(new JwtAuthenticationResponse(deviceInfo,ResultCode.SUCCESS));
    }

    /**
     * 处理HTTP请求的Put请求，更新用户保存的设备信息
     * @param deviceInfo 前台传来的用户更新后的数据
     * @return 更新成功后，会调用查询单个设备的方法，如果更新成功，返回成功码和更新后的设备信息，更新失败会返回错误状态码
     */
    @PutMapping("/device/update/info")
    public ResponseEntity<JwtAuthenticationResponse> updateDeviceInfo(@RequestBody DeviceInfoDto deviceInfo){
        displaysIndividualDeviceInfoService.updateDeviceInfo(deviceInfo);
        DeviceInfoDto newDeviceInfo = displaysIndividualDeviceInfoService.getDeviceInfo(deviceInfo.getDeviceName());
        if (newDeviceInfo!=deviceInfo){
            return ResponseEntity.ok(new JwtAuthenticationResponse(newDeviceInfo,ResultCode.SUCCESS));
        }
        return ResponseEntity.ok(new JwtAuthenticationResponse(ResultCode.COMMON_FAIL));
    }
}
