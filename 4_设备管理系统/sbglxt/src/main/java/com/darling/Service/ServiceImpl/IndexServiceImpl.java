package com.darling.Service.ServiceImpl;

import com.darling.Dao.IndexMapper;
import com.darling.Service.IndexService;
import com.darling.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndexServiceImpl implements IndexService {
    @Autowired
    private IndexMapper indexMapper;

    /**
     * 查找用户
     *
     * @param uid
     * @param pwd
     * @return
     */
    @Override
    public User findUser(String uid, String pwd) {
        User user = indexMapper.findUserByUid(uid);
        if (user != null) {
            if (pwd.equals(user.getUpwd())) {
                return user;
            }
        }
        return null;
    }


    /**
     * 获取指定类型的用户
     *
     * @param utype
     * @return
     */
    @Override
    public List<User> getUname(Integer utype) {
        List<User> list = indexMapper.findUserByUtype(utype);
        return list;
    }
}
