package com.MentalhealthTestWechatWeb.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class VideosBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int Vid;
	private String Vtitle;
	private String Vperformers;
	private String Vscores;
	private int Vtid;
	private String Vjianjie;
	private String Vpath;
	private String Vimg;
	
	private String Vtname;
	
	private int code;
	private String msg;
	private Object obj;
	
	public VideosBean(){
		
	} 
	
	public VideosBean(int code,String msg,Object obj){
		this.code=code;
		this.msg=msg;
		this.obj=obj;
	}
	
	public VideosBean(int code,String msg){
		this.code=code;
		this.msg=msg;
	}
	
	public static VideosBean getJsonResult(int code,String msg,Object obj){
		return new VideosBean(code,msg,obj);
	}
	
	public static VideosBean getJsonResult(int code,String msg){
		return new VideosBean(code,msg);
	}

	public int getVid() {
		return Vid;
	}

	public void setVid(int vid) {
		Vid = vid;
	}

	public String getVtitle() {
		return Vtitle;
	}

	public void setVtitle(String vtitle) {
		Vtitle = vtitle;
	}

	public String getVperformers() {
		return Vperformers;
	}

	public void setVperformers(String vperformers) {
		Vperformers = vperformers;
	}

	public String getVscores() {
		return Vscores;
	}

	public void setVscores(String vscores) {
		Vscores = vscores;
	}

	public int getVtid() {
		return Vtid;
	}

	public void setVtid(int vtid) {
		Vtid = vtid;
	}

	public String getVjianjie() {
		return Vjianjie;
	}

	public void setVjianjie(String vjianjie) {
		Vjianjie = vjianjie;
	}

	public String getVpath() {
		return Vpath;
	}

	public void setVpath(String vpath) {
		Vpath = vpath;
	}

	public String getVimg() {
		return Vimg;
	}

	public void setVimg(String vimg) {
		Vimg = vimg;
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

	public String getVtname() {
		return Vtname;
	}

	public void setVtname(String vtname) {
		Vtname = vtname;
	}
	
	
	
	
	
	
	
	
}
