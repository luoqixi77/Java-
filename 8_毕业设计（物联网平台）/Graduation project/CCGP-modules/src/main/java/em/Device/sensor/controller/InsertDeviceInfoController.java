package em.Device.sensor.controller;

import em.Device.sensor.Dto.DeviceInfoDto;
import em.Device.sensor.service.InsertDeviceInfoService;
import gm.common.Return.JwtAuthenticationResponse;
import gm.common.Return.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author luoqixi77
 * @version V1.0
 * @date 2023/4/17 22:05
 * @Description 保存设备信息Controller层
 */
@RestController
@RequestMapping(("/mod/3"))
public class InsertDeviceInfoController {

    @Autowired
    private InsertDeviceInfoService insertDeviceInfoService;

    /**
     * 保存用户填写的设备信息
     * @param deviceInfo 前台传来的设备信息
     * @return 成功状态码
     */
    @PostMapping("device/insert")
    public ResponseEntity<JwtAuthenticationResponse> insetDevice(@RequestBody DeviceInfoDto deviceInfo) {
        insertDeviceInfoService.insertDeviceInfo(deviceInfo);
        return ResponseEntity.ok(new JwtAuthenticationResponse(ResultCode.SUCCESS));
    }
}
