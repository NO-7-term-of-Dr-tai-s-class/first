package com.MentalhealthTestWechatWeb.service;

import java.util.List;

import com.MentalhealthTestWechatWeb.entity.AdminBean;
import com.MentalhealthTestWechatWeb.entity.CartoonanimatsBean;
import com.MentalhealthTestWechatWeb.entity.SelftestsBean;
import com.MentalhealthTestWechatWeb.entity.UserBean;
import com.MentalhealthTestWechatWeb.entity.VideosBean;

public interface ISelftestsService {

	public List<SelftestsBean> findAll();
	
	public List<SelftestsBean> findIndexSelftests(Integer id);
}
 