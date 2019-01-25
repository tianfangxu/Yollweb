package com.yollweb.org.springboot.cloud.domain.bean;

import java.util.Date;

import com.yollweb.org.springboot.cloud.domain.model.BaseEntity;
import com.yollweb.org.springboot.cloud.mybatis.sqlprovider.annotation.NotColumn;
import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Message extends BaseEntity<Message> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotBlank
	private String app;

	private String assignee;

	//@NotNull
	//@Length(min = 10, max = 256)
	private String title;

	private String summary;

	@NotBlank
	private String content;
	
	private String pushStatus;
	
	
	private java.sql.Timestamp pushDate;
	
	@NotColumn
	private java.sql.Timestamp whereDate;
	
	private String appId;
	
	private String remark;
	
    private String readStatus;
    
    private String emerStatus;
    
    private String packageName;
    
    private String pushtoken;
    
    private String realName;
    
    private Long initiatorId;
    private Long userId;
    private String type;
    private String status;
    
    /**
	 * @return the realName
	 */
	public String getRealName() {
		return realName;
	}

	/**
	 * @param realName the realName to set
	 */
	public void setRealName(String realName) {
		this.realName = realName;
	}

	/**
	 * @return the pushtoken
	 */
	public String getPushtoken() {
		return pushtoken;
	}

	/**
	 * @param pushtoken the pushtoken to set
	 */
	public void setPushtoken(String pushtoken) {
		this.pushtoken = pushtoken;
	}

	/**
	 * @return the packageName
	 */
	public String getPackageName() {
		return packageName;
	}

	/**
	 * @param packageName the packageName to set
	 */
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
    
    @NotBlank
	private String pushType;

	/**
	 * @return the pushType
	 */
	public String getPushType() {
		return pushType;
	}

	/**
	 * @param pushType the pushType to set
	 */
	public void setPushType(String pushType) {
		this.pushType = pushType;
	}

	
	/**
	 * @return the readStatus
	 */
	public String getReadStatus() {
		return readStatus;
	}

	/**
	 * @param readStatus the readStatus to set
	 */
	public void setReadStatus(String readStatus) {
		this.readStatus = readStatus;
	}
	

	/**
	 * @return the remark
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * @param remark the remark to set
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * @return the app
	 */
	public String getApp() {
		return app;
	}

	/**
	 * @param app
	 *            the app to set
	 */
	public void setApp(String app) {
		this.app = app;
	}

	/**
	 * @return the assignee
	 */
	public String getAssignee() {
		return assignee;
	}

	/**
	 * @param assignee
	 *            the assignee to set
	 */
	public void setAssignee(String assignee) {
		this.assignee = assignee;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the summary
	 */
	public String getSummary() {
		return summary;
	}

	/**
	 * @param summary
	 *            the summary to set
	 */
	public void setSummary(String summary) {
		this.summary = summary;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content
	 *            the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return the pushStatus
	 */
	public String getPushStatus() {
		return pushStatus;
	}

	/**
	 * @param pushStatus the pushStatus to set
	 */
	public void setPushStatus(String pushStatus) {
		this.pushStatus = pushStatus;
	}

	/**
	 * @return the pushDate
	 */
	@JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	public java.sql.Timestamp getPushDate() {
		return pushDate;
	}

	/**
	 * @param pushDate the pushDate to set
	 */
	
	public void setPushDate(java.sql.Timestamp pushDate) {
		this.pushDate = pushDate;
	}

	/**
	 * @return the appId
	 */
	public String getAppId() {
		return appId;
	}

	/**
	 * @param appId the appId to set
	 */
	public void setAppId(String appId) {
		this.appId = appId;
	}

	/**
	 * @return the whereDate
	 */
	public java.sql.Timestamp getWhereDate() {
		return whereDate;
	}

	/**
	 * @param whereDate the whereDate to set
	 */
	public void setWhereDate(java.sql.Timestamp whereDate) {
		this.whereDate = whereDate;
	}

	/**
	 * @return the createDate
	 */
	@JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	public Date getCreateDate() {
		return super.getCreateDate();
	}

	/**
	 * @param createDate the createDate to set
	 */
	public void setCreateDate(Date createDate) {
		super.setCreateDate(createDate);
	}

	/**
	 * @return the updateDate
	 */
	@JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	public Date getUpdateDate() {
		return super.getUpdateDate();
	}

	/**
	 * @param updateDate the updateDate to set
	 */
	public void setUpdateDate(Date updateDate) {
		super.setUpdateDate(updateDate);
	}

	/**
	 * @return the emerStatus
	 */
	public String getEmerStatus() {
		return emerStatus;
	}

	/**
	 * @param emerStatus the emerStatus to set
	 */
	public void setEmerStatus(String emerStatus) {
		this.emerStatus = emerStatus;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getInitiatorId() {
		return initiatorId;
	}

	public void setInitiatorId(Long initiatorId) {
		this.initiatorId = initiatorId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
