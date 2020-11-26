package com.MentalhealthTestWechatWeb.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class SelftestscoresBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int Ssid;
	private int Ssuid;
	private int Ssscore;
	private Timestamp Ssdate;
	
	private String Uname;
	
	private int code;
	private String msg;
	private Object obj;
	
	public SelftestscoresBean(){
		
	} 
	
	public SelftestscoresBean(int code,String msg,Object obj){
		this.code=code;
		this.msg=msg;
		this.obj=obj;
	}
	
	public SelftestscoresBean(int code,String msg){
		this.code=code;
		this.msg=msg;
	}
	
	public static SelftestscoresBean getJsonResult(int code,String msg,Object obj){
		return new SelftestscoresBean(code,msg,obj);
	}
	
	public static SelftestscoresBean getJsonResult(int code,String msg){
		return new SelftestscoresBean(code,msg);
	}

	
	
	
	public Timestamp getSsdate() {
		return Ssdate;
	}

	public void setSsdate(Timestamp ssdate) {
		Ssdate = ssdate;
	}

	public int getSsid() {
		return Ssid;
	}

	public void setSsid(int ssid) {
		Ssid = ssid;
	}

	public int getSsuid() {
		return Ssuid;
	}

	public void setSsuid(int ssuid) {
		Ssuid = ssuid;
	}

	public int getSsscore() {
		return Ssscore;
	}

	public void setSsscore(int ssscore) {
		Ssscore = ssscore;
	}

	public String getUname() {
		return Uname;
	}

	public void setUname(String uname) {
		Uname = uname;
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
