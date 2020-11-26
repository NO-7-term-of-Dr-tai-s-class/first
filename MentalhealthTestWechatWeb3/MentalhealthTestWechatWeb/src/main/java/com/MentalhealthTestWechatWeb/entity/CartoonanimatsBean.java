package com.MentalhealthTestWechatWeb.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class CartoonanimatsBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int Cid;
	private String Ctitle;
	private Timestamp Cdate;
	private String Cpath;
	private String Cjianjie;
	private int Cflag;
	private String Cauthor;
	private String Cimg;
	private String Ccont;
	
	private int code;
	private String msg;
	private Object obj;
	
	public CartoonanimatsBean(){
		
	} 
	
	public CartoonanimatsBean(int code,String msg,Object obj){
		this.code=code;
		this.msg=msg;
		this.obj=obj;
	}
	
	public CartoonanimatsBean(int code,String msg){
		this.code=code;
		this.msg=msg;
	}
	
	public static CartoonanimatsBean getJsonResult(int code,String msg,Object obj){
		return new CartoonanimatsBean(code,msg,obj);
	}
	
	public static CartoonanimatsBean getJsonResult(int code,String msg){
		return new CartoonanimatsBean(code,msg);
	}
	
	
	
	

	public String getCcont() {
		return Ccont;
	}

	public void setCcont(String ccont) {
		Ccont = ccont;
	}

	public String getCimg() {
		return Cimg;
	}

	public void setCimg(String cimg) {
		Cimg = cimg;
	}

	public int getCid() {
		return Cid;
	}

	public void setCid(int cid) {
		Cid = cid;
	}

	public String getCtitle() {
		return Ctitle;
	}

	public void setCtitle(String ctitle) {
		Ctitle = ctitle;
	}

	public Timestamp getCdate() {
		return Cdate;
	}

	public void setCdate(Timestamp cdate) {
		Cdate = cdate;
	}

	public String getCpath() {
		return Cpath;
	}

	public void setCpath(String cpath) {
		Cpath = cpath;
	}

	public String getCjianjie() {
		return Cjianjie;
	}

	public void setCjianjie(String cjianjie) {
		Cjianjie = cjianjie;
	}

	public int getCflag() {
		return Cflag;
	}

	public void setCflag(int cflag) {
		Cflag = cflag;
	}

	public String getCauthor() {
		return Cauthor;
	}

	public void setCauthor(String cauthor) {
		Cauthor = cauthor;
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
