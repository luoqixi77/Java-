package cus.config;

import java.io.Serializable;

/**
 * @author luoqixi77
 * @version V1.0
 * @date 2023/4/4 15:36
 * @Description jwt请求类
 */
public class JwtAuthenticationRequest implements Serializable {

    private static final long serialVersionUID = 5926468583005150707L;

    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;

    /**
     * jwt请求类构造器
     */
    public JwtAuthenticationRequest() {
    }

    /**
     * 构造函数
     * @param username 用户名
     * @param password 密码
     */
    public JwtAuthenticationRequest(String username, String password) {
        this.setUsername(username);
        this.setPassword(password);
    }

    /**
     * 获取用户名
     * @return 用户名
     */
    public String getUsername() {
        System.out.println("在请求类中返回username============《《《");
        return this.username;
    }

    /**
     * 设置用户名
     * @param username 用户名
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取密码
     * @return 密码
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * 设置密码
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
