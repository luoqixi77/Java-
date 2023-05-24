package cus.Service;

import cus.Mapper.LoginMapper;
import cus.pojo.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
  @author luoqixi77
 * @version V1.0
 * @date 2023/4/4 11:19
 * @Description 获取用户信息服务
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private LoginMapper loginMapper;

    /**
     * 通过用户名加载用户信息
     * @param username 用户名
     * @return 用户信息
     * @throws UsernameNotFoundException 用户不存在异常
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Customer cus = loginMapper.selectCusByUsername(username);
        System.out.println("cus---------------->"+cus);
        if (cus == null) {
            throw new UsernameNotFoundException("User not found");
        }
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(cus.getRole()));
        if ("1".equals(cus.getRole())){
            return new org.springframework.security.core.userdetails.User(
                    cus.getUsername(), cus.getPassword(), true, true,
                    true, true, authorities);
        }else {
            return new User(  cus.getUsername(), cus.getPassword(), false, true,
                    true, true, authorities);
        }
    }
}
