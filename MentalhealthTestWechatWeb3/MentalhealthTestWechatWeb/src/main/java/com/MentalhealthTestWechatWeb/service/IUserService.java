package com.MentalhealthTestWechatWeb.service;

import java.util.List;

import com.MentalhealthTestWechatWeb.entity.UserBean;

public interface IUserService {

	public UserBean login(UserBean user);
	
	public List<UserBean> findAll();
	
	public List<UserBean> findUsersByTel(UserBean user);
	
	public List<UserBean> CheckUser(UserBean user);
	
	public UserBean findUsersById(Integer uid);
	
	public void deleteUsersById(Integer uid);
	
	public void updateUserInfo(UserBean user);
	
	public void insertUser(UserBean user);
	
	public List<UserBean> checkUserInfoForXiao(String uopenid);
	
	public List<UserBean> findUserInfoForXiao(String uopenid);
}
 