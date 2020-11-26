package com.MentalhealthTestWechatWeb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MentalhealthTestWechatWeb.entity.UserBean;
import com.MentalhealthTestWechatWeb.mapper.UserMapper;
import com.MentalhealthTestWechatWeb.service.IUserService;

@Service
public class UserService implements IUserService {

	@Autowired
	private UserMapper mapper;

	@Override
	public UserBean login(UserBean user) {
		// TODO Auto-generated method stub
		return mapper.login(user);
	}

	@Override
	public List<UserBean> findAll() {
		// TODO Auto-generated method stub
		return mapper.findAll();
	}
 
	@Override 
	public List<UserBean> findUsersByTel(UserBean user) {
		// TODO Auto-generated method stub
		return mapper.findUsersByTel(user);
	}

	@Override
	public List<UserBean> CheckUser(UserBean user) {
		// TODO Auto-generated method stub
		return mapper.CheckUser(user);
	}

	@Override
	public UserBean findUsersById(Integer uid) {
		// TODO Auto-generated method stub
		return mapper.findUsersById(uid);
	}

	@Override
	public void deleteUsersById(Integer uid) {
		// TODO Auto-generated method stub
		mapper.deleteUsersById(uid);
	}

	@Override
	public void updateUserInfo(UserBean user) {
		// TODO Auto-generated method stub
		mapper.updateUserInfo(user);
	}

	@Override
	public void insertUser(UserBean user) {
		// TODO Auto-generated method stub
		mapper.insertUser(user);
	}

	@Override
	public List<UserBean> checkUserInfoForXiao(String uopenid) {
		// TODO Auto-generated method stub
		return mapper.checkUserInfoForXiao(uopenid);
	}

	@Override
	public List<UserBean> findUserInfoForXiao(String uopenid) {
		// TODO Auto-generated method stub
		return mapper.findUserInfoForXiao(uopenid);
	}

	

	
}
