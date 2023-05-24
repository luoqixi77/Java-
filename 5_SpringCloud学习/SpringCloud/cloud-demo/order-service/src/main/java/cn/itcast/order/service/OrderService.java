package cn.itcast.order.service;


import cn.itcast.feign.clients.UserClients;
import cn.itcast.feign.pojo.User;
import cn.itcast.order.mapper.OrderMapper;
import cn.itcast.order.pojo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private RestTemplate restTemplate;

    @Resource
    private UserClients userClients;

    /**
     * 使用RestTemplate远程调用
     * @param orderId
     * @return
     */
//    public Order queryOrderById(Long orderId) {
//        // 1.查询订单
//        Order order = orderMapper.findById(orderId);
//        // 2.url路径
//        String url="http://userservice/user/" + order.getUserId();
//        // 3.利用RestTemplate发起http请求
//        User user=restTemplate.getForObject(url, User.class);
//        // 4.封装user到order
//        order.setUser(user);
//        // 5.返回
//        return order;
//    }

    /**
     * 使用Feign远程调用
     */
    public Order queryOrderById(Long orderId){
        //查询订单
        Order order = orderMapper.findById(orderId);
        //使用Feign远程调用
        User user = userClients.findById(order.getUserId());
        //封装User到order
        order.setUser(user);
        //返回
        return  order;
    }
}
