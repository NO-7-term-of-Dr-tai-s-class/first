package com.MentalhealthTestWechatWeb.service;

import java.util.List;

import com.MentalhealthTestWechatWeb.entity.AdminBean;
import com.MentalhealthTestWechatWeb.entity.CartoonanimatsBean;
import com.MentalhealthTestWechatWeb.entity.ProfessionalselftestscoresBean;
import com.MentalhealthTestWechatWeb.entity.SelftestsBean;
import com.MentalhealthTestWechatWeb.entity.SelftestscoresBean;
import com.MentalhealthTestWechatWeb.entity.UserBean;
import com.MentalhealthTestWechatWeb.entity.VideosBean;

public interface IProfessionalselftestscoresService {

	public List<ProfessionalselftestscoresBean> findAll();
	
	public ProfessionalselftestscoresBean findProfessionalselftestscoresById(Integer id);
	
	public List<ProfessionalselftestscoresBean> checkProfessionalselftestscoresById(Integer id);
	
	public void deleteProfessionalselftestscoresById(Integer id);
	
	public void updateProfessionalselftestscoresInfo(ProfessionalselftestscoresBean professionalselftestscoresBean);
	
	public void insertProfessionalselftestscoresInfo(ProfessionalselftestscoresBean professionalselftestscoresBean);
	
}
 