package com.MentalhealthTestWechatWeb.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.MentalhealthTestWechatWeb.entity.AdminBean;
import com.MentalhealthTestWechatWeb.entity.CartoonanimatsBean;
import com.MentalhealthTestWechatWeb.entity.MusicTypesBean;
import com.MentalhealthTestWechatWeb.entity.UserBean;
import com.MentalhealthTestWechatWeb.entity.WechatsBean;

@Mapper
public interface WechatsMapper {
	
	public List<WechatsBean> findAll();
	
	public List<WechatsBean> checkWechats(WechatsBean wechatsBean);
	
	public void deleteWechatsById(Integer id);
	
	public void insertWechatsInfo(WechatsBean wechatsBean);
	
	

}
 