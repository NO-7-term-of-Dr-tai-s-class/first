package com.MentalhealthTestWechatWeb.entity;

import java.sql.Timestamp;

public class UserAjaxBean {
	
	private String uid;
	private String uname;
	private String utel;
	private String sex;
	private String utype;
	private String umarry;
	private String age = "0";
	private String shen;
	private String edus;
	 
	
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUtel() {
		return utel;
	}
	public void setUtel(String utel) {
		this.utel = utel;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getUtype() {
		return utype;
	}
	public void setUtype(String utype) {
		this.utype = utype;
	}
	public String getUmarry() {
		return umarry;
	}
	public void setUmarry(String umarry) {
		this.umarry = umarry;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getShen() {
		return shen;
	}
	public void setShen(String shen) {
		this.shen = shen;
	}
	public String getEdus() {
		return edus;
	}
	public void setEdus(String edus) {
		this.edus = edus;
	}
	
	
	
}