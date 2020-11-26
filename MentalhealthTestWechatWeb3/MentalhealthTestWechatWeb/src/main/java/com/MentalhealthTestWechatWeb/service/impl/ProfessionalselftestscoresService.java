package com.MentalhealthTestWechatWeb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MentalhealthTestWechatWeb.entity.AdminBean;
import com.MentalhealthTestWechatWeb.entity.CartoonanimatsBean;
import com.MentalhealthTestWechatWeb.entity.ProfessionalselftestscoresBean;
import com.MentalhealthTestWechatWeb.entity.SelftestscoresBean;
import com.MentalhealthTestWechatWeb.entity.UserBean;
import com.MentalhealthTestWechatWeb.entity.VideoTypesBean;
import com.MentalhealthTestWechatWeb.mapper.AdminMapper;
import com.MentalhealthTestWechatWeb.mapper.CartoonanimatsMapper;
import com.MentalhealthTestWechatWeb.mapper.ProfessionalselftestscoresMapper;
import com.MentalhealthTestWechatWeb.mapper.SelftestscoresMapper;
import com.MentalhealthTestWechatWeb.mapper.UserMapper;
import com.MentalhealthTestWechatWeb.mapper.VideoTypesMapper;
import com.MentalhealthTestWechatWeb.service.IAdminService;
import com.MentalhealthTestWechatWeb.service.ICartoonanimatsService;
import com.MentalhealthTestWechatWeb.service.IProfessionalselftestsService;
import com.MentalhealthTestWechatWeb.service.IProfessionalselftestscoresService;
import com.MentalhealthTestWechatWeb.service.ISelftestscoresService;
import com.MentalhealthTestWechatWeb.service.IUserService;
import com.MentalhealthTestWechatWeb.service.IVideoTypesService;

@Service
public class ProfessionalselftestscoresService implements IProfessionalselftestscoresService{

	@Autowired
	private ProfessionalselftestscoresMapper mapper;

	@Override
	public List<ProfessionalselftestscoresBean> findAll() {
		// TODO Auto-generated method stub
		return mapper.findAll();
	}

	@Override
	public ProfessionalselftestscoresBean findProfessionalselftestscoresById(Integer id) {
		// TODO Auto-generated method stub
		return mapper.findProfessionalselftestscoresById(id);
	}

	@Override
	public List<ProfessionalselftestscoresBean> checkProfessionalselftestscoresById(Integer id) {
		// TODO Auto-generated method stub
		return mapper.checkProfessionalselftestscoresById(id);
	}

	@Override
	public void deleteProfessionalselftestscoresById(Integer id) {
		// TODO Auto-generated method stub
		mapper.deleteProfessionalselftestscoresById(id);
	}

	@Override
	public void updateProfessionalselftestscoresInfo(ProfessionalselftestscoresBean professionalselftestscoresBean) {
		// TODO Auto-generated method stub
		mapper.updateProfessionalselftestscoresInfo(professionalselftestscoresBean);
	}

	@Override
	public void insertProfessionalselftestscoresInfo(ProfessionalselftestscoresBean professionalselftestscoresBean) {
		// TODO Auto-generated method stub
		mapper.insertProfessionalselftestscoresInfo(professionalselftestscoresBean);
	}

	

	

	
}
