package com.MentalhealthTestWechatWeb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MentalhealthTestWechatWeb.entity.AdminBean;
import com.MentalhealthTestWechatWeb.entity.UserBean;
import com.MentalhealthTestWechatWeb.mapper.AdminMapper;
import com.MentalhealthTestWechatWeb.mapper.UserMapper;
import com.MentalhealthTestWechatWeb.service.IAdminService;
import com.MentalhealthTestWechatWeb.service.IUserService;

@Service
public class AdminService implements IAdminService{

	@Autowired
	private AdminMapper mapper;

	@Override
	public AdminBean login(AdminBean st) {
		// TODO Auto-generated method stub
		return mapper.login(st);
	}
 
	@Override
	public List<AdminBean> findAll() {
		// TODO Auto-generated method stub
		return mapper.findAll();
	}

	@Override
	public AdminBean findAdminById(Integer id) {
		// TODO Auto-generated method stub
		return mapper.findAdminById(id);
	}

	@Override
	public void updateAdminInfo(AdminBean adminBean) {
		// TODO Auto-generated method stub
		mapper.updateAdminInfo(adminBean);
	}

	@Override
	public List<AdminBean> findAdminListsById(Integer id) {
		// TODO Auto-generated method stub
		return mapper.findAdminListsById(id);
	}

	

	
}
