package com.MentalhealthTestWechatWeb.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.MentalhealthTestWechatWeb.entity.AdminBean;
import com.MentalhealthTestWechatWeb.entity.CartoonanimatsBean;
import com.MentalhealthTestWechatWeb.entity.ProfessionalselftestsBean;
import com.MentalhealthTestWechatWeb.entity.SelftestsBean;
import com.MentalhealthTestWechatWeb.entity.UserBean;
import com.MentalhealthTestWechatWeb.entity.VideosBean;

@Mapper
public interface ProfessionalselftestsMapper {
	
	public List<ProfessionalselftestsBean> findAll();
	
	public List<ProfessionalselftestsBean> findIndexProfessionalselftests(Integer index);
	

}
 