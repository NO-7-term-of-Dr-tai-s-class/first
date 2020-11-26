package com.MentalhealthTestWechatWeb.mapper;
//使用mybatis实现对数据库的操作接口
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.MentalhealthTestWechatWeb.entity.UserBean;

@Mapper//要求mybatis的版本为3.3及以上
public interface UserMapper {
	
	public UserBean login(UserBean user);
	
	public List<UserBean> findAll();
	
	public List<UserBean> findUsersByTel(UserBean user);
	
	public List<UserBean> CheckUser(UserBean user);
	
	public UserBean findUsersById(Integer uid);
	
	public void deleteUsersById(Integer uid);
	
	public void updateUserInfo(UserBean user);
	
	public void insertUser(UserBean user);
	
	public List<UserBean> checkUserInfoForXiao(String uopenid);
	
	public List<UserBean> findUserInfoForXiao(String uopenid);
}
 