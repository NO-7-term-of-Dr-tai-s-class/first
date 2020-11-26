package com.MentalhealthTestWechatWeb.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class ProfessionalselftestscoresBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int Psid;
	private int Psuid;
	private int Psscore;
	private Timestamp Psdate;
	
	private String Uname;
	
	private int code;
	private String msg;
	private Object obj;
	
	public ProfessionalselftestscoresBean(){
		
	} 
	
	public ProfessionalselftestscoresBean(int code,String msg,Object obj){
		this.code=code;
		this.msg=msg;
		this.obj=obj;
	}
	
	public ProfessionalselftestscoresBean(int code,String msg){
		this.code=code;
		this.msg=msg;
	}
	
	public static ProfessionalselftestscoresBean getJsonResult(int code,String msg,Object obj){
		return new ProfessionalselftestscoresBean(code,msg,obj);
	}
	
	public static ProfessionalselftestscoresBean getJsonResult(int code,String msg){
		return new ProfessionalselftestscoresBean(code,msg);
	}

	public int getPsid() {
		return Psid;
	}

	public void setPsid(int psid) {
		Psid = psid;
	}

	public int getPsuid() {
		return Psuid;
	}

	public void setPsuid(int psuid) {
		Psuid = psuid;
	}

	public int getPsscore() {
		return Psscore;
	}

	public void setPsscore(int psscore) {
		Psscore = psscore;
	}

	public Timestamp getPsdate() {
		return Psdate;
	}

	public void setPsdate(Timestamp psdate) {
		Psdate = psdate;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
	
	
	
	
	
	
}
