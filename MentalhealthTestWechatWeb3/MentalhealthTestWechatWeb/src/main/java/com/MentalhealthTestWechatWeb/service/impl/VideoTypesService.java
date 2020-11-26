package com.MentalhealthTestWechatWeb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MentalhealthTestWechatWeb.entity.AdminBean;
import com.MentalhealthTestWechatWeb.entity.CartoonanimatsBean;
import com.MentalhealthTestWechatWeb.entity.UserBean;
import com.MentalhealthTestWechatWeb.entity.VideoTypesBean;
import com.MentalhealthTestWechatWeb.mapper.AdminMapper;
import com.MentalhealthTestWechatWeb.mapper.CartoonanimatsMapper;
import com.MentalhealthTestWechatWeb.mapper.UserMapper;
import com.MentalhealthTestWechatWeb.mapper.VideoTypesMapper;
import com.MentalhealthTestWechatWeb.service.IAdminService;
import com.MentalhealthTestWechatWeb.service.ICartoonanimatsService;
import com.MentalhealthTestWechatWeb.service.IUserService;
import com.MentalhealthTestWechatWeb.service.IVideoTypesService;

@Service
public class VideoTypesService implements IVideoTypesService{

	@Autowired
	private VideoTypesMapper mapper;

	@Override
	public List<VideoTypesBean> findAll() {
		// TODO Auto-generated method stub
		return mapper.findAll();
	}

	@Override
	public VideoTypesBean findVideoTypesById(Integer id) {
		// TODO Auto-generated method stub
		return mapper.findVideoTypesById(id);
	}

	@Override
	public List<VideoTypesBean> checkVideoTypes(String vtname) {
		// TODO Auto-generated method stub
		return mapper.checkVideoTypes(vtname);
	}

	@Override
	public void deleteVideoTypesById(Integer id) {
		// TODO Auto-generated method stub
		mapper.deleteVideoTypesById(id);
	}

	@Override
	public void updateVideoTypesInfo(VideoTypesBean videoTypesBean) {
		// TODO Auto-generated method stub
		mapper.updateVideoTypesInfo(videoTypesBean);
	}

	@Override
	public void insertVideoTypesInfo(VideoTypesBean videoTypesBean) {
		// TODO Auto-generated method stub
		mapper.insertVideoTypesInfo(videoTypesBean);
	}


	

	
}
