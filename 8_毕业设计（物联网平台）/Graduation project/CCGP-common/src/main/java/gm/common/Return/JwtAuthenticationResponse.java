package gm.common.Return;

import java.io.Serializable;

/**
 * @author luoqixi77
 * @version V1.0
 * @date 2023/4/4 15:36
 * @Description jwt响应类
 */
public class JwtAuthenticationResponse<T> implements Serializable {

    private static final long serialVersionUID = -5577579081118070434L;

    /**
     * 响应数据
     */
    private T data;

    /**
     * 认证token
     */
    private String token;

    /**
     * 响应状态码
     */
    private ResultCode code;

    /**
     * 构造函数
     * @param data 响应数据
     * @param token 认证token
     * @param code 响应状态码
     */
    public JwtAuthenticationResponse(T data,String token,ResultCode code){
        this.data=data;
        this.token=token;
        this.code=code;
    }

    /**
     * 构造函数
     * @param token 认证token
     * @param code 响应状态码
     */
    public JwtAuthenticationResponse(String token,ResultCode code) {
        this.token = token;
        this.code=code;
    }

    /**
     * 构造函数
     * @param data 返回数据
     * @param code 响应状态码
     */
    public JwtAuthenticationResponse(T data,ResultCode code){
        this.data = data;
        this.code = code;
    }

    /**
     * 构造函数
     * @param code 响应状态码
     */
    public JwtAuthenticationResponse(ResultCode code) {
        this.code=code;
    }

    /**
     * 获取认证token
     * @return 认证token
     */
    public String getToken() {
        return this.token;
    }

    /**
     * 获取响应数据
     * @return 响应数据
     */
    public T getData(){
        return this.data;
    }

    /**
     * 获取响应状态码
     * @return 响应状态码
     */
    public ResultCode getCode(){
        return this.code;
    }

    /**
     * 设置响应数据
     * @param data 响应数据
     */
    public void setData(T data) {
        this.data = data;
    }

    /**
     * 设置认证token
     * @param token 认证token
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * 设置响应状态码
     * @param code 响应状态码
     */
    public void setCode(ResultCode code){
        this.code = code;
    }
}
