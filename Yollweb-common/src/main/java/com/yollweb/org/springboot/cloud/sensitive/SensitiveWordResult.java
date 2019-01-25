package com.yollweb.org.springboot.cloud.sensitive;

import java.util.Set;

import org.springframework.util.ResourceUtils;

public class SensitiveWordResult {
	
	public SensitiveWordResult() {
		super();
	}
	private String original;//待检测语句
	public static String ILLEGAL_WORD="ILLEGAL_WORD";//"非法语句";
	public static String NORMAL_WORD="NORMAL_WORD";//"正常语句";
	private String status;//待检测语句敏感状态;
	private Set<String> sensitiveWordSet;//敏感词集合
	public String getOriginal() {
		return original;
	}
	public void setOriginal(String original) {
		this.original = original;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Set<String> getSensitiveWordSet() {
		return sensitiveWordSet;
	}
	public void setSensitiveWordSet(Set<String> sensitiveWordSet) {
		this.sensitiveWordSet = sensitiveWordSet;
	}
	public SensitiveWordResult(String original, String status, Set<String> sensitiveWordSet) {
		super();
		this.original = original;
		this.status = status;
		this.sensitiveWordSet = sensitiveWordSet;
	}
	
}

