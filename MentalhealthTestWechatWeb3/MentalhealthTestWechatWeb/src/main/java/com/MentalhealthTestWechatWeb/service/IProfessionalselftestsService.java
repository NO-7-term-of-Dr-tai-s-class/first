package com.MentalhealthTestWechatWeb.service;

import java.util.List;

import com.MentalhealthTestWechatWeb.entity.AdminBean;
import com.MentalhealthTestWechatWeb.entity.CartoonanimatsBean;
import com.MentalhealthTestWechatWeb.entity.ProfessionalselftestsBean;
import com.MentalhealthTestWechatWeb.entity.SelftestsBean;
import com.MentalhealthTestWechatWeb.entity.UserBean;
import com.MentalhealthTestWechatWeb.entity.VideosBean;

public interface IProfessionalselftestsService {

	public List<ProfessionalselftestsBean> findAll();
	
	public List<ProfessionalselftestsBean> findIndexProfessionalselftests(Integer index);
	
}
 