package com.MentalhealthTestWechatWeb.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class ProfessionalselftestsBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int Psid;
	private String Pstitle;
	private String Psfirtoptions;
	private int Psfirstnum;
	private String Pssecondoptions;
	private int Pssecondnum;
	private String Psthreeoptions;
	private int Psthreenum;
	private String Psfouroptions;
	private int Psfournum;
	private int Psindex;
	
	
	private int code;
	private String msg;
	private Object obj;
	
	public ProfessionalselftestsBean(){
		
	} 
	
	public ProfessionalselftestsBean(int code,String msg,Object obj){
		this.code=code;
		this.msg=msg;
		this.obj=obj;
	}
	
	public ProfessionalselftestsBean(int code,String msg){
		this.code=code;
		this.msg=msg;
	}
	
	public static ProfessionalselftestsBean getJsonResult(int code,String msg,Object obj){
		return new ProfessionalselftestsBean(code,msg,obj);
	}
	
	public static ProfessionalselftestsBean getJsonResult(int code,String msg){
		return new ProfessionalselftestsBean(code,msg);
	}

	
	
	public int getPsindex() {
		return Psindex;
	}

	public void setPsindex(int psindex) {
		Psindex = psindex;
	}

	public int getPsid() {
		return Psid;
	}

	public void setPsid(int psid) {
		Psid = psid;
	}

	public String getPstitle() {
		return Pstitle;
	}

	public void setPstitle(String pstitle) {
		Pstitle = pstitle;
	}

	public String getPsfirtoptions() {
		return Psfirtoptions;
	}

	public void setPsfirtoptions(String psfirtoptions) {
		Psfirtoptions = psfirtoptions;
	}

	public int getPsfirstnum() {
		return Psfirstnum;
	}

	public void setPsfirstnum(int psfirstnum) {
		Psfirstnum = psfirstnum;
	}

	public String getPssecondoptions() {
		return Pssecondoptions;
	}

	public void setPssecondoptions(String pssecondoptions) {
		Pssecondoptions = pssecondoptions;
	}

	public int getPssecondnum() {
		return Pssecondnum;
	}

	public void setPssecondnum(int pssecondnum) {
		Pssecondnum = pssecondnum;
	}

	public String getPsthreeoptions() {
		return Psthreeoptions;
	}

	public void setPsthreeoptions(String psthreeoptions) {
		Psthreeoptions = psthreeoptions;
	}

	public int getPsthreenum() {
		return Psthreenum;
	}

	public void setPsthreenum(int psthreenum) {
		Psthreenum = psthreenum;
	}

	public String getPsfouroptions() {
		return Psfouroptions;
	}

	public void setPsfouroptions(String psfouroptions) {
		Psfouroptions = psfouroptions;
	}

	public int getPsfournum() {
		return Psfournum;
	}

	public void setPsfournum(int psfournum) {
		Psfournum = psfournum;
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
