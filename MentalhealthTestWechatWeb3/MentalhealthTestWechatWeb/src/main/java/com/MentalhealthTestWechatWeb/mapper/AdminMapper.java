package com.MentalhealthTestWechatWeb.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.MentalhealthTestWechatWeb.entity.AdminBean;
import com.MentalhealthTestWechatWeb.entity.UserBean;

@Mapper
public interface AdminMapper {
	
	public AdminBean login(AdminBean st);
	
	public List<AdminBean> findAll();
	
	public AdminBean findAdminById(Integer id);
	
	public void updateAdminInfo(AdminBean adminBean);
	
	public List<AdminBean> findAdminListsById(Integer id);

}
 