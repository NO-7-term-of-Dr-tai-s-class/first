package com.MentalhealthTestWechatWeb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MentalhealthTestWechatWeb.entity.AdminBean;
import com.MentalhealthTestWechatWeb.entity.CartoonanimatsBean;
import com.MentalhealthTestWechatWeb.entity.UserBean;
import com.MentalhealthTestWechatWeb.mapper.AdminMapper;
import com.MentalhealthTestWechatWeb.mapper.CartoonanimatsMapper;
import com.MentalhealthTestWechatWeb.mapper.UserMapper;
import com.MentalhealthTestWechatWeb.service.IAdminService;
import com.MentalhealthTestWechatWeb.service.ICartoonanimatsService;
import com.MentalhealthTestWechatWeb.service.IUserService;

@Service
public class CartoonanimatsService implements ICartoonanimatsService{

	@Autowired
	private CartoonanimatsMapper mapper;

	@Override
	public List<CartoonanimatsBean> findAll() {
		// TODO Auto-generated method stub
		return mapper.findAll();
	}

	@Override
	public CartoonanimatsBean findCartoonanimatsById(Integer id) {
		// TODO Auto-generated method stub
		return mapper.findCartoonanimatsById(id);
	}

	@Override
	public void deleteCartoonanimatsById(Integer id) {
		// TODO Auto-generated method stub
		mapper.deleteCartoonanimatsById(id);
	}

	@Override
	public void updateCartoonanimatsInfo(CartoonanimatsBean cartoonanimatsBean) {
		// TODO Auto-generated method stub
		mapper.updateCartoonanimatsInfo(cartoonanimatsBean);
	}

	@Override
	public void insertCartoonanimatsInfo(CartoonanimatsBean cartoonanimatsBean) {
		// TODO Auto-generated method stub
		mapper.insertCartoonanimatsInfo(cartoonanimatsBean);
	}

	@Override
	public List<CartoonanimatsBean> findCartoonanimatsListsByFlag(Integer id) {
		// TODO Auto-generated method stub
		return mapper.findCartoonanimatsListsByFlag(id);
	}

	@Override
	public List<CartoonanimatsBean> checkCartoonanimats(CartoonanimatsBean cartoonanimatsBean) {
		// TODO Auto-generated method stub
		return mapper.checkCartoonanimats(cartoonanimatsBean);
	}

	@Override
	public List<CartoonanimatsBean> findCartoonanimatsListsByMohuTitle(String ctitle) {
		// TODO Auto-generated method stub
		return mapper.findCartoonanimatsListsByMohuTitle(ctitle);
	}



	

	
}
