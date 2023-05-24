package cus.Service;

import cus.pojo.Customer;

import java.util.List;

/**
 * @author luoqixi77
 * @version V1.0
 * @date 2023/5/10 8:45
 * @Description 用户操作的service接口
 */
public interface HomeService {
    /**
     * 获取所有用户的信息
     * @return
     */
    List<Customer> getAllCusInfo();

    /**
     * 根据id查询单个用户信息
     * @param id 查询参数
     * @return Cus实体类
     */
    Customer getSignCusInfo(Integer id);
}
