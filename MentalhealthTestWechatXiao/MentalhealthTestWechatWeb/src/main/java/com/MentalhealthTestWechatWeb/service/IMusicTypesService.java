package com.MentalhealthTestWechatWeb.service;

import java.util.List;

import com.MentalhealthTestWechatWeb.entity.AdminBean;
import com.MentalhealthTestWechatWeb.entity.CartoonanimatsBean;
import com.MentalhealthTestWechatWeb.entity.MusicTypesBean;
import com.MentalhealthTestWechatWeb.entity.UserBean;
import com.MentalhealthTestWechatWeb.entity.VideoTypesBean;

public interface IMusicTypesService {

	public List<MusicTypesBean> findAll();
	
	public MusicTypesBean findMusicTypesById(Integer id);
	
	public List<MusicTypesBean> checkMusicTypes(String vtname);
	
	public void deleteMusicTypesById(Integer id);
	
	public void updateMusicTypesInfo(MusicTypesBean musicTypesBean);
	
	public void insertMusicTypesInfo(MusicTypesBean musicTypesBean);
	
	
}
 