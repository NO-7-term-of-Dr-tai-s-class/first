package com.MentalhealthTestWechatWeb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MentalhealthTestWechatWeb.entity.AdminBean;
import com.MentalhealthTestWechatWeb.entity.CartoonanimatsBean;
import com.MentalhealthTestWechatWeb.entity.UserBean;
import com.MentalhealthTestWechatWeb.entity.VideosBean;
import com.MentalhealthTestWechatWeb.mapper.AdminMapper;
import com.MentalhealthTestWechatWeb.mapper.CartoonanimatsMapper;
import com.MentalhealthTestWechatWeb.mapper.UserMapper;
import com.MentalhealthTestWechatWeb.mapper.VideosMapper;
import com.MentalhealthTestWechatWeb.service.IAdminService;
import com.MentalhealthTestWechatWeb.service.ICartoonanimatsService;
import com.MentalhealthTestWechatWeb.service.IUserService;
import com.MentalhealthTestWechatWeb.service.IVideosService;

@Service
public class VideosService implements IVideosService{

	@Autowired
	private VideosMapper mapper;

	@Override
	public List<VideosBean> findAll() {
		// TODO Auto-generated method stub
		return mapper.findAll();
	}

	@Override
	public VideosBean findVideosById(Integer id) {
		// TODO Auto-generated method stub
		return mapper.findVideosById(id);
	}

	@Override
	public void deleteVideosById(Integer id) {
		// TODO Auto-generated method stub
		mapper.deleteVideosById(id);
	}

	@Override
	public void updateVideosInfo(VideosBean videosBean) {
		// TODO Auto-generated method stub
		mapper.updateVideosInfo(videosBean);
	}

	@Override
	public void insertVideosInfo(VideosBean videosBean) {
		// TODO Auto-generated method stub
		mapper.insertVideosInfo(videosBean);
	}

	@Override
	public List<VideosBean> findVideosListsByVtid(Integer id) {
		// TODO Auto-generated method stub
		return mapper.findVideosListsByVtid(id);
	}

	@Override
	public List<VideosBean> checkVideos(VideosBean videosBean) {
		// TODO Auto-generated method stub
		return mapper.checkVideos(videosBean);
	}

	@Override
	public List<VideosBean> findVideosListsByMohuTitle(String vtitle) {
		// TODO Auto-generated method stub
		return mapper.findVideosListsByMohuTitle(vtitle);
	}

	

	

	
}
