package com.MentalhealthTestWechatWeb.service;

import java.util.List;

import com.MentalhealthTestWechatWeb.entity.AdminBean;
import com.MentalhealthTestWechatWeb.entity.CartoonanimatsBean;
import com.MentalhealthTestWechatWeb.entity.UserBean;
import com.MentalhealthTestWechatWeb.entity.VideosBean;

public interface IVideosService {

	public List<VideosBean> findAll();
	
	public VideosBean findVideosById(Integer id);
	
	public void deleteVideosById(Integer id);
	
	public void updateVideosInfo(VideosBean videosBean);
	
	public void insertVideosInfo(VideosBean videosBean);
	
	public List<VideosBean> findVideosListsByVtid(Integer id);
	
	public List<VideosBean> checkVideos(VideosBean videosBean);
	
	public List<VideosBean> findVideosListsByMohuTitle(String vtitle);
	
}
 