package em.Device.sensor;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author luoqixi77
 * @version V1.0
 * @date 2023/4/13 10:46
 * @Description 设备模块启动类
 */
@SpringBootApplication
@MapperScan("em.Device.sensor.mapper")
public class modulesApplication {
    /**
     * 设备测试类主方法
     * @param args 方法参数
     */
    public static void main(String[] args) {
        SpringApplication.run(modulesApplication.class, args);
    }
}
