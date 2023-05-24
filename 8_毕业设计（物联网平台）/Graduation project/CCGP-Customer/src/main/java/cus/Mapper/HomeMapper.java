package cus.Mapper;

import cus.pojo.Customer;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author luoqixi77
 * @version V1.0
 * @date 2023/5/10 8:50
 * @Description TODO
 */
@Repository
public interface HomeMapper {
    /**
     * 查询所有用户的数据，密码除外
     * @return 返回list集合的Cus实体类
     */
    List<Customer> getAllCusInfo();

    /**
     * 根据id查询用户信息
     * @param id 查询参数
     * @return Cus实体类
     */
    Customer getSignCusInfo(Integer id);

}
