package cn.itcast.order;


import cn.itcast.feign.clients.UserClients;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@MapperScan("cn.itcast.order.mapper")
@SpringBootApplication
//@EnableFeignClients(basePackages = "cn.itcast.feign.clients")
@EnableFeignClients(clients = {UserClients.class})
public class OrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }

}