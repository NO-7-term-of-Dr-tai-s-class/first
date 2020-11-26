package com.MentalhealthTestWechatWeb.entity;

import java.io.Serializable;

public class AdminBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int Aid;
	private String Aname;
	private String Apwd;
	private String Atel;
	
	private int code;
	private String msg;
	private Object obj;
	
	public AdminBean(){
		
	} 
	
	public AdminBean(int code,String msg,Object obj){
		this.code=code;
		this.msg=msg;
		this.obj=obj;
	}
	
	public AdminBean(int code,String msg){
		this.code=code;
		this.msg=msg;
	}
	
	public static AdminBean getJsonResult(int code,String msg,Object obj){
		return new AdminBean(code,msg,obj);
	}
	
	public static AdminBean getJsonResult(int code,String msg){
		return new AdminBean(code,msg);
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

	public String getAtel() {
		return Atel;
	}
	public void setAtel(String atel) {
		Atel = atel;
	}
	public int getAid() {
		return Aid;
	}
	public void setAid(int aid) {
		Aid = aid;
	}
	public String getAname() {
		return Aname;
	}
	public void setAname(String aname) {
		Aname = aname;
	}
	public String getApwd() {
		return Apwd;
	}
	public void setApwd(String apwd) {
		Apwd = apwd;
	}
	
	
	
	
	
	
}
