package com.MentalhealthTestWechatWeb.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class WechatsBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int Wid;
	private int Wuid;
	private String Wcont;
	private Timestamp Wdate;
	
	private String Unicheng;
	
	private int code;
	private String msg;
	private Object obj;
	
	public WechatsBean(){
		
	} 
	
	public WechatsBean(int code,String msg,Object obj){
		this.code=code;
		this.msg=msg;
		this.obj=obj;
	}
	
	public WechatsBean(int code,String msg){
		this.code=code;
		this.msg=msg;
	}
	
	public static WechatsBean getJsonResult(int code,String msg,Object obj){
		return new WechatsBean(code,msg,obj);
	}
	
	public static WechatsBean getJsonResult(int code,String msg){
		return new WechatsBean(code,msg);
	}

	public int getWid() {
		return Wid;
	}

	public void setWid(int wid) {
		Wid = wid;
	}

	public int getWuid() {
		return Wuid;
	}

	public void setWuid(int wuid) {
		Wuid = wuid;
	}

	public String getWcont() {
		return Wcont;
	}

	public void setWcont(String wcont) {
		Wcont = wcont;
	}

	public Timestamp getWdate() {
		return Wdate;
	}

	public void setWdate(Timestamp wdate) {
		Wdate = wdate;
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

	public String getUnicheng() {
		return Unicheng;
	}

	public void setUnicheng(String unicheng) {
		Unicheng = unicheng;
	}


	
	
	
	
	
	
	
}
