package com.MentalhealthTestWechatWeb.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.MentalhealthTestWechatWeb.entity.AdminBean;
import com.MentalhealthTestWechatWeb.entity.CartoonanimatsBean;
import com.MentalhealthTestWechatWeb.entity.MusicsBean;
import com.MentalhealthTestWechatWeb.entity.UserBean;

@Mapper
public interface MusicsMapper {
	
	public List<MusicsBean> findAll();
	
	public MusicsBean findMusicsById(Integer id);
	
	public void deleteMusicsById(Integer id);
	
	public void updateMusicsInfo(MusicsBean musicsBean);
	
	public void insertMusicsInfo(MusicsBean musicsBean);
	
	public List<MusicsBean> findMusicsListsByVtid(Integer id);
	
	public List<MusicsBean> checkMusics(MusicsBean musicsBean);
	
	public List<MusicsBean> findMusicsListsByMohuTitle(String vtitle);
	

}
 