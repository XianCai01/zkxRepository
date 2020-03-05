package com.zkx.item.base;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.github.pagehelper.PageInfo;
import org.springframework.data.domain.Page;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseResponse<T> implements Serializable {

    private static final long serialVersionUID = -3777773098649969969L;

    private String code; //返回状态码
    private String message; //返回信息
    private T data; //返回内容

    /**
     * 成功默认值
     */
    public BaseResponse() {
        this.code = BaseRspCode.SUCCESS.getCode();
        this.message = BaseRspCode.SUCCESS.getMessage();
    }

    /**
     * 自定义message
     *
     * @param code
     * @param message
     */
    public BaseResponse(String code, String message) {
        this.code = code;
        this.message = code + "_" + message;
    }

    public BaseResponse(BaseRspCode comRspCode) {
        this.code = comRspCode.getCode();
        this.message = comRspCode.getCode() + "_" + comRspCode.getMessage();
    }

    /**
     * 返回分页成功数据
     *
     * @param data Page对象
     * @return
     */
    public static BaseResponse pageSuccess(Page data) {
        PageInfo pageInfo = new PageInfo(data.getContent());
        Map<String, Object> result = new HashMap<>();
        result.put("pageSize", pageInfo.getPageSize());
        result.put("totalPage", pageInfo.getPages());
        result.put("total", pageInfo.getTotal());
        result.put("pageNum", pageInfo.getPageNum());
        result.put("list", pageInfo.getList());
        return BaseResponse.success(BaseRspCode.SUCCESS.getCode(), BaseRspCode.SUCCESS.getMessage(), result);
    }

    /**
     * 返回分页成功数据
     *
     * @param list 结果集
     * @return
     */
    public static BaseResponse pageSuccess(List list) {
        PageInfo pageInfo = new PageInfo(list);
        Map<String, Object> result = new HashMap<>();
        result.put("pageSize", pageInfo.getPageSize());
        result.put("totalPage", pageInfo.getPages());
        result.put("total", pageInfo.getTotal());
        result.put("pageNum", pageInfo.getPageNum());
        result.put("list", pageInfo.getList());
        return BaseResponse.success(BaseRspCode.SUCCESS.getCode(), BaseRspCode.SUCCESS.getMessage(), result);
    }

    public static BaseResponse success() {
        BaseResponse re = new BaseResponse();
        return re;
    }

    public static BaseResponse success(String msg) {
        BaseResponse re = new BaseResponse();
        re.setCode(BaseRspCode.SUCCESS.getCode());
        re.setMessage(msg);
        return re;
    }


    public static BaseResponse success(Object data) {
        BaseResponse re = new BaseResponse();
        re.setData(data);
        return re;
    }

    public static BaseResponse success(String code, String message, Object data) {
        BaseResponse re = new BaseResponse(code, message);
        re.setData(data);
        return re;
    }

    public static BaseResponse success(String code, String message) {
        BaseResponse re = new BaseResponse(code, message);
        return re;
    }

    public static BaseResponse info(BaseRspCode enums) {
        BaseResponse re = new BaseResponse(enums.getCode(), enums.getMessage());
        return re;
    }

    public static BaseResponse info(BaseRspCode enums, Object obj) {
        BaseResponse re = new BaseResponse(enums.getCode(), enums.getMessage());
        re.setData(obj);
        return re;
    }

    public static BaseResponse info(String code, String message) {
        BaseResponse re = new BaseResponse(code, message);
        return re;
    }

    public static BaseResponse info(String code, String message, Object obj) {
        BaseResponse re = new BaseResponse(code, message);
        re.setData(obj);
        return re;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
