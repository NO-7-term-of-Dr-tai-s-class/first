package com.MentalhealthTestWechatWeb.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.MentalhealthTestWechatWeb.entity.AdminBean;
import com.MentalhealthTestWechatWeb.entity.CartoonanimatsBean;
import com.MentalhealthTestWechatWeb.entity.UserBean;
import com.MentalhealthTestWechatWeb.entity.VideoTypesBean;

@Mapper
public interface VideoTypesMapper {
	
	public List<VideoTypesBean> findAll();
	
	public VideoTypesBean findVideoTypesById(Integer id);
	
	public List<VideoTypesBean> checkVideoTypes(String vtname);
	
	public void deleteVideoTypesById(Integer id);
	
	public void updateVideoTypesInfo(VideoTypesBean videoTypesBean);
	
	public void insertVideoTypesInfo(VideoTypesBean videoTypesBean);
	
	

}
 