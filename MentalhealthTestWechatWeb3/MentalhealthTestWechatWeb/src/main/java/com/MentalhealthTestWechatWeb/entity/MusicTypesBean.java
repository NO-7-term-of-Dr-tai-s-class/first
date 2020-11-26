package com.MentalhealthTestWechatWeb.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class MusicTypesBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int Mtid;
	private String Mtname;
	
	private int code;
	private String msg;
	private Object obj;
	
	public MusicTypesBean(){
		
	} 
	
	public MusicTypesBean(int code,String msg,Object obj){
		this.code=code;
		this.msg=msg;
		this.obj=obj;
	}
	
	public MusicTypesBean(int code,String msg){
		this.code=code;
		this.msg=msg;
	}
	
	public static MusicTypesBean getJsonResult(int code,String msg,Object obj){
		return new MusicTypesBean(code,msg,obj);
	}
	
	public static MusicTypesBean getJsonResult(int code,String msg){
		return new MusicTypesBean(code,msg);
	}

	public int getMtid() {
		return Mtid;
	}

	public void setMtid(int mtid) {
		Mtid = mtid;
	}

	public String getMtname() {
		return Mtname;
	}

	public void setMtname(String mtname) {
		Mtname = mtname;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
	
	
	
	
}
