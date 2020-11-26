package com.MentalhealthTestWechatWeb.service;

import java.util.List;

import com.MentalhealthTestWechatWeb.entity.AdminBean;
import com.MentalhealthTestWechatWeb.entity.CartoonanimatsBean;
import com.MentalhealthTestWechatWeb.entity.MusicsBean;
import com.MentalhealthTestWechatWeb.entity.UserBean;
import com.MentalhealthTestWechatWeb.entity.VideosBean;

public interface IMusicsService {

	public List<MusicsBean> findAll();
	
	public MusicsBean findMusicsById(Integer id);
	
	public void deleteMusicsById(Integer id);
	
	public void updateMusicsInfo(MusicsBean musicsBean);
	
	public void insertMusicsInfo(MusicsBean musicsBean);
	
	public List<MusicsBean> findMusicsListsByVtid(Integer id);
	
	public List<MusicsBean> checkMusics(MusicsBean musicsBean);
	
	public List<MusicsBean> findMusicsListsByMohuTitle(String vtitle);
	
}
 