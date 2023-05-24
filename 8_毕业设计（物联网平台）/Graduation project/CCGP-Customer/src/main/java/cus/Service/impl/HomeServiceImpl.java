package cus.Service.impl;

import cus.Mapper.HomeMapper;
import cus.Service.HomeService;
import cus.pojo.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author luoqixi77
 * @version V1.0
 * @date 2023/5/10 8:49
 * @Description TODO
 */
@Service
public class HomeServiceImpl implements HomeService {

    @Autowired
    private HomeMapper homeMapper;

    @Override
    public List<Customer> getAllCusInfo() {
        List<Customer> allCusInfo = homeMapper.getAllCusInfo();
        if (allCusInfo!=null){
            return allCusInfo;
        }
        return null;
    }

    @Override
    public Customer getSignCusInfo(Integer id) {
        Customer signCusInfo = homeMapper.getSignCusInfo(id);
        if (signCusInfo!=null){
            return signCusInfo;
        }
        return null;
    }
}
