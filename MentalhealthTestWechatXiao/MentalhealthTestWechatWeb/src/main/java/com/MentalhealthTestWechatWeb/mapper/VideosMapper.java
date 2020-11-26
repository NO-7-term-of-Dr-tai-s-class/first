package com.MentalhealthTestWechatWeb.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.MentalhealthTestWechatWeb.entity.AdminBean;
import com.MentalhealthTestWechatWeb.entity.CartoonanimatsBean;
import com.MentalhealthTestWechatWeb.entity.UserBean;
import com.MentalhealthTestWechatWeb.entity.VideosBean;

@Mapper
public interface VideosMapper {
	
	public List<VideosBean> findAll();
	
	public VideosBean findVideosById(Integer id);
	
	public void deleteVideosById(Integer id);
	
	public void updateVideosInfo(VideosBean videosBean);
	
	public void insertVideosInfo(VideosBean videosBean);
	
	public List<VideosBean> findVideosListsByVtid(Integer id);
	
	public List<VideosBean> checkVideos(VideosBean videosBean);
	
	public List<VideosBean> findVideosListsByMohuTitle(String vtitle);
	

}
 