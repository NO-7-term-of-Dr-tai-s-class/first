package com.MentalhealthTestWechatWeb.service;

import java.util.List;

import com.MentalhealthTestWechatWeb.entity.AdminBean;
import com.MentalhealthTestWechatWeb.entity.UserBean;

public interface IAdminService {

	public AdminBean login(AdminBean st);
	
	public List<AdminBean> findAll();
	
	public AdminBean findAdminById(Integer id);
	
	public void updateAdminInfo(AdminBean adminBean);
	
	public List<AdminBean> findAdminListsById(Integer id);
}
 