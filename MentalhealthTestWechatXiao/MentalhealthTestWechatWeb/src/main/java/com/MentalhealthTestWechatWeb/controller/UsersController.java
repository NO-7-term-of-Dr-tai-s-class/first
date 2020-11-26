package com.MentalhealthTestWechatWeb.controller;

import java.io.File;
import java.net.URLDecoder;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.MentalhealthTestWechatWeb.entity.AdminBean;
import com.MentalhealthTestWechatWeb.entity.PageBean;
import com.MentalhealthTestWechatWeb.entity.PagingUtils;
import com.MentalhealthTestWechatWeb.entity.RequestParasUtils;
import com.MentalhealthTestWechatWeb.entity.UserBean;
import com.MentalhealthTestWechatWeb.service.IAdminService;
import com.MentalhealthTestWechatWeb.service.IUserService;

@Controller
@SpringBootApplication
public class UsersController {

	@Autowired
	private IUserService userService;
	@Autowired
	private IAdminService adminService; 
	
	
	
	
	@ResponseBody
	@RequestMapping(path="/upUserToDB", method = RequestMethod.GET,produces="application/json;charset=utf-8")
	public UserBean upUserToDB(PageBean page, HttpServletRequest request,HttpSession session) throws Exception{
		if(session.getAttribute("adminuser") != null && !session.getAttribute("adminuser").equals("")){

			int uid = RequestParasUtils.getJspIntegerParameters1("aid", request);
			String uname = RequestParasUtils.getJspStringParameters("uname", request);
			String upwd = RequestParasUtils.getJspStringParameters("upwd", request);
			String utel = RequestParasUtils.getJspStringParameters("utel", request);
			
			UserBean user = userService.findUsersById(uid);
			user.setUname(uname);
			user.setUpwd(upwd);
			user.setUtel(utel);
			
			List<UserBean> checkusers = userService.CheckUser(user);
			if(checkusers.size() == 0 || checkusers.size() == 1) {
				userService.updateUserInfo(user);
				
				return UserBean.getJsonResult(200, "修改成功");
			}else {
				return UserBean.getJsonResult(200, "修改失败");
			}
		}else{ 
			return UserBean.getJsonResult(200, "未登录");
		}
	}
	
	@ResponseBody
	@RequestMapping(value="/getUserInfoByAId",method=RequestMethod.GET)
	public UserBean getUserInfoByAId(HttpServletRequest request){
		int id = RequestParasUtils.getJspIntegerParameters("id", request);
		return UserBean.getJsonResult(200, "123", userService.findUsersById(id));
	}
	
	@RequestMapping(value="/deleteVUserById",method = RequestMethod.GET,produces = "text/json;charset=UTF-8")
	public String deleteVUserById(HttpServletRequest request){
		int id = Integer.parseInt(request.getParameter("Id"));
		userService.deleteUsersById(id);
		return "redirect:/usersmana";
	}
	
	@RequestMapping(path = "/usersmana", produces = "application/json;charset=utf-8")
	public String usersmana(PageBean page, HttpServletRequest request,HttpSession session) {
		if(session.getAttribute("adminuser") != null && !session.getAttribute("adminuser").equals("")){
			
			List<UserBean> users = userService.findAll();
			PagingUtils.page15(page, request, users);
			request.setAttribute("usersmana", page.getDataList());
			return "usersmana";
			
		}else {
			return "userLogin";
		}
	}

	
	@ResponseBody
	@RequestMapping(value="/getAdminUserInfoByAId",method=RequestMethod.GET)
	public AdminBean getAdminUserInfoByAId(HttpServletRequest request){
		int id = RequestParasUtils.getJspIntegerParameters("id", request);
		return AdminBean.getJsonResult(200, "123", adminService.findAdminById(id));
	}
	
	@RequestMapping(value = "/adminLogin",method = RequestMethod.POST,produces = "text/json;charset=UTF-8")
    public String adminLogin(HttpSession session,HttpServletRequest request, AdminBean user){
		AdminBean adminuser= adminService.login(user);
			if(adminuser != null){
				session.setAttribute("adminuser", adminuser);
				request.setAttribute("requestadminuser", adminuser); 
				
				return "adminindex";
			}else{
				return "redirect:/userLogin";
			}
    }
	
	@RequestMapping(path = "/userLogin", produces = "application/json;charset=utf-8")
	public String userLogin(PageBean page, HttpServletRequest request) {
		return "user_login";
	}

	@RequestMapping(path = "/adminoneselfmana", produces = "application/json;charset=utf-8")
	public String adminoneselfmana(PageBean page, HttpServletRequest request,HttpSession session) {
		if(session.getAttribute("adminuser") != null && !session.getAttribute("adminuser").equals("")){
			AdminBean user= (AdminBean)session.getAttribute("adminuser");
			request.setAttribute("requestadminuser", user); 
			
			return "adminindex";
		}else {
			return "userLogin";
		}
	}
	
	@ResponseBody
	@RequestMapping(path="/upAdminOneselfToDB", method = RequestMethod.GET,produces="application/json;charset=utf-8")
	public AdminBean upManaUserOneselfToDB(PageBean page, HttpServletRequest request,HttpSession session) throws Exception{
		if(session.getAttribute("adminuser") != null && !session.getAttribute("adminuser").equals("")){
			AdminBean user= (AdminBean)session.getAttribute("adminuser");

			String uname = RequestParasUtils.getJspStringParameters("uname", request);
			String upwd = RequestParasUtils.getJspStringParameters("upwd", request);
			String utel = RequestParasUtils.getJspStringParameters("utel", request);
			
			user.setAname(uname);
			user.setApwd(upwd);
			user.setAtel(utel);
			
				adminService.updateAdminInfo(user);
				
				return AdminBean.getJsonResult(200, "修改成功");
		}else{ 
			return AdminBean.getJsonResult(200, "修改失败未登录");
		}
	}
	
	
	@RequestMapping("/uploadphoto")
    @ResponseBody
    public  Map<String, Object>  updatePhoto(HttpServletRequest request,HttpServletResponse response,@RequestParam("myFile") MultipartFile myFile){
		 Map<String, Object> json = new HashMap<String, Object>();
	        try {
	            DateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");
	            String name = df.format(new Date());

	            Random r = new Random();
	            for(int i = 0 ;i<3 ;i++){
	                name += r.nextInt(10);
	            }
	            
	            String ext = FilenameUtils.getExtension(myFile.getOriginalFilename());
	            //String url = request.getSession().getServletContext().getRealPath("/upload");
	            
	            String url =  "D:\\bishe";
	            
	            String path = "/"+name + "." + ext;
	            File file = new File(url);
	            if(!file.exists()){
	                file.mkdirs();
	            }
	            
	            myFile.transferTo(new File(url+path));
	            json.put("success",path);
	            
	            System.out.println(path);
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	       return json ;
    }
	
	public Timestamp timestampDate(){
		return strFormatTimetamp(returnDateTimeStr());
	}
	
	public String returnDateTimeStr(){
		DateFormat df2 = DateFormat.getDateTimeInstance();
       return df2.format(new Date()); 
	}
	
	private Timestamp strFormatTimetamp(String str){
	    DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	    format.setLenient(false);
	    try {
		    Timestamp ts = new Timestamp(format.parse(str).getTime());
		    return ts;
	    } catch (Exception e) {
	     e.printStackTrace();
	     return null;
	    }
	}
	
	
	
}
