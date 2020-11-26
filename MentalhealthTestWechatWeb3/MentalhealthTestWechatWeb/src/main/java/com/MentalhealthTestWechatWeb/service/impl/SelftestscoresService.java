package com.MentalhealthTestWechatWeb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MentalhealthTestWechatWeb.entity.AdminBean;
import com.MentalhealthTestWechatWeb.entity.CartoonanimatsBean;
import com.MentalhealthTestWechatWeb.entity.SelftestscoresBean;
import com.MentalhealthTestWechatWeb.entity.UserBean;
import com.MentalhealthTestWechatWeb.entity.VideoTypesBean;
import com.MentalhealthTestWechatWeb.mapper.AdminMapper;
import com.MentalhealthTestWechatWeb.mapper.CartoonanimatsMapper;
import com.MentalhealthTestWechatWeb.mapper.SelftestscoresMapper;
import com.MentalhealthTestWechatWeb.mapper.UserMapper;
import com.MentalhealthTestWechatWeb.mapper.VideoTypesMapper;
import com.MentalhealthTestWechatWeb.service.IAdminService;
import com.MentalhealthTestWechatWeb.service.ICartoonanimatsService;
import com.MentalhealthTestWechatWeb.service.ISelftestscoresService;
import com.MentalhealthTestWechatWeb.service.IUserService;
import com.MentalhealthTestWechatWeb.service.IVideoTypesService;

@Service
public class SelftestscoresService implements ISelftestscoresService{

	@Autowired
	private SelftestscoresMapper mapper;

	@Override
	public List<SelftestscoresBean> findAll() {
		// TODO Auto-generated method stub
		return mapper.findAll();
	}

	@Override
	public SelftestscoresBean findSelftestscoresById(Integer id) {
		// TODO Auto-generated method stub
		return mapper.findSelftestscoresById(id);
	}

	@Override
	public List<SelftestscoresBean> checkSelftestscoresById(Integer id) {
		// TODO Auto-generated method stub
		return mapper.checkSelftestscoresById(id);
	}

	@Override
	public void deleteSelftestscoresById(Integer id) {
		// TODO Auto-generated method stub
		mapper.deleteSelftestscoresById(id);
	}

	@Override
	public void updateSelftestscoresInfo(SelftestscoresBean selftestscoresBean) {
		// TODO Auto-generated method stub
		mapper.updateSelftestscoresInfo(selftestscoresBean);
	}

	@Override
	public void insertSelftestscoresInfo(SelftestscoresBean selftestscoresBean) {
		// TODO Auto-generated method stub
		mapper.insertSelftestscoresInfo(selftestscoresBean);
	}

	

	

	
}
