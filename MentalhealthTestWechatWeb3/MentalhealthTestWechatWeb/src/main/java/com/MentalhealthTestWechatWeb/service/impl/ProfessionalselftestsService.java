package com.MentalhealthTestWechatWeb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MentalhealthTestWechatWeb.entity.AdminBean;
import com.MentalhealthTestWechatWeb.entity.CartoonanimatsBean;
import com.MentalhealthTestWechatWeb.entity.ProfessionalselftestsBean;
import com.MentalhealthTestWechatWeb.entity.SelftestsBean;
import com.MentalhealthTestWechatWeb.entity.UserBean;
import com.MentalhealthTestWechatWeb.entity.VideosBean;
import com.MentalhealthTestWechatWeb.mapper.AdminMapper;
import com.MentalhealthTestWechatWeb.mapper.CartoonanimatsMapper;
import com.MentalhealthTestWechatWeb.mapper.ProfessionalselftestsMapper;
import com.MentalhealthTestWechatWeb.mapper.SelftestsMapper;
import com.MentalhealthTestWechatWeb.mapper.UserMapper;
import com.MentalhealthTestWechatWeb.mapper.VideosMapper;
import com.MentalhealthTestWechatWeb.service.IAdminService;
import com.MentalhealthTestWechatWeb.service.ICartoonanimatsService;
import com.MentalhealthTestWechatWeb.service.IProfessionalselftestsService;
import com.MentalhealthTestWechatWeb.service.ISelftestsService;
import com.MentalhealthTestWechatWeb.service.IUserService;
import com.MentalhealthTestWechatWeb.service.IVideosService;

@Service
public class ProfessionalselftestsService implements IProfessionalselftestsService{

	@Autowired
	private ProfessionalselftestsMapper mapper;

	@Override
	public List<ProfessionalselftestsBean> findAll() {
		// TODO Auto-generated method stub
		return mapper.findAll();
	}

	@Override
	public List<ProfessionalselftestsBean> findIndexProfessionalselftests(Integer index) {
		// TODO Auto-generated method stub
		return mapper.findIndexProfessionalselftests(index);
	}


	

	

	
}
