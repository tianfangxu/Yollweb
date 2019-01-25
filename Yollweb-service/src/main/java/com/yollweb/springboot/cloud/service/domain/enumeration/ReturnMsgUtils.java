package com.yollweb.springboot.cloud.service.domain.enumeration;

public class ReturnMsgUtils {

	private int RtnCode;  // code
	private String RtnMsg;  // 提示信息
	private Object content;  // 内容
	
	public int getRtnCode() {
		return RtnCode;
	}
	public void setRtnCode(int rtnCode) {
		RtnCode = rtnCode;
	}
	public String getRtnMsg() {
		return RtnMsg;
	}
	public void setRtnMsg(String rtnMsg) {
		RtnMsg = rtnMsg;
	}
	public Object getContent() {
		return content;
	}
	public void setContent(Object content) {
		this.content = content;
	}
	
	
	
}
