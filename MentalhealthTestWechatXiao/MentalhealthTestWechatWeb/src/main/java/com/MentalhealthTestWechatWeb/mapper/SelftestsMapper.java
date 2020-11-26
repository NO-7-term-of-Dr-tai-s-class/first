package com.MentalhealthTestWechatWeb.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.MentalhealthTestWechatWeb.entity.AdminBean;
import com.MentalhealthTestWechatWeb.entity.CartoonanimatsBean;
import com.MentalhealthTestWechatWeb.entity.SelftestsBean;
import com.MentalhealthTestWechatWeb.entity.UserBean;
import com.MentalhealthTestWechatWeb.entity.VideosBean;

@Mapper
public interface SelftestsMapper {
	
	public List<SelftestsBean> findAll();
	
	public List<SelftestsBean> findIndexSelftests(Integer id);
	

}
 