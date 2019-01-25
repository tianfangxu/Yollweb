package com.yollweb.org.springboot.cloud.sensitive;

import com.yollweb.org.springboot.cloud.domain.model.BaseEntity;

public class SensitiveWord extends BaseEntity<SensitiveWord>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4928364558780854891L;
	
	private Long parentId;//父ID
	private String sensitiveType;//敏感词类型
	private String sensitiveTopic;//敏感词主题
	private String sensitiveWord;//敏感词
	private String status;//敏感词状态
	
	public SensitiveWord() {
		super();
	}
	public SensitiveWord(Long parentId, String sensitiveType, String sensitiveTopic, String sensitiveWord,
			String status) {
		super();
		this.parentId = parentId;
		this.sensitiveType = sensitiveType;
		this.sensitiveTopic = sensitiveTopic;
		this.sensitiveWord = sensitiveWord;
		this.status = status;
	}
	public Long getParentId() {
		return parentId;
	}
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	public String getSensitiveType() {
		return sensitiveType;
	}
	public void setSensitiveType(String sensitiveType) {
		this.sensitiveType = sensitiveType;
	}
	public String getSensitiveTopic() {
		return sensitiveTopic;
	}
	public void setSensitiveTopic(String sensitiveTopic) {
		this.sensitiveTopic = sensitiveTopic;
	}
	public String getSensitiveWord() {
		return sensitiveWord;
	}
	public void setSensitiveWord(String sensitiveWord) {
		this.sensitiveWord = sensitiveWord;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}

