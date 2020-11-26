package com.MentalhealthTestWechatWeb.entity;

import java.sql.Timestamp;

public class UserBean {
	
	private int Uid;
	private String Uname;
	private String Upwd;
	private String Utel;
	private Timestamp Udate;
	private String Usex;
	private int Uage;
	private String Unicheng;
	private String Uimg;
	private String Uopenid;
	
	private int code;
	private String msg;
	private Object obj;
	
	public UserBean(){
		
	} 
	
	public UserBean(int code,String msg,Object obj){
		this.code=code;
		this.msg=msg;
		this.obj=obj;
	}
	
	public UserBean(int code,String msg){
		this.code=code;
		this.msg=msg;
	}
	
	public static UserBean getJsonResult(int code,String msg,Object obj){
		return new UserBean(code,msg,obj);
	}
	
	public static UserBean getJsonResult(int code,String msg){
		return new UserBean(code,msg);
	}

	public int getUid() {
		return Uid;
	}

	public void setUid(int uid) {
		Uid = uid;
	}

	public String getUname() {
		return Uname;
	}

	public void setUname(String uname) {
		Uname = uname;
	}

	public String getUpwd() {
		return Upwd;
	}

	public void setUpwd(String upwd) {
		Upwd = upwd;
	}

	public String getUtel() {
		return Utel;
	}

	public void setUtel(String utel) {
		Utel = utel;
	}

	public Timestamp getUdate() {
		return Udate;
	}

	public void setUdate(Timestamp udate) {
		Udate = udate;
	}

	public String getUsex() {
		return Usex;
	}

	public void setUsex(String usex) {
		Usex = usex;
	}

	public int getUage() {
		return Uage;
	}

	public void setUage(int uage) {
		Uage = uage;
	}

	public String getUnicheng() {
		return Unicheng;
	}

	public void setUnicheng(String unicheng) {
		Unicheng = unicheng;
	}

	public String getUimg() {
		return Uimg;
	}

	public void setUimg(String uimg) {
		Uimg = uimg;
	}

	public String getUopenid() {
		return Uopenid;
	}

	public void setUopenid(String uopenid) {
		Uopenid = uopenid;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}

	
	
	
	
	
	
}
