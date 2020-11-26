package com.MentalhealthTestWechatWeb.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class SelftestsBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int Stid;
	private String Sttitle;
	private String Stfirstoption;
	private int Stfirstnum;
	private String Stsecondoption;
	private int Stsecondnum;
	private String Stthreeoption;
	private int Stthreenum;
	private String Stfouroption;
	private int Stfournum;
	private int Sindex;
	
	
	private int code;
	private String msg;
	private Object obj;
	
	public SelftestsBean(){
		
	} 
	
	public SelftestsBean(int code,String msg,Object obj){
		this.code=code;
		this.msg=msg;
		this.obj=obj;
	}
	
	public SelftestsBean(int code,String msg){
		this.code=code;
		this.msg=msg;
	}
	
	public static SelftestsBean getJsonResult(int code,String msg,Object obj){
		return new SelftestsBean(code,msg,obj);
	}
	
	public static SelftestsBean getJsonResult(int code,String msg){
		return new SelftestsBean(code,msg);
	}

	
	
	public int getSindex() {
		return Sindex;
	}

	public void setSindex(int sindex) {
		Sindex = sindex;
	}

	public int getStid() {
		return Stid;
	}

	public void setStid(int stid) {
		Stid = stid;
	}

	public String getSttitle() {
		return Sttitle;
	}

	public void setSttitle(String sttitle) {
		Sttitle = sttitle;
	}

	public String getStfirstoption() {
		return Stfirstoption;
	}

	public void setStfirstoption(String stfirstoption) {
		Stfirstoption = stfirstoption;
	}

	public int getStfirstnum() {
		return Stfirstnum;
	}

	public void setStfirstnum(int stfirstnum) {
		Stfirstnum = stfirstnum;
	}

	public String getStsecondoption() {
		return Stsecondoption;
	}

	public void setStsecondoption(String stsecondoption) {
		Stsecondoption = stsecondoption;
	}

	public int getStsecondnum() {
		return Stsecondnum;
	}

	public void setStsecondnum(int stsecondnum) {
		Stsecondnum = stsecondnum;
	}

	public String getStthreeoption() {
		return Stthreeoption;
	}

	public void setStthreeoption(String stthreeoption) {
		Stthreeoption = stthreeoption;
	}

	public int getStthreenum() {
		return Stthreenum;
	}

	public void setStthreenum(int stthreenum) {
		Stthreenum = stthreenum;
	}

	public String getStfouroption() {
		return Stfouroption;
	}

	public void setStfouroption(String stfouroption) {
		Stfouroption = stfouroption;
	}

	public int getStfournum() {
		return Stfournum;
	}

	public void setStfournum(int stfournum) {
		Stfournum = stfournum;
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
