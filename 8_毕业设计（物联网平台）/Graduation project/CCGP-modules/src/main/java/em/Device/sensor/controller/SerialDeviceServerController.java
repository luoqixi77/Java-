package em.Device.sensor.controller;

import em.Device.sensor.Dto.SerialDeviceServer;
import em.Device.sensor.service.SerialDeviceServerService;
import gm.common.Return.JwtAuthenticationResponse;
import gm.common.Return.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author luoqixi77
 * @version V1.0
 * @date 2023/5/8 9:11
 * @Description 串口服务器的相关操作controller层
 */
@RestController
@RequestMapping("/mod/4")
public class SerialDeviceServerController {

    @Autowired
    SerialDeviceServerService serialDeviceServerService;

    /**
     * 保存串口服务器的信息
     * @param serialDeviceServer 前台传来的串口服务器的信息参数
     * @return 返回正确状态码
     */
    @PostMapping("/Serial/insert")
    public ResponseEntity<JwtAuthenticationResponse> insertSerialServer(@RequestBody SerialDeviceServer serialDeviceServer) {
        serialDeviceServerService.insertSerial(serialDeviceServer);
        return ResponseEntity.ok(new JwtAuthenticationResponse(ResultCode.SUCCESS));
    }

    /**
     * 展示串口服务器的信息
     * @return list集合类型的串口服务器信息
     */
    @GetMapping("/Serial/show")
    public ResponseEntity<JwtAuthenticationResponse> showSerialServer(){
        List<SerialDeviceServer> serialDeviceServers = serialDeviceServerService.showSerial();
        if (serialDeviceServers == null) {
            return ResponseEntity.ok(new JwtAuthenticationResponse(ResultCode.PARAM_IS_BLANK));
        }
        return ResponseEntity.ok(new JwtAuthenticationResponse(serialDeviceServers,ResultCode.SUCCESS));
    }
}
