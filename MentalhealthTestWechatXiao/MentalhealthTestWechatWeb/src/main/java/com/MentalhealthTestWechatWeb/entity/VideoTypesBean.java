package com.MentalhealthTestWechatWeb.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class VideoTypesBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int Vtid;
	private String Vtname;
	
	private int code;
	private String msg;
	private Object obj;
	
	public VideoTypesBean(){
		
	} 
	
	public VideoTypesBean(int code,String msg,Object obj){
		this.code=code;
		this.msg=msg;
		this.obj=obj;
	}
	
	public VideoTypesBean(int code,String msg){
		this.code=code;
		this.msg=msg;
	}
	
	public static VideoTypesBean getJsonResult(int code,String msg,Object obj){
		return new VideoTypesBean(code,msg,obj);
	}
	
	public static VideoTypesBean getJsonResult(int code,String msg){
		return new VideoTypesBean(code,msg);
	}

	public int getVtid() {
		return Vtid;
	}

	public void setVtid(int vtid) {
		Vtid = vtid;
	}

	public String getVtname() {
		return Vtname;
	}

	public void setVtname(String vtname) {
		Vtname = vtname;
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
