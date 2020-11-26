package com.MentalhealthTestWechatWeb.service;

import java.util.List;

import com.MentalhealthTestWechatWeb.entity.AdminBean;
import com.MentalhealthTestWechatWeb.entity.CartoonanimatsBean;
import com.MentalhealthTestWechatWeb.entity.MusicTypesBean;
import com.MentalhealthTestWechatWeb.entity.UserBean;
import com.MentalhealthTestWechatWeb.entity.VideoTypesBean;
import com.MentalhealthTestWechatWeb.entity.WechatsBean;

public interface IWechatsService {

	public List<WechatsBean> findAll();
	
	public List<WechatsBean> checkWechats(WechatsBean wechatsBean);
	
	public void deleteWechatsById(Integer id);
	
	public void insertWechatsInfo(WechatsBean wechatsBean);
	
	
}
 