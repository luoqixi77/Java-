package em.Device.sensor.Dto;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author luoqixi77
 * @version V1.0
 * @date 2023/4/18 9:23
 * @Description 串口服务器ip和端口
 */
@Data
@Entity
@Table(name = "serial_info")
@Component
public class SerialDeviceServer {
    /**
     * 串口服务器的唯一标识id
     */
    @Id
    private Integer id;
    /**
     * 串口服务器IP地址
     */
    private String ip;
    /**
     * 串口服务器端口号
     */
    private Integer port;
}
