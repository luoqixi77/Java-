package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author luoqixi77
 * @version V1.0
 * @date 2023/3/28 15:06
 * @Description 测试模块启动类
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class ccgptestApplication {
    /**
     * 应用层的启动方法
     * @param args 方法参数
     */
    public static void main(String[] args) {
        SpringApplication.run(ccgptestApplication.class,args);
    }
}
