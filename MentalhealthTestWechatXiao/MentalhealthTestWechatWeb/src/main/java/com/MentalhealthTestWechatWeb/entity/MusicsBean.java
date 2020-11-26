package com.MentalhealthTestWechatWeb.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class MusicsBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int Mid;
	private String Mtitle;
	private String Msinger;
	private int Mtid;
	private String Mpath;
	private String Mimg;
	
	private String Mtname;
	
	private int code;
	private String msg;
	private Object obj;
	
	public MusicsBean(){
		
	} 
	
	public MusicsBean(int code,String msg,Object obj){
		this.code=code;
		this.msg=msg;
		this.obj=obj;
	}
	
	public MusicsBean(int code,String msg){
		this.code=code;
		this.msg=msg;
	}
	
	public static MusicsBean getJsonResult(int code,String msg,Object obj){
		return new MusicsBean(code,msg,obj);
	}
	
	public static MusicsBean getJsonResult(int code,String msg){
		return new MusicsBean(code,msg);
	}

	public int getMid() {
		return Mid;
	}

	public void setMid(int mid) {
		Mid = mid;
	}

	public String getMtitle() {
		return Mtitle;
	}

	public void setMtitle(String mtitle) {
		Mtitle = mtitle;
	}

	public String getMsinger() {
		return Msinger;
	}

	public void setMsinger(String msinger) {
		Msinger = msinger;
	}

	public int getMtid() {
		return Mtid;
	}

	public void setMtid(int mtid) {
		Mtid = mtid;
	}

	public String getMpath() {
		return Mpath;
	}

	public void setMpath(String mpath) {
		Mpath = mpath;
	}

	public String getMimg() {
		return Mimg;
	}

	public void setMimg(String mimg) {
		Mimg = mimg;
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
