package cus.Mapper;

import cus.pojo.Customer;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author luoqixi77
 * 登录验证数据库信息
 */
@Mapper
@Repository
public interface LoginMapper {
    /**
     * 根据用户名查询用户的全部信息
     * @param username 用户名
     * @return Customer类型的用户数据
     */
    Customer selectCusByUsername(String username);
}
