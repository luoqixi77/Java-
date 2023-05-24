package cus.pojo;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author luoqixi77
 * @version V1.0
 * @date 2023/3/29 10:21
 * @Description Customer实体类
 */
@Data
public class Customer {
    private Integer id;

    private String username;

    private String password;

    private String role;

    private String state;

    private String email;

}
