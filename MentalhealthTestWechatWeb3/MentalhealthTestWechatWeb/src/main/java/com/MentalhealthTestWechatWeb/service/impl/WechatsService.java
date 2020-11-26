package com.MentalhealthTestWechatWeb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MentalhealthTestWechatWeb.entity.AdminBean;
import com.MentalhealthTestWechatWeb.entity.CartoonanimatsBean;
import com.MentalhealthTestWechatWeb.entity.MusicTypesBean;
import com.MentalhealthTestWechatWeb.entity.UserBean;
import com.MentalhealthTestWechatWeb.entity.WechatsBean;
import com.MentalhealthTestWechatWeb.mapper.AdminMapper;
import com.MentalhealthTestWechatWeb.mapper.CartoonanimatsMapper;
import com.MentalhealthTestWechatWeb.mapper.MusicTypesMapper;
import com.MentalhealthTestWechatWeb.mapper.UserMapper;
import com.MentalhealthTestWechatWeb.mapper.WechatsMapper;
import com.MentalhealthTestWechatWeb.service.IAdminService;
import com.MentalhealthTestWechatWeb.service.ICartoonanimatsService;
import com.MentalhealthTestWechatWeb.service.IMusicTypesService;
import com.MentalhealthTestWechatWeb.service.IUserService;
import com.MentalhealthTestWechatWeb.service.IWechatsService;

@Service
public class WechatsService implements IWechatsService{

	@Autowired
	private WechatsMapper mapper;

	@Override
	public List<WechatsBean> findAll() {
		// TODO Auto-generated method stub
		return mapper.findAll();
	}

	@Override
	public List<WechatsBean> checkWechats(WechatsBean wechatsBean) {
		// TODO Auto-generated method stub
		return mapper.checkWechats(wechatsBean);
	}

	@Override
	public void deleteWechatsById(Integer id) {
		// TODO Auto-generated method stub
		mapper.deleteWechatsById(id);
	}

	@Override
	public void insertWechatsInfo(WechatsBean wechatsBean) {
		// TODO Auto-generated method stub
		mapper.insertWechatsInfo(wechatsBean);
	}

	


	

	
}
