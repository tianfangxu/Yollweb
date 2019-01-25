package com.yollweb.org.springboot.cloud.utils;

public class UploadFile {

	private String name;

	private String size;

	private String type;

	private String content;
	
	private String side;//身份证正反面类型:face/back

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSide() {
		return side;
	}

	public void setSide(String side) {
		this.side = side;
	}

	@Override
	public String toString() {
		return "UploadFile [name=" + name + ", size=" + size + ", type=" + type + ", content=" + content + "]";
	}
}
