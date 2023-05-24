package gm.common.Return;

import java.io.Serializable;


/**
 * @author luoqixi77
 * @version V1.0
 * @date 2023/4/4 8:22
 * @Description
 * @param <T> 数据类型
 * 用于封装返回给前端的JSON数据的类
 */
public class JsonResult<T> implements Serializable {
    /**
     * 是否成功
     */
    private Boolean success;
    /**
     * 状态码
     */
    private Integer code;
    /**
     * 信息
     */
    private String msg;
    /**
     * 数据
     */
    private T data;

    /**
     * 无参构造函数
     */
    public JsonResult() {
    }

    /**
     * 构造函数
     * @param success 是否成功
     */
    public JsonResult(boolean success) {
        this.success = success;
        this.code = success ? ResultCode.SUCCESS.getCode() : ResultCode.COMMON_FAIL.getCode();
        this.msg = success ? ResultCode.SUCCESS.getMessage() : ResultCode.COMMON_FAIL.getMessage();
    }

    /**
     * 构造函数
     * @param success 是否成功
     * @param resultEnum 结果枚举
     */
    public JsonResult(boolean success, ResultCode resultEnum) {
        this.success = success;
        this.code = success ? ResultCode.SUCCESS.getCode() : (resultEnum == null ? ResultCode.COMMON_FAIL.getCode() : resultEnum.getCode());
        this.msg = success ? ResultCode.SUCCESS.getMessage() : (resultEnum == null ? ResultCode.COMMON_FAIL.getMessage() : resultEnum.getMessage());
    }

    /**
     * 构造函数
     * @param success 是否成功
     * @param data 数据
     */
    public JsonResult(boolean success, T data) {
        this.success = success;
        this.code = success ? ResultCode.SUCCESS.getCode() : ResultCode.COMMON_FAIL.getCode();
        this.msg = success ? ResultCode.SUCCESS.getMessage() : ResultCode.COMMON_FAIL.getMessage();
        this.data = data;
    }

    /**
     * 构造函数
     * @param success 是否成功
     * @param resultEnum 结果枚举
     * @param data 数据
     */
    public JsonResult(boolean success, ResultCode resultEnum, T data) {
        this.success = success;
        this.code = success ? ResultCode.SUCCESS.getCode() : (resultEnum == null ? ResultCode.COMMON_FAIL.getCode() : resultEnum.getCode());
        this.msg = success ? ResultCode.SUCCESS.getMessage(): (resultEnum == null ? ResultCode.COMMON_FAIL.getMessage() : resultEnum.getMessage());
        this.data = data;
    }

    /**
     * 获取是否成功
     * @return 是否成功
     */
    public Boolean getSuccess() {
        return success;
    }

    /**
     * 设置是否成功
     * @param success 是否成功
     */
    public void setSuccess(Boolean success) {
        this.success = success;
    }

    /**
     * 获取状态码
     * @return 状态码
     */
    public Integer getErrorCode() {
        return code;
    }

    /**
     * 设置错误码
     * @param code 错误码
     */
    public void setErrorCode(Integer code) {
        this.code = code;
    }

    /**
     * 获取错误信息
     * @return 错误信息
     */
    public String getErrorMsg() {
        return msg;
    }

    /**
     * 设置状态信息
     * @param msg 状态信息
     */
    public void setErrorMsg(String msg) {
        this.msg = msg;
    }

    /**
     * 获取数据
     * @return 数据
     */
    public T getData() {
        return data;
    }

    /**
     * 设置数据
     * @param data 数据
     */
    public void setData(T data) {
        this.data = data;
    }
}
