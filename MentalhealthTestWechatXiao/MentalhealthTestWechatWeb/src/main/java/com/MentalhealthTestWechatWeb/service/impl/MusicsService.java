package com.MentalhealthTestWechatWeb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MentalhealthTestWechatWeb.entity.AdminBean;
import com.MentalhealthTestWechatWeb.entity.CartoonanimatsBean;
import com.MentalhealthTestWechatWeb.entity.MusicsBean;
import com.MentalhealthTestWechatWeb.entity.UserBean;
import com.MentalhealthTestWechatWeb.mapper.AdminMapper;
import com.MentalhealthTestWechatWeb.mapper.CartoonanimatsMapper;
import com.MentalhealthTestWechatWeb.mapper.MusicsMapper;
import com.MentalhealthTestWechatWeb.mapper.UserMapper;
import com.MentalhealthTestWechatWeb.service.IAdminService;
import com.MentalhealthTestWechatWeb.service.ICartoonanimatsService;
import com.MentalhealthTestWechatWeb.service.IMusicsService;
import com.MentalhealthTestWechatWeb.service.IUserService;

@Service
public class MusicsService implements IMusicsService{

	@Autowired
	private MusicsMapper mapper;

	@Override
	public List<MusicsBean> findAll() {
		// TODO Auto-generated method stub
		return mapper.findAll();
	}

	@Override
	public MusicsBean findMusicsById(Integer id) {
		// TODO Auto-generated method stub
		return mapper.findMusicsById(id);
	}

	@Override
	public void deleteMusicsById(Integer id) {
		// TODO Auto-generated method stub
		mapper.deleteMusicsById(id);
	}

	@Override
	public void updateMusicsInfo(MusicsBean musicsBean) {
		// TODO Auto-generated method stub
		mapper.updateMusicsInfo(musicsBean);
	}

	@Override
	public void insertMusicsInfo(MusicsBean musicsBean) {
		// TODO Auto-generated method stub
		mapper.insertMusicsInfo(musicsBean);
	}

	@Override
	public List<MusicsBean> findMusicsListsByVtid(Integer id) {
		// TODO Auto-generated method stub
		return mapper.findMusicsListsByVtid(id);
	}

	@Override
	public List<MusicsBean> checkMusics(MusicsBean musicsBean) {
		// TODO Auto-generated method stub
		return mapper.checkMusics(musicsBean);
	}

	@Override
	public List<MusicsBean> findMusicsListsByMohuTitle(String vtitle) {
		// TODO Auto-generated method stub
		return mapper.findMusicsListsByMohuTitle(vtitle);
	}

	

	

	
}
