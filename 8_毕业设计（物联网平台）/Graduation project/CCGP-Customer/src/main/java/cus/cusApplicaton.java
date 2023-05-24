package cus;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

/**
 * @author luoqixi77
 * @version V1.0
 * @date 2023/3/29 22:29
 * @Description 用户管理操作启动类
 */
@SpringBootApplication(scanBasePackages = {"gm.common.utils","cus"})
@ServletComponentScan
@MapperScan("cus.Mapper")
@EnableWebSecurity
@XmlAccessorType(XmlAccessType.FIELD)
public class cusApplicaton {
    /**
     * 用户模块启动模块主方法
     * @param args 方法参数
     */
    public static void main(String[] args) {
        SpringApplication.run(cusApplicaton.class,args);
    }
}
