package com.MentalhealthTestWechatWeb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MentalhealthTestWechatWeb.entity.AdminBean;
import com.MentalhealthTestWechatWeb.entity.CartoonanimatsBean;
import com.MentalhealthTestWechatWeb.entity.MusicTypesBean;
import com.MentalhealthTestWechatWeb.entity.UserBean;
import com.MentalhealthTestWechatWeb.mapper.AdminMapper;
import com.MentalhealthTestWechatWeb.mapper.CartoonanimatsMapper;
import com.MentalhealthTestWechatWeb.mapper.MusicTypesMapper;
import com.MentalhealthTestWechatWeb.mapper.UserMapper;
import com.MentalhealthTestWechatWeb.service.IAdminService;
import com.MentalhealthTestWechatWeb.service.ICartoonanimatsService;
import com.MentalhealthTestWechatWeb.service.IMusicTypesService;
import com.MentalhealthTestWechatWeb.service.IUserService;

@Service
public class MusicTypesService implements IMusicTypesService{

	@Autowired
	private MusicTypesMapper mapper;

	@Override
	public List<MusicTypesBean> findAll() {
		// TODO Auto-generated method stub
		return mapper.findAll();
	}

	@Override
	public MusicTypesBean findMusicTypesById(Integer id) {
		// TODO Auto-generated method stub
		return mapper.findMusicTypesById(id);
	}

	@Override
	public List<MusicTypesBean> checkMusicTypes(String vtname) {
		// TODO Auto-generated method stub
		return mapper.checkMusicTypes(vtname);
	}

	@Override
	public void deleteMusicTypesById(Integer id) {
		// TODO Auto-generated method stub
		mapper.deleteMusicTypesById(id);
	}

	@Override
	public void updateMusicTypesInfo(MusicTypesBean musicTypesBean) {
		// TODO Auto-generated method stub
		mapper.updateMusicTypesInfo(musicTypesBean);
	}

	@Override
	public void insertMusicTypesInfo(MusicTypesBean musicTypesBean) {
		// TODO Auto-generated method stub
		mapper.insertMusicTypesInfo(musicTypesBean);
	}


	

	
}
