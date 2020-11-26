package com.MentalhealthTestWechatWeb.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.MentalhealthTestWechatWeb.entity.AdminBean;
import com.MentalhealthTestWechatWeb.entity.CartoonanimatsBean;
import com.MentalhealthTestWechatWeb.entity.MusicTypesBean;
import com.MentalhealthTestWechatWeb.entity.UserBean;

@Mapper
public interface MusicTypesMapper {
	
	public List<MusicTypesBean> findAll();
	
	public MusicTypesBean findMusicTypesById(Integer id);
	
	public List<MusicTypesBean> checkMusicTypes(String vtname);
	
	public void deleteMusicTypesById(Integer id);
	
	public void updateMusicTypesInfo(MusicTypesBean musicTypesBean);
	
	public void insertMusicTypesInfo(MusicTypesBean musicTypesBean);
	
	

}
 