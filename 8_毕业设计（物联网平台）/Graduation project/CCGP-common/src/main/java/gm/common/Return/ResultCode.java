package gm.common.Return;

/**
 * @author luoqixi77
 * @version V1.0
 * @date 2023/4/4 15:36
 * @Description 统一状态返回码
 */
public enum ResultCode {
    /**
     * 正确
     */
    SUCCESS(200, "成功"),

    /**
     * 默认失败
     */
    COMMON_FAIL(999, "失败"),

    /**
     * 参数无效：1001
     */
    PARAM_NOT_VALID(1001, "参数无效"),
    /**
     * 参数为空：1002
     */
    PARAM_IS_BLANK(1002, "参数为空"),
    /**
     * 参数类型错误：1003
     */
    PARAM_TYPE_ERROR(1003, "参数类型错误"),
    /**
     * 参数缺失：1004
     */
    PARAM_NOT_COMPLETE(1004, "参数缺失"),

    /**
     * 用户未登录：2001
     */
    USER_NOT_LOGIN(2001, "用户未登录"),
    /**
     * 账号已过期：2002
     */
    USER_ACCOUNT_EXPIRED(2002, "账号已过期"),
    /**
     * 密码错误：2003
     */
    USER_CREDENTIALS_ERROR(2003, "密码错误"),
    /**
     * 密码过期：2004
     */
    USER_CREDENTIALS_EXPIRED(2004, "密码过期"),
    /**
     * 账号不可用：2005
     */
    USER_ACCOUNT_DISABLE(2005, "账号不可用"),
    /**
     * 账号被锁定：2006
     */
    USER_ACCOUNT_LOCKED(2006, "账号被锁定"),
    /**
     * 账号不存在：2007
     */
    USER_ACCOUNT_NOT_EXIST(2007, "账号不存在"),
    /**
     * 账号已存在：2008
     */
    USER_ACCOUNT_ALREADY_EXIST(2008, "账号已存在"),
    /**
     * 账号下线：2009
     */
    USER_ACCOUNT_USE_BY_OTHERS(2009, "账号下线"),

    /**
     * 业务错误
     */
    NO_PERMISSION(3001, "没有权限");

    private Integer code;
    private String message;

    /**
     * 构造方法
     * @param code 状态码
     * @param message 状态信息
     */
    ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 状态码的get方法
     * @return 状态码
     */
    public Integer getCode() {
        return code;
    }
    /**
     * 状态码的set方法
     * @param code 状态码
     */
    public void setCode(Integer code) {
        this.code = code;
    }

    /**
     * 状态信息的get方法
     * @return 状态信息
     */
    public String getMessage() {
        return message;
    }

    /**
     * 状态信息的set方法
     * @param message 状态信息
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * 根据code获取message
     *
     * @param code 状态码
     * @return 状态信息
     */
    public static String getMessageByCode(Integer code) {
        for (ResultCode ele : values()) {
            if (ele.getCode().equals(code)) {
                return ele.getMessage();
            }
        }
        return null;
    }
}

