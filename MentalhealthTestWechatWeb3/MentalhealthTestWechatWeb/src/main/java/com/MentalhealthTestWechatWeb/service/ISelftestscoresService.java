package com.MentalhealthTestWechatWeb.service;

import java.util.List;

import com.MentalhealthTestWechatWeb.entity.AdminBean;
import com.MentalhealthTestWechatWeb.entity.CartoonanimatsBean;
import com.MentalhealthTestWechatWeb.entity.SelftestsBean;
import com.MentalhealthTestWechatWeb.entity.SelftestscoresBean;
import com.MentalhealthTestWechatWeb.entity.UserBean;
import com.MentalhealthTestWechatWeb.entity.VideosBean;

public interface ISelftestscoresService {

	public List<SelftestscoresBean> findAll();
	
	public SelftestscoresBean findSelftestscoresById(Integer id);
	
	public List<SelftestscoresBean> checkSelftestscoresById(Integer id);
	
	public void deleteSelftestscoresById(Integer id);
	
	public void updateSelftestscoresInfo(SelftestscoresBean selftestscoresBean);
	
	public void insertSelftestscoresInfo(SelftestscoresBean selftestscoresBean);
}
 