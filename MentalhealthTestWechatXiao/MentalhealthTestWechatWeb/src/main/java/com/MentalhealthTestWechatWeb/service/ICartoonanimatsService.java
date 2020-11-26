package com.MentalhealthTestWechatWeb.service;

import java.util.List;

import com.MentalhealthTestWechatWeb.entity.AdminBean;
import com.MentalhealthTestWechatWeb.entity.CartoonanimatsBean;
import com.MentalhealthTestWechatWeb.entity.UserBean;

public interface ICartoonanimatsService {

	public List<CartoonanimatsBean> findAll();
	
	public CartoonanimatsBean findCartoonanimatsById(Integer id);
	
	public void deleteCartoonanimatsById(Integer id);
	
	public void updateCartoonanimatsInfo(CartoonanimatsBean cartoonanimatsBean);
	
	public void insertCartoonanimatsInfo(CartoonanimatsBean cartoonanimatsBean);
	
	public List<CartoonanimatsBean> findCartoonanimatsListsByFlag(Integer id);
	
	public List<CartoonanimatsBean> checkCartoonanimats(CartoonanimatsBean cartoonanimatsBean);
	
	public List<CartoonanimatsBean> findCartoonanimatsListsByMohuTitle(String ctitle);
	
}
 