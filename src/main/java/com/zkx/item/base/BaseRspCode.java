package com.zkx.item.base;

/**
 * @author bohan
 * <p>
 * 目前统一使用11位，前2位为业务线编码，再后3位为系统码，再后2位为系统模块功能码，最后4位为逻辑异常码
 * 错误码
 * 通用的返回码请使用framework中的
 */
public enum BaseRspCode {

	SUCCESS("成功", "200"),
	ERROR("异常", "500"),


	SIGNATURE_FAIL("验签失败", "1010"),
	FORMAT_FAIL("请求数据格式非法", "1011"),
	VERIFY_FAIL("请求数据校验失败", "1012"),
	DATA_NOT_EXIST("数据不存在", "1013"),
	DATA_REPEAT("数据重复", "1014"),
	ROLE_ERROR("权限不足", "1015"),
	PARAM_ERROR("参数不完整", "1016"),
	METHOD_NOT_SUPPORTED("方法不支持", "1017"),

	DB_ERROR("数据库异常", "1020"),
	SYS_TIMEOUT("系统超时", "1021"),
	SYS_ERROR("系统错误", "1022"),
	REDIS_ERROR("缓存异常", "1023"),
	RPC_ERROR("远程调用异常", "1024"),
	CIR_BRE("熔断控制", "1025"),
	MAX_CON("并发控制", "1026"),
	CB_ERROR("熔断错误", "1027"),
	FAILD("失败", "1028"),

	TIMEOUT("连接超时失效", "1030"),
	ILLEGAL_IP("请求IP非法", "1031"),

	ACQUIRE_REDIS_LOCK_ERROR("操作过于频繁", "1040"),
	REDIS_LOCK_OP_ERROR("操作过于频繁", "1041"),
	
	
	NET_WORK_ERROR("网络服务繁忙，请稍候重试", "1051"),
	SAGAS_ROLLBACK_ERROR("网络服务繁忙，请稍后重试", "1052"),

	NoLoginError("未登录异常", "11052");
	
	

	private String code;

	private String message;

	BaseRspCode(String message, String code) {
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	public static BaseRspCode getEnum(String value) {
		BaseRspCode[] crc = BaseRspCode.values();
		for (int i = 0; i < crc.length; i++) {
			if (crc[i].getCode().equals(value)) {
				return crc[i];
			}
		}
		return null;
	}
}
