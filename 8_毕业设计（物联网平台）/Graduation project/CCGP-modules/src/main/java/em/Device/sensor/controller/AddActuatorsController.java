package em.Device.sensor.controller;

import em.Device.sensor.Dto.Actuators;
import em.Device.sensor.service.AddActuatorsService;
import em.Device.sensor.common.utils.Utils;
import em.Device.sensor.Dto.SerialDeviceServer;
import gm.common.Return.JwtAuthenticationResponse;
import gm.common.Return.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.List;

/**
 * @author luoqixi77
 * @version V1.0
 * @date 2023/4/19 15:59
 * @Description 采集器相关操作
 */
@RestController
@RequestMapping("/act")
public class AddActuatorsController {

    @Autowired
    private AddActuatorsService addActuatorsService;

    @Autowired
    private SerialDeviceServer serialDeviceServer;

    @Autowired
    private Utils utils;

    /**
     * 保存采集器信息，保存后会根据设备标识查询，如果查询到，就返回该设备信息，否则返回空
     * @param actuators 前台发来的采集器信息
     * @return 状态码和返回的设备信息
     */
    @PostMapping("/insert")
    public ResponseEntity<JwtAuthenticationResponse> insertAct(@RequestBody Actuators actuators){
        addActuatorsService.insertAct(actuators);
        Actuators actuators1 = addActuatorsService.showActuators(actuators.getActName());
        if (actuators1==null){
            return ResponseEntity.ok(new JwtAuthenticationResponse(ResultCode.PARAM_IS_BLANK));
        }
        return ResponseEntity.ok(new JwtAuthenticationResponse(actuators1,ResultCode.SUCCESS));
    }

    /**
     * 获取所有执行器的信息
     * @return 状态码和执行器信息
     */
    @GetMapping("/showAll")
    public ResponseEntity<JwtAuthenticationResponse> showAll() {
        List<Actuators> actuators = addActuatorsService.showAllActuators();
        if (actuators == null){
            return ResponseEntity.ok(new JwtAuthenticationResponse(ResultCode.PARAM_IS_BLANK));
        }
        return ResponseEntity.ok(new JwtAuthenticationResponse(actuators, ResultCode.SUCCESS));
    }

    /**
     * 打开设备
     * @param actName 采集器标识名
     * @throws IOException 异常
     */
    @GetMapping("/open")
    public void openAct(@RequestParam String actName) throws IOException {
        Actuators actuators = addActuatorsService.showActuators(actName);
        String ip = serialDeviceServer.getIp();
        Integer port = serialDeviceServer.getPort();
        utils.actSendOpenMsg(actuators,ip,port);
    }

    /**
     * 关闭设备
     * @param actName 采集器标识名
     * @throws IOException 异常
     */
    @GetMapping("/close")
    public void closeAct(@RequestParam String actName) throws IOException {
        Actuators actuators = addActuatorsService.showActuators(actName);
        String ip = serialDeviceServer.getIp();
        Integer port = serialDeviceServer.getPort();
        utils.actSendCloseMsg(actuators,ip,port);
    }
//
//    @GetMapping("/tcp")
//    public void tcpp() throws IOException, InterruptedException {
//        String ip="172.18.30.19";
//        int port=502;
//        byte[] bytes1={(byte)0x00,(byte)0x01,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x06,(byte)0x01,(byte)0x05,(byte)0x00,(byte)0x01,(byte)0xFF,(byte)0x00};
//        byte[] bytes2={(byte)0x00,(byte)0x01,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x06,(byte)0x01,(byte)0x05,(byte)0x00,(byte)0x01,(byte)0x00,(byte)0x00};
//        //使用socket向某个设备发送数据
//        while (true){
//            Socket socket = new Socket(ip, port);
//            OutputStream outputStream = socket.getOutputStream();
//            outputStream.write(bytes1);
//            Thread.sleep(1000);
//            outputStream.write(bytes2);
//            socket.close();
//        }
//    }
}
