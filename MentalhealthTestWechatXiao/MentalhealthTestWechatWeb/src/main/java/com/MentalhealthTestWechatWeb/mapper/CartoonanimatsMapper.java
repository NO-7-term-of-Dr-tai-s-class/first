package com.MentalhealthTestWechatWeb.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.MentalhealthTestWechatWeb.entity.AdminBean;
import com.MentalhealthTestWechatWeb.entity.CartoonanimatsBean;
import com.MentalhealthTestWechatWeb.entity.UserBean;

@Mapper
public interface CartoonanimatsMapper {
	
	public List<CartoonanimatsBean> findAll();
	
	public CartoonanimatsBean findCartoonanimatsById(Integer id);
	
	public void deleteCartoonanimatsById(Integer id);
	
	public void updateCartoonanimatsInfo(CartoonanimatsBean cartoonanimatsBean);
	
	public void insertCartoonanimatsInfo(CartoonanimatsBean cartoonanimatsBean);
	
	public List<CartoonanimatsBean> findCartoonanimatsListsByFlag(Integer id);
	
	public List<CartoonanimatsBean> checkCartoonanimats(CartoonanimatsBean cartoonanimatsBean);
	
	public List<CartoonanimatsBean> findCartoonanimatsListsByMohuTitle(String ctitle);
	

}
 