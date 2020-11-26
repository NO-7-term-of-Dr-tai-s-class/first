package com.MentalhealthTestWechatWeb.controller;

import java.io.File;
import java.math.BigDecimal;
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
import com.MentalhealthTestWechatWeb.entity.CartoonanimatsBean;
import com.MentalhealthTestWechatWeb.entity.MusicTypesBean;
import com.MentalhealthTestWechatWeb.entity.MusicsBean;
import com.MentalhealthTestWechatWeb.entity.PageBean;
import com.MentalhealthTestWechatWeb.entity.PagingUtils;
import com.MentalhealthTestWechatWeb.entity.ProfessionalselftestsBean;
import com.MentalhealthTestWechatWeb.entity.ProfessionalselftestscoresBean;
import com.MentalhealthTestWechatWeb.entity.RequestParasUtils;
import com.MentalhealthTestWechatWeb.entity.Response;
import com.MentalhealthTestWechatWeb.entity.SelftestsBean;
import com.MentalhealthTestWechatWeb.entity.SelftestscoresBean;
import com.MentalhealthTestWechatWeb.entity.UserBean;
import com.MentalhealthTestWechatWeb.entity.VideoTypesBean;
import com.MentalhealthTestWechatWeb.entity.VideosBean;
import com.MentalhealthTestWechatWeb.entity.WechatsBean;
import com.MentalhealthTestWechatWeb.service.IAdminService;
import com.MentalhealthTestWechatWeb.service.ICartoonanimatsService;
import com.MentalhealthTestWechatWeb.service.IMusicTypesService;
import com.MentalhealthTestWechatWeb.service.IMusicsService;
import com.MentalhealthTestWechatWeb.service.IProfessionalselftestsService;
import com.MentalhealthTestWechatWeb.service.IProfessionalselftestscoresService;
import com.MentalhealthTestWechatWeb.service.ISelftestsService;
import com.MentalhealthTestWechatWeb.service.ISelftestscoresService;
import com.MentalhealthTestWechatWeb.service.IUserService;
import com.MentalhealthTestWechatWeb.service.IVideoTypesService;
import com.MentalhealthTestWechatWeb.service.IVideosService;
import com.MentalhealthTestWechatWeb.service.IWechatsService;
import com.MentalhealthTestWechatWeb.service.impl.VideosService;

import net.sf.json.JSONObject;

@Controller
@SpringBootApplication
public class MainController {
	
	@Autowired
	private ICartoonanimatsService cartoonanimatsService;
	@Autowired
	private IVideoTypesService videoTypesService; 
	@Autowired
	private IVideosService videosService;
	@Autowired
	private IMusicTypesService musicTypesService;
	@Autowired
	private IMusicsService musicsService; 
	@Autowired
	private ISelftestsService selftestsService; 
	@Autowired
	private IProfessionalselftestsService professionalselftestsService;
	@Autowired
	private IUserService userService; 
	@Autowired
	private ISelftestscoresService selftestscoresService; 
	@Autowired
	private IProfessionalselftestscoresService  professionalselftestscoresService ;
	@Autowired
	private IWechatsService wechatsService; 
	
	
	
	
	
	@ResponseBody
	@RequestMapping(value = "/UpdateMyOneInfosByOpenidForXiao",method = RequestMethod.POST,produces = "text/json;charset=UTF-8")
    public String UpdateMyOneInfosByOpenidForXiao(HttpServletRequest request){
		Response response = new Response();
		try {
			String openId = request.getParameter("openId").toString();
			
			String inputuname = request.getParameter("inputuname").toString();
			inputuname=new String(inputuname.getBytes("ISO-8859-1"),"UTF-8");
			String inputupwd = request.getParameter("inputupwd").toString();
			
			String inputtel = request.getParameter("inputtel").toString();
			
			String inputsex = request.getParameter("inputsex").toString();
			inputsex=new String(inputsex.getBytes("ISO-8859-1"),"UTF-8");
			
			int intage = 0;
			if(!request.getParameter("inputage").toString().equals(""))
				intage = Integer.parseInt(request.getParameter("inputage").toString());
			
			int uid = 0;
			List<UserBean> users = userService.findUserInfoForXiao(openId);
			if(users != null)
				uid = users.get(0).getUid();
			
			UserBean userBean = userService.findUsersById(uid);
			userBean.setUname(inputuname);
			userBean.setUpwd(inputupwd);
			userBean.setUtel(inputtel);
			userBean.setUage(intage);
			userBean.setUdate(timestampDate());
			userBean.setUsex(inputsex);
			
			userService.updateUserInfo(userBean);
			
			response.setResult(true);
			JSONObject json = JSONObject.fromObject(response);
			return json.toString();
			
		
		} catch (Exception e) {
			response.setResult(false);
			response.setMessage(e.toString());
		}
		response.setResult(false);
		JSONObject json = JSONObject.fromObject(response);
		return json.toString();
    }
	
	@ResponseBody
	@RequestMapping(path="/GetMyOneInfosByOpenidForXiao", method = RequestMethod.POST,produces="application/json;charset=utf-8")
	public String GetMyOneInfosByOpenidForXiao(HttpServletRequest request){
		Response response = new Response();
		try {
			String openId = request.getParameter("openId").toString().trim();
			
			int userId = 0;
			List<UserBean> users = userService.findUserInfoForXiao(openId);
			if(users.size() > 0 )
				userId = users.get(0).getUid();
			
			UserBean user = userService.findUsersById(userId);
			
			if(user != null){
				response.setObject(user);
				response.setResult(true);
				JSONObject json = JSONObject.fromObject(response);
				return json.toString();
				
			}else{
				response.setResult(false);
				JSONObject json = JSONObject.fromObject(response);
				return json.toString();
			}
			
		} catch (Exception e) {
			response.setResult(false);
			response.setMessage(e.toString());
		}
		response.setResult(false);
		JSONObject json = JSONObject.fromObject(response);
		return json.toString();
	}
	
	@ResponseBody
	@RequestMapping(path="/GetAllWechatsInfoForXiao", method = RequestMethod.GET,produces="application/json;charset=utf-8")
    public String GetAllWechatsInfoForXiao(HttpServletRequest request){
		Response response = new Response();
		try {
			
			List<WechatsBean> musicsBeans = wechatsService.findAll();
			
			if(musicsBeans != null){
				response.setResult(true);
				response.setObject(musicsBeans);
				JSONObject json = JSONObject.fromObject(response);
				return json.toString();
				
			}else{
				response.setResult(false);
				JSONObject json = JSONObject.fromObject(response);
				return json.toString();
			}
		} catch (Exception e) {
			response.setResult(false);
			response.setMessage(e.toString());
		}
		response.setResult(false);
		JSONObject json = JSONObject.fromObject(response);
		return json.toString();
    }
	
	@ResponseBody
	@RequestMapping(path="/AddWechatInfoForXiao", method = RequestMethod.POST,produces="application/json;charset=utf-8")
    public String AddWechatInfoForXiao(HttpServletRequest request){
		Response response = new Response();
		try {
			String openId = request.getParameter("openId").toString().trim();
			String wecont = request.getParameter("wecont").toString().trim();
			
			int uid = 0;
			List<UserBean> checkuser = userService.findUserInfoForXiao(openId);
			if(checkuser.size() > 0)
				uid = checkuser.get(0).getUid();
			
			WechatsBean wechatsBean = new WechatsBean();
			wechatsBean.setWcont(wecont);
			wechatsBean.setWdate(timestampDate());
			wechatsBean.setWuid(uid);
			
			List<WechatsBean> checksc = wechatsService.checkWechats(wechatsBean);
			if(checksc.size() == 0){
				wechatsService.insertWechatsInfo(wechatsBean);
				
				List<WechatsBean> musicsBeans = wechatsService.findAll();
				response.setObject(musicsBeans);
				response.setResult(true);
				JSONObject json = JSONObject.fromObject(response);
				return json.toString();
				
			}else{
				response.setResult(false);
				JSONObject json = JSONObject.fromObject(response);
				return json.toString();
			}
		} catch (Exception e) {
			response.setResult(false);
			response.setMessage(e.toString());
		}
		response.setResult(false);
		JSONObject json = JSONObject.fromObject(response);
		return json.toString();
    }
	
	@ResponseBody
	@RequestMapping(path="/GetCartoonanimatsDetailByVidForXiao", method = RequestMethod.POST,produces="application/json;charset=utf-8")
    public String GetCartoonanimatsDetailByVidForXiao(HttpServletRequest request){
		Response response = new Response();
		try {
			String id = request.getParameter("id").toString().trim();
			
			CartoonanimatsBean checksc = cartoonanimatsService.findCartoonanimatsById(Integer.parseInt(id));
			if(checksc!= null){
				response.setObject(checksc);
				response.setResult(true);
				JSONObject json = JSONObject.fromObject(response);
				return json.toString();
				
			}else{
				response.setResult(false);
				JSONObject json = JSONObject.fromObject(response);
				return json.toString();
			}
		} catch (Exception e) {
			response.setResult(false);
			response.setMessage(e.toString());
		}
		response.setResult(false);
		JSONObject json = JSONObject.fromObject(response);
		return json.toString();
    }
	
	@ResponseBody
	@RequestMapping(path="/GetAllCartoonanimatssInfoForXiao", method = RequestMethod.GET,produces="application/json;charset=utf-8")
    public String GetAllCartoonanimatssInfoForXiao(HttpServletRequest request){
		Response response = new Response();
		try {
			
			List<CartoonanimatsBean> musicsBeans = cartoonanimatsService.findCartoonanimatsListsByFlag(1);
			
			if(musicsBeans != null){
				response.setResult(true);
				response.setObject(musicsBeans);
				JSONObject json = JSONObject.fromObject(response);
				return json.toString();
				
			}else{
				response.setResult(false);
				JSONObject json = JSONObject.fromObject(response);
				return json.toString();
			}
		} catch (Exception e) {
			response.setResult(false);
			response.setMessage(e.toString());
		}
		response.setResult(false);
		JSONObject json = JSONObject.fromObject(response);
		return json.toString();
    }
	
	@ResponseBody
	@RequestMapping(path="/GetAllCartoonanimatss2InfoForXiao", method = RequestMethod.GET,produces="application/json;charset=utf-8")
    public String GetAllCartoonanimatss2InfoForXiao(HttpServletRequest request){
		Response response = new Response();
		try {
			
			List<CartoonanimatsBean> musicsBeans = cartoonanimatsService.findCartoonanimatsListsByFlag(2);
			
			if(musicsBeans != null){
				response.setResult(true);
				response.setObject(musicsBeans);
				JSONObject json = JSONObject.fromObject(response);
				return json.toString();
				
			}else{
				response.setResult(false);
				JSONObject json = JSONObject.fromObject(response);
				return json.toString();
			}
		} catch (Exception e) {
			response.setResult(false);
			response.setMessage(e.toString());
		}
		response.setResult(false);
		JSONObject json = JSONObject.fromObject(response);
		return json.toString();
    }
	
	
	
	@ResponseBody
	@RequestMapping(path="/GetVideoDetailByVidForXiao", method = RequestMethod.POST,produces="application/json;charset=utf-8")
    public String GetVideoDetailByVidForXiao(HttpServletRequest request){
		Response response = new Response();
		try {
			String id = request.getParameter("id").toString().trim();
			
			VideosBean checksc = videosService.findVideosById(Integer.parseInt(id));
			if(checksc!= null){
				response.setObject(checksc);
				response.setResult(true);
				JSONObject json = JSONObject.fromObject(response);
				return json.toString();
				
			}else{
				response.setResult(false);
				JSONObject json = JSONObject.fromObject(response);
				return json.toString();
			}
		} catch (Exception e) {
			response.setResult(false);
			response.setMessage(e.toString());
		}
		response.setResult(false);
		JSONObject json = JSONObject.fromObject(response);
		return json.toString();
    }
	
	
	
	@ResponseBody
	@RequestMapping(path="/GetAllVideosInfoForXiao", method = RequestMethod.GET,produces="application/json;charset=utf-8")
    public String GetAllVideosInfoForXiao(HttpServletRequest request){
		Response response = new Response();
		try {
			
			List<VideosBean> videosBeans = videosService.findAll();
			
			if(videosBeans != null){
				response.setResult(true);
				response.setObject(videosBeans);
				JSONObject json = JSONObject.fromObject(response);
				return json.toString();
				
			}else{
				response.setResult(false);
				JSONObject json = JSONObject.fromObject(response);
				return json.toString();
			}
		} catch (Exception e) {
			response.setResult(false);
			response.setMessage(e.toString());
		}
		response.setResult(false);
		JSONObject json = JSONObject.fromObject(response);
		return json.toString();
    }
	
	
	@ResponseBody
	@RequestMapping(path="/GetAllMusicssInfoForXiao", method = RequestMethod.GET,produces="application/json;charset=utf-8")
    public String GetAllCartoonTypesInfoForXiao(HttpServletRequest request){
		Response response = new Response();
		try {
			
			List<MusicsBean> musicsBeans = musicsService.findAll();
			
			if(musicsBeans != null){
				response.setResult(true);
				response.setObject(musicsBeans);
				JSONObject json = JSONObject.fromObject(response);
				return json.toString();
				
			}else{
				response.setResult(false);
				JSONObject json = JSONObject.fromObject(response);
				return json.toString();
			}
		} catch (Exception e) {
			response.setResult(false);
			response.setMessage(e.toString());
		}
		response.setResult(false);
		JSONObject json = JSONObject.fromObject(response);
		return json.toString();
    }
	
	@ResponseBody
	@RequestMapping(path="/GetProfessionalselftestscoresInfoForXiao", method = RequestMethod.POST,produces="application/json;charset=utf-8")
    public String GetProfessionalselftestscoresInfoForXiao(HttpServletRequest request){
		Response response = new Response();
		try {
			String openId = request.getParameter("openId").toString().trim();
			
			int uid = 0;
			List<UserBean> checkuser = userService.findUserInfoForXiao(openId);
			if(checkuser.size() > 0)
				uid = checkuser.get(0).getUid();
			
			ProfessionalselftestscoresBean checksc = professionalselftestscoresService.findProfessionalselftestscoresById(uid);
			if(checksc!= null){
				response.setObject(checksc);
				response.setResult(true);
				JSONObject json = JSONObject.fromObject(response);
				return json.toString();
				
			}else{
				response.setResult(false);
				JSONObject json = JSONObject.fromObject(response);
				return json.toString();
			}
		} catch (Exception e) {
			response.setResult(false);
			response.setMessage(e.toString());
		}
		response.setResult(false);
		JSONObject json = JSONObject.fromObject(response);
		return json.toString();
    }
	
	
	@ResponseBody
	@RequestMapping(path="/AddProfessionalselftestscoresInfoForXiao", method = RequestMethod.POST,produces="application/json;charset=utf-8")
    public String AddProfessionalselftestscoresInfoForXiao(HttpServletRequest request){
		Response response = new Response();
		try {
			String openId = request.getParameter("openId").toString().trim();
			String scores = request.getParameter("scores").toString().trim();
			
			System.out.println(openId);
			System.out.println(scores);
			
			int uid = 0;
			List<UserBean> checkuser = userService.findUserInfoForXiao(openId);
			if(checkuser.size() > 0)
				uid = checkuser.get(0).getUid();
			
			ProfessionalselftestscoresBean pc = new ProfessionalselftestscoresBean();
			pc.setPsdate(timestampDate());
			pc.setPsscore(Integer.parseInt(scores));
			pc.setPsuid(uid);
			
			System.out.println(uid);
			
			List<ProfessionalselftestscoresBean> checksc = professionalselftestscoresService.checkProfessionalselftestscoresById(uid);
			if(checksc.size() == 0){
				System.out.println("uid="+uid);
				professionalselftestscoresService.insertProfessionalselftestscoresInfo(pc);
				response.setResult(true);
				JSONObject json = JSONObject.fromObject(response);
				return json.toString();
				
			}else{
				
				professionalselftestscoresService.updateProfessionalselftestscoresInfo(pc);
				
				response.setResult(false);
				JSONObject json = JSONObject.fromObject(response);
				return json.toString();
			}
		} catch (Exception e) {
			response.setResult(false);
			response.setMessage(e.toString());
		}
		response.setResult(false);
		JSONObject json = JSONObject.fromObject(response);
		return json.toString();
    }
	
	@ResponseBody
	@RequestMapping(path="/GetSindexProfessionalselftestsInfoForXiao", method = RequestMethod.POST,produces="application/json;charset=utf-8")
    public String GetSindexProfessionalselftestsInfoForXiao(HttpServletRequest request){
		Response response = new Response();
		try {
			String sindex = request.getParameter("sindex").toString().trim();
			
			System.out.println(sindex);
			
			List<ProfessionalselftestsBean> selftestsBeans = professionalselftestsService.findIndexProfessionalselftests(Integer.parseInt(sindex));
			
			if(selftestsBeans != null){
				response.setResult(true);
				response.setObject(selftestsBeans.get(0));
				JSONObject json = JSONObject.fromObject(response);
				return json.toString();
				
			}else{
				response.setResult(false);
				JSONObject json = JSONObject.fromObject(response);
				return json.toString();
			}
		} catch (Exception e) {
			response.setResult(false);
			response.setMessage(e.toString());
		}
		response.setResult(false);
		JSONObject json = JSONObject.fromObject(response);
		return json.toString();
    }
	
	
	@ResponseBody
	@RequestMapping(path="/GetSelftestScoreInfoForXiao", method = RequestMethod.POST,produces="application/json;charset=utf-8")
    public String GetSelftestScoreInfoForXiao(HttpServletRequest request){
		Response response = new Response();
		try {
			String openId = request.getParameter("openId").toString().trim();
			
			int uid = 0;
			List<UserBean> checkuser = userService.findUserInfoForXiao(openId);
			if(checkuser.size() > 0)
				uid = checkuser.get(0).getUid();
			
			SelftestscoresBean checksc = selftestscoresService.findSelftestscoresById(uid);
			if(checksc!= null){
				response.setObject(checksc);
				response.setResult(true);
				JSONObject json = JSONObject.fromObject(response);
				return json.toString();
				
			}else{
				response.setResult(false);
				JSONObject json = JSONObject.fromObject(response);
				return json.toString();
			}
		} catch (Exception e) {
			response.setResult(false);
			response.setMessage(e.toString());
		}
		response.setResult(false);
		JSONObject json = JSONObject.fromObject(response);
		return json.toString();
    }
	
	
	@ResponseBody
	@RequestMapping(path="/AddSelftestScoreInfoForXiao", method = RequestMethod.POST,produces="application/json;charset=utf-8")
    public String AddSelftestScoreInfoForXiao(HttpServletRequest request){
		Response response = new Response();
		try {
			String openId = request.getParameter("openId").toString().trim();
			String scores = request.getParameter("scores").toString().trim();
			
			System.out.println(openId);
			System.out.println(scores);
			
			int uid = 0;
			List<UserBean> checkuser = userService.findUserInfoForXiao(openId);
			if(checkuser.size() > 0)
				uid = checkuser.get(0).getUid();
			
			SelftestscoresBean sc = new SelftestscoresBean();
			sc.setSsdate(timestampDate());
			sc.setSsscore(Integer.parseInt(scores));
			sc.setSsuid(uid);
			
			System.out.println(uid);
			
			List<SelftestscoresBean> checksc = selftestscoresService.checkSelftestscoresById(uid);
			if(checksc.size() == 0){
				selftestscoresService.insertSelftestscoresInfo(sc);
				response.setResult(true);
				JSONObject json = JSONObject.fromObject(response);
				return json.toString();
				
			}else{
				
				selftestscoresService.updateSelftestscoresInfo(sc);
				
				response.setResult(false);
				JSONObject json = JSONObject.fromObject(response);
				return json.toString();
			}
		} catch (Exception e) {
			response.setResult(false);
			response.setMessage(e.toString());
		}
		response.setResult(false);
		JSONObject json = JSONObject.fromObject(response);
		return json.toString();
    }
	
	
	@ResponseBody
	@RequestMapping(path="/GetSindexSelftestInfoForXiao", method = RequestMethod.POST,produces="application/json;charset=utf-8")
    public String GetSindexSelftestInfoForXiao(HttpServletRequest request){
		Response response = new Response();
		try {
			String sindex = request.getParameter("sindex").toString().trim();
			
			System.out.println(sindex);
			
			List<SelftestsBean> selftestsBeans = selftestsService.findIndexSelftests(Integer.parseInt(sindex));
			
			if(selftestsBeans != null){
				response.setResult(true);
				response.setObject(selftestsBeans.get(0));
				JSONObject json = JSONObject.fromObject(response);
				return json.toString();
				
			}else{
				response.setResult(false);
				JSONObject json = JSONObject.fromObject(response);
				return json.toString();
			}
		} catch (Exception e) {
			response.setResult(false);
			response.setMessage(e.toString());
		}
		response.setResult(false);
		JSONObject json = JSONObject.fromObject(response);
		return json.toString();
    }
	
	
	@ResponseBody
	@RequestMapping(path="/AddUserInfoDbForXiao", method = RequestMethod.POST,produces="application/json;charset=utf-8")
    public String AddUserInfoDbForXiao(HttpServletRequest request){
		Response response = new Response();
		try {
			String uname = request.getParameter("uname").toString();
			String openId = request.getParameter("openId").toString();
			String imgUrl = request.getParameter("imgUrl").toString();
			
			UserBean user = new UserBean();
			user.setUimg(imgUrl);
			user.setUnicheng(uname);
			user.setUopenid(openId);
			user.setUdate(timestampDate());
			
			List<UserBean> checkUser = userService.checkUserInfoForXiao(openId);
			
			if(checkUser.size() > 0){
				response.setResult(false);
				JSONObject json = JSONObject.fromObject(response);
				return json.toString();
			}else{
				
				System.out.println(openId);
				System.out.println("aa");
				
				userService.insertUser(user);
				response.setResult(true);
				response.setObject(user);
				JSONObject json = JSONObject.fromObject(response);
				return json.toString();
			}
		} catch (Exception e) {
			response.setResult(false);
			response.setMessage(e.toString());
		}
		response.setResult(false);
		JSONObject json = JSONObject.fromObject(response);
		return json.toString();
    }
	

	@ResponseBody
	@RequestMapping(path="/checkUserByOpenIdForXiao", method = RequestMethod.POST,produces="application/json;charset=utf-8")
    public String checkUserByOpenIdForXiao(HttpServletRequest request){
		Response response = new Response();
		try {
			String openId = request.getParameter("openId").toString();

			List<UserBean> checkUser = userService.checkUserInfoForXiao(openId);
			
			if(checkUser.size() > 0){
				response.setResult(true);
				response.setObject(checkUser.get(0));
				JSONObject json = JSONObject.fromObject(response);
				return json.toString();
			}else{
				response.setResult(false);
				JSONObject json = JSONObject.fromObject(response);
				return json.toString();
			}
		} catch (Exception e) {
			response.setResult(false);
			response.setMessage(e.toString());
		}
		response.setResult(false);
		JSONObject json = JSONObject.fromObject(response);
		return json.toString();
    }
	
	
	/*################################################*/
	@RequestMapping(path = "/musicsmana", produces = "application/json;charset=utf-8")
	public String musicsmana(PageBean page, HttpServletRequest request,HttpSession session) {
		if(session.getAttribute("adminuser") != null && !session.getAttribute("adminuser").equals("")){
			
			List<MusicsBean> musicsmana = musicsService.findAll();
			PagingUtils.page15(page, request, musicsmana);
			request.setAttribute("musicsmana", page.getDataList());
			request.setAttribute("selectName", "");
			return "musicsmana";
			
		}else {
			return "userLogin";
		}
	}
	
	@RequestMapping(path = "/SelectMusicsByendname", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	public String SelectMusicsByendname(PageBean page, HttpServletRequest request, HttpSession session) throws Exception {
		if(session.getAttribute("adminuser") != null && !session.getAttribute("adminuser").equals("")){
			
			String name = RequestParasUtils.getJspStringParameters("name", request);
			String endname = "%"+name+"%";
			
			List<MusicsBean> musicsmana = musicsService.findMusicsListsByMohuTitle(endname);
			PagingUtils.page15(page, request, musicsmana);
			request.setAttribute("musicsmana", page.getDataList());
			request.setAttribute("selectName", name);
			return "musicsmana";
			
		}else {
			return "userLogin";
		}
	}
	
	@ResponseBody
	@RequestMapping(path="/AddMusicsToDB", method = RequestMethod.GET,produces="application/json;charset=utf-8")
	public AdminBean AddMusicsToDB(PageBean page, HttpServletRequest request,HttpSession session) throws Exception{
		if(session.getAttribute("adminuser") != null && !session.getAttribute("adminuser").equals("")){

			String mtitle = RequestParasUtils.getJspStringParameters("Mtitle", request);
			String msinger = RequestParasUtils.getJspStringParameters("Msinger", request);
			String filevideopath = RequestParasUtils.getJspStringParameters("filevideopath", request);
			String filepath = RequestParasUtils.getJspStringParameters("filepath", request);
			String vtype = RequestParasUtils.getJspStringParameters("vtype", request);
			
			int mtid = 0;
			List<MusicTypesBean> musictype = musicTypesService.checkMusicTypes(vtype);
			if(musictype.size() > 0)
				mtid = musictype.get(0).getMtid();
			
			MusicsBean musics = new MusicsBean();
			musics.setMimg(filepath);
			musics.setMpath(filevideopath);
			musics.setMsinger(msinger);
			musics.setMtid(mtid);
			musics.setMtitle(mtitle);
			
			List<MusicsBean> checks = musicsService.checkMusics(musics);
			if(checks.size() == 0) {
				musicsService.insertMusicsInfo(musics);
				return AdminBean.getJsonResult(200, "添加成功");
			}else {
				return AdminBean.getJsonResult(200, "该数据已经添加");
			}
		}else{ 
			return AdminBean.getJsonResult(200, "未登录");
		}
	}
	
	@ResponseBody
	@RequestMapping(path="/UpMusicsToDB", method = RequestMethod.GET,produces="application/json;charset=utf-8")
	public AdminBean UpMusicsToDB(PageBean page, HttpServletRequest request,HttpSession session) throws Exception{
		if(session.getAttribute("adminuser") != null && !session.getAttribute("adminuser").equals("")){

			String mtitle = RequestParasUtils.getJspStringParameters("Mtitle", request);
			String msinger = RequestParasUtils.getJspStringParameters("Msinger", request);
			String filevideopath = RequestParasUtils.getJspStringParameters("filevideopath", request);
			String filepath = RequestParasUtils.getJspStringParameters("filepath", request);
			String vtype = RequestParasUtils.getJspStringParameters("vtype", request);
			String aid = RequestParasUtils.getJspStringParameters("aid", request);
			
			int mtid = 0;
			List<MusicTypesBean> musictype = musicTypesService.checkMusicTypes(vtype);
			if(musictype.size() > 0)
				mtid = musictype.get(0).getMtid();
			
			MusicsBean musics = new MusicsBean();
			musics.setMimg(filepath);
			musics.setMpath(filevideopath);
			musics.setMsinger(msinger);
			musics.setMtid(mtid);
			musics.setMtitle(mtitle);
			musics.setMid(Integer.parseInt(aid));
			
			List<MusicsBean> checks = musicsService.checkMusics(musics);
			if(checks.size() == 0 || checks.size() == 1) {
				musicsService.updateMusicsInfo(musics);
				return AdminBean.getJsonResult(200, "修改成功");
			}else {
				return AdminBean.getJsonResult(200, "该数据已经添加");
			}
		}else{ 
			return AdminBean.getJsonResult(200, "未登录");
		}
	}
	
	@RequestMapping(value="/deleteMusicsById",method = RequestMethod.GET,produces = "text/json;charset=UTF-8")
	public String deleteMusicsById(HttpServletRequest request){
		int id = Integer.parseInt(request.getParameter("Id"));
		musicsService.deleteMusicsById(id);
		return "redirect:/musicsmana";
	}
	
	@ResponseBody
	@RequestMapping(value="/getMusicsInfoByJId",method=RequestMethod.GET)
	public MusicsBean getMusicsInfoByJId(HttpServletRequest request){
		int id = RequestParasUtils.getJspIntegerParameters("id", request);
		return MusicsBean.getJsonResult(200, "123", musicsService.findMusicsById(id));
	}
	
	@ResponseBody
	@RequestMapping(value="/getMusicsTypeInfo",method=RequestMethod.GET)
	public MusicTypesBean getMusicsTypeInfo(HttpServletRequest request){
		return MusicTypesBean.getJsonResult(200, "123", musicTypesService.findAll());
	}
	
	@RequestMapping(path = "/musictypesmana", produces = "application/json;charset=utf-8")
	public String musictypesmana(PageBean page, HttpServletRequest request,HttpSession session) {
		if(session.getAttribute("adminuser") != null && !session.getAttribute("adminuser").equals("")){
			
			List<MusicTypesBean> musictypesmana = musicTypesService.findAll();
			PagingUtils.page15(page, request, musictypesmana);
			request.setAttribute("musictypesmana", page.getDataList());
			return "musictypesmana";
			
		}else {
			return "userLogin";
		}
	}
	
	@ResponseBody
	@RequestMapping(path="/AddMTypesToDB", method = RequestMethod.GET,produces="application/json;charset=utf-8")
	public AdminBean AddMTypesToDB(PageBean page, HttpServletRequest request,HttpSession session) throws Exception{
		if(session.getAttribute("adminuser") != null && !session.getAttribute("adminuser").equals("")){

			String mtname = RequestParasUtils.getJspStringParameters("Mtname", request);
			
			MusicTypesBean mt = new MusicTypesBean();
			mt.setMtname(mtname);
			
			List<MusicTypesBean> checks = musicTypesService.checkMusicTypes(mtname);
			if(checks.size() == 0) {
				musicTypesService.insertMusicTypesInfo(mt);
				return AdminBean.getJsonResult(200, "添加成功");
			}else {
				return AdminBean.getJsonResult(200, "该数据已经添加");
			}
		}else{ 
			return AdminBean.getJsonResult(200, "未登录");
		}
	}
	
	@ResponseBody
	@RequestMapping(path="/UpMTypesToDB", method = RequestMethod.GET,produces="application/json;charset=utf-8")
	public AdminBean UpMTypesToDB(PageBean page, HttpServletRequest request,HttpSession session) throws Exception{
		if(session.getAttribute("adminuser") != null && !session.getAttribute("adminuser").equals("")){

			String mtname = RequestParasUtils.getJspStringParameters("Mtname", request);
			String aid = RequestParasUtils.getJspStringParameters("aid", request);
			
			MusicTypesBean mt = new MusicTypesBean();
			mt.setMtname(mtname);
			mt.setMtid(Integer.parseInt(aid));
			
			List<MusicTypesBean> checks = musicTypesService.checkMusicTypes(mtname);
			if(checks.size() == 0 || checks.size() == 1) {
				musicTypesService.updateMusicTypesInfo(mt);
				return AdminBean.getJsonResult(200, "修改成功");
			}else {
				return AdminBean.getJsonResult(200, "该数据已经添加");
			}
		}else{ 
			return AdminBean.getJsonResult(200, "未登录");
		}
	}
	
	@RequestMapping(value="/deleteMTypesById",method = RequestMethod.GET,produces = "text/json;charset=UTF-8")
	public String deleteMTypesById(HttpServletRequest request){
		int id = Integer.parseInt(request.getParameter("Id"));
		musicTypesService.deleteMusicTypesById(id);
		return "redirect:/musictypesmana";
	}
	
	
	@RequestMapping(path = "/videosmana", produces = "application/json;charset=utf-8")
	public String videosmana(PageBean page, HttpServletRequest request,HttpSession session) {
		if(session.getAttribute("adminuser") != null && !session.getAttribute("adminuser").equals("")){
			
			List<VideosBean> videosmana = videosService.findAll();
			PagingUtils.page15(page, request, videosmana);
			request.setAttribute("videosmana", page.getDataList());
			request.setAttribute("selectName", "");
			return "videosmana";
			
		}else {
			return "userLogin";
		}
	}
	
	@RequestMapping(path = "/SelectVideosByendname", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	public String SelectVideosByendname(PageBean page, HttpServletRequest request, HttpSession session) throws Exception {
		if(session.getAttribute("adminuser") != null && !session.getAttribute("adminuser").equals("")){
			
			String name = RequestParasUtils.getJspStringParameters("name", request);
			String endname = "%"+name+"%";
			
			List<VideosBean> videosmana = videosService.findVideosListsByMohuTitle(endname);
			PagingUtils.page15(page, request, videosmana);
			request.setAttribute("videosmana", page.getDataList());
			request.setAttribute("selectName", name);
			return "videosmana";
			
		}else {
			return "userLogin";
		}
	}
	
	@ResponseBody
	@RequestMapping(path="/AddVideosToDB", method = RequestMethod.GET,produces="application/json;charset=utf-8")
	public AdminBean AddVideosToDB(PageBean page, HttpServletRequest request,HttpSession session) throws Exception{
		if(session.getAttribute("adminuser") != null && !session.getAttribute("adminuser").equals("")){

			String vtitle = RequestParasUtils.getJspStringParameters("Vtitle", request);
			String vperformers = RequestParasUtils.getJspStringParameters("Vperformers", request);
			String vscores = RequestParasUtils.getJspStringParameters("Vscores", request);
			String vjianjie = RequestParasUtils.getJspStringParameters("Vjianjie", request);
			String filevideopath = RequestParasUtils.getJspStringParameters("filevideopath", request);
			String filepath = RequestParasUtils.getJspStringParameters("filepath", request);
			String vtype = RequestParasUtils.getJspStringParameters("vtype", request);
			
			int vtid = 0;
			List<VideoTypesBean> videotype = videoTypesService.checkVideoTypes(vtype);
			if(videotype.size() > 0)
				vtid = videotype.get(0).getVtid();
			
			VideosBean video = new VideosBean();
			video.setVimg(filepath);
			video.setVjianjie(vjianjie);
			video.setVpath(filevideopath);
			video.setVperformers(vperformers);
			video.setVscores(vscores);
			video.setVtid(vtid);
			video.setVtitle(vtitle);
			
			List<VideosBean> checks = videosService.checkVideos(video);
			if(checks.size() == 0) {
				videosService.insertVideosInfo(video);
				return AdminBean.getJsonResult(200, "添加成功");
			}else {
				return AdminBean.getJsonResult(200, "该数据已经添加");
			}
		}else{ 
			return AdminBean.getJsonResult(200, "未登录");
		}
	}
	
	@ResponseBody
	@RequestMapping(path="/upVideosToDB", method = RequestMethod.GET,produces="application/json;charset=utf-8")
	public AdminBean upVideosToDB(PageBean page, HttpServletRequest request,HttpSession session) throws Exception{
		if(session.getAttribute("adminuser") != null && !session.getAttribute("adminuser").equals("")){

			String vtitle = RequestParasUtils.getJspStringParameters("Vtitle", request);
			String vperformers = RequestParasUtils.getJspStringParameters("Vperformers", request);
			String vscores = RequestParasUtils.getJspStringParameters("Vscores", request);
			String vjianjie = RequestParasUtils.getJspStringParameters("Vjianjie", request);
			String filevideopath = RequestParasUtils.getJspStringParameters("filevideopath", request);
			String filepath = RequestParasUtils.getJspStringParameters("filepath", request);
			String vtype = RequestParasUtils.getJspStringParameters("vtype", request);
			String aid = RequestParasUtils.getJspStringParameters("aid", request);
			
			int vtid = 0;
			List<VideoTypesBean> videotype = videoTypesService.checkVideoTypes(vtype);
			if(videotype.size() > 0)
				vtid = videotype.get(0).getVtid();
			
			VideosBean video = new VideosBean();
			video.setVimg(filepath);
			video.setVjianjie(vjianjie);
			video.setVpath(filevideopath);
			video.setVperformers(vperformers);
			video.setVscores(vscores);
			video.setVtid(vtid);
			video.setVtitle(vtitle);
			video.setVid(Integer.parseInt(aid));
			
			List<VideosBean> checks = videosService.checkVideos(video);
			if(checks.size() == 0 || checks.size() == 1) {
				videosService.updateVideosInfo(video);
				return AdminBean.getJsonResult(200, "修改成功");
			}else {
				return AdminBean.getJsonResult(200, "该数据已经添加");
			}
		}else{ 
			return AdminBean.getJsonResult(200, "未登录");
		}
	}
	
	@RequestMapping(value="/deleteVideosById",method = RequestMethod.GET,produces = "text/json;charset=UTF-8")
	public String deleteVideosById(HttpServletRequest request){
		int id = Integer.parseInt(request.getParameter("Id"));
		videosService.deleteVideosById(id);
		return "redirect:/videosmana";
	}
	
	@ResponseBody
	@RequestMapping(value="/getVideosInfoByJId",method=RequestMethod.GET)
	public VideosBean getVideosInfoByJId(HttpServletRequest request){
		int id = RequestParasUtils.getJspIntegerParameters("id", request);
		return VideosBean.getJsonResult(200, "123", videosService.findVideosById(id));
	}
	
	@ResponseBody
	@RequestMapping(value="/getVideosTypeInfo",method=RequestMethod.GET)
	public VideoTypesBean getVideosTypeInfoByJId(HttpServletRequest request){
		return VideoTypesBean.getJsonResult(200, "123", videoTypesService.findAll());
	}
	
	@RequestMapping(path = "/videotypesmana", produces = "application/json;charset=utf-8")
	public String videotypesmana(PageBean page, HttpServletRequest request,HttpSession session) {
		if(session.getAttribute("adminuser") != null && !session.getAttribute("adminuser").equals("")){
			
			List<VideoTypesBean> videotypesmana = videoTypesService.findAll();
			PagingUtils.page15(page, request, videotypesmana);
			request.setAttribute("videotypesmana", page.getDataList());
			return "videotypesmana";
			
		}else {
			return "userLogin";
		}
	}
	
	@ResponseBody
	@RequestMapping(path="/AddVideoTypesToDB", method = RequestMethod.GET,produces="application/json;charset=utf-8")
	public AdminBean AddVideoTypesToDB(PageBean page, HttpServletRequest request,HttpSession session) throws Exception{
		if(session.getAttribute("adminuser") != null && !session.getAttribute("adminuser").equals("")){

			String vtname = RequestParasUtils.getJspStringParameters("Vtname", request);
			
			VideoTypesBean videoTypesBean = new VideoTypesBean();
			videoTypesBean.setVtname(vtname);
			
			List<VideoTypesBean> checks = videoTypesService.checkVideoTypes(vtname);
			if(checks.size() == 0) {
				videoTypesService.insertVideoTypesInfo(videoTypesBean);
				return AdminBean.getJsonResult(200, "添加成功");
			}else {
				return AdminBean.getJsonResult(200, "该数据已经添加");
			}
		}else{ 
			return AdminBean.getJsonResult(200, "未登录");
		}
	}
	
	@ResponseBody
	@RequestMapping(path="/upVideoTypesToDB", method = RequestMethod.GET,produces="application/json;charset=utf-8")
	public AdminBean upVideoTypesToDB(PageBean page, HttpServletRequest request,HttpSession session) throws Exception{
		if(session.getAttribute("adminuser") != null && !session.getAttribute("adminuser").equals("")){

			String vtname = RequestParasUtils.getJspStringParameters("Vtname", request);
			String vtid = RequestParasUtils.getJspStringParameters("aid", request);
			
			VideoTypesBean videoTypesBean = new VideoTypesBean();
			videoTypesBean.setVtname(vtname);
			videoTypesBean.setVtid(Integer.parseInt(vtid));
			
			List<VideoTypesBean> checks = videoTypesService.checkVideoTypes(vtname);
			if(checks.size() == 0 || checks.size() == 1) {
				videoTypesService.insertVideoTypesInfo(videoTypesBean);
				return AdminBean.getJsonResult(200, "修改成功");
			}else {
				return AdminBean.getJsonResult(200, "该数据已经添加");
			}
		}else{ 
			return AdminBean.getJsonResult(200, "未登录");
		}
	}
	
	@RequestMapping(value="/deleteVideoTypesById",method = RequestMethod.GET,produces = "text/json;charset=UTF-8")
	public String deleteVideoTypesById(HttpServletRequest request){
		int id = Integer.parseInt(request.getParameter("Id"));
		videoTypesService.deleteVideoTypesById(id);
		return "redirect:/videotypesmana";
	}
	
	@RequestMapping(path = "/cartoonanimatsmana", produces = "application/json;charset=utf-8")
	public String usersmana(PageBean page, HttpServletRequest request,HttpSession session) {
		if(session.getAttribute("adminuser") != null && !session.getAttribute("adminuser").equals("")){
			
			List<CartoonanimatsBean> cartoonanimatsmana = cartoonanimatsService.findAll();
			PagingUtils.page15(page, request, cartoonanimatsmana);
			request.setAttribute("cartoonanimatsmana", page.getDataList());
			request.setAttribute("selectName", "");
			return "cartoonanimatsmana";
			
		}else {
			return "userLogin";
		}
	}
	
	@RequestMapping(path = "/SelectCartoonanimatsByendname", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	public String SelectCartoonanimatsByendname(PageBean page, HttpServletRequest request, HttpSession session) throws Exception {
		if(session.getAttribute("adminuser") != null && !session.getAttribute("adminuser").equals("")){
			
			String name = RequestParasUtils.getJspStringParameters("name", request);
			String endname = "%"+name+"%";
			
			List<CartoonanimatsBean> cartoonanimatsmana = cartoonanimatsService.findCartoonanimatsListsByMohuTitle(endname);
			PagingUtils.page15(page, request, cartoonanimatsmana);
			request.setAttribute("cartoonanimatsmana", page.getDataList());
			request.setAttribute("selectName", name);
			return "cartoonanimatsmana";
			
		}else {
			return "userLogin";
		}
	}
	
	@ResponseBody
	@RequestMapping(value="/getCartoonanimatsInfoByJId",method=RequestMethod.GET)
	public CartoonanimatsBean getCartoonanimatsInfoByJId(HttpServletRequest request){
		int id = RequestParasUtils.getJspIntegerParameters("id", request);
		return CartoonanimatsBean.getJsonResult(200, "123", cartoonanimatsService.findCartoonanimatsById(id));
	}
	
	@RequestMapping(value="/deleteCartoonanimatsById",method = RequestMethod.GET,produces = "text/json;charset=UTF-8")
	public String deleteCartoonanimatsById(HttpServletRequest request){
		int id = Integer.parseInt(request.getParameter("Id"));
		cartoonanimatsService.deleteCartoonanimatsById(id);
		return "redirect:/cartoonanimatsmana";
	}
	
	@ResponseBody
	@RequestMapping(path="/AddCartoonanimatsToDB", method = RequestMethod.GET,produces="application/json;charset=utf-8")
	public AdminBean AddCartoonanimatsToDB(PageBean page, HttpServletRequest request,HttpSession session) throws Exception{
		if(session.getAttribute("adminuser") != null && !session.getAttribute("adminuser").equals("")){

			String Ctitle = RequestParasUtils.getJspStringParameters("Ctitle", request);
			String Cpath = RequestParasUtils.getJspStringParameters("Cpath", request);
			String Cjianjie = RequestParasUtils.getJspStringParameters("Cjianjie", request);
			String Cauthor = RequestParasUtils.getJspStringParameters("Cauthor", request);
			String Cimg = RequestParasUtils.getJspStringParameters("Cimg", request);
			String Ccont = RequestParasUtils.getJspStringParameters("Ccont", request);
			String Cflag = RequestParasUtils.getJspStringParameters("Cflag", request);
			
			CartoonanimatsBean cartoonanimatsBean = new CartoonanimatsBean();
			cartoonanimatsBean.setCauthor(Cauthor);
			cartoonanimatsBean.setCcont(Ccont);
			cartoonanimatsBean.setCdate(timestampDate());
			cartoonanimatsBean.setCflag(Integer.parseInt(Cflag));
			cartoonanimatsBean.setCimg(Cimg);
			cartoonanimatsBean.setCjianjie(Cjianjie);
			cartoonanimatsBean.setCpath(Cpath);
			cartoonanimatsBean.setCtitle(Ctitle);
			
			List<CartoonanimatsBean> checkCartoons = cartoonanimatsService.checkCartoonanimats(cartoonanimatsBean);
			if(checkCartoons.size() == 0) {
				cartoonanimatsService.insertCartoonanimatsInfo(cartoonanimatsBean);
				return AdminBean.getJsonResult(200, "添加成功");
			}else {
				return AdminBean.getJsonResult(200, "该数据已经添加");
			}
		}else{ 
			return AdminBean.getJsonResult(200, "未登录");
		}
	}
	
	@ResponseBody
	@RequestMapping(path="/UpCartoonanimatsToDB", method = RequestMethod.GET,produces="application/json;charset=utf-8")
	public AdminBean UpCartoonanimatsToDB(PageBean page, HttpServletRequest request,HttpSession session) throws Exception{
		if(session.getAttribute("adminuser") != null && !session.getAttribute("adminuser").equals("")){

			String Ctitle = RequestParasUtils.getJspStringParameters("Ctitle", request);
			String Cpath = RequestParasUtils.getJspStringParameters("Cpath", request);
			String Cjianjie = RequestParasUtils.getJspStringParameters("Cjianjie", request);
			String Cauthor = RequestParasUtils.getJspStringParameters("Cauthor", request);
			String Cimg = RequestParasUtils.getJspStringParameters("Cimg", request);
			String Ccont = RequestParasUtils.getJspStringParameters("Ccont", request);
			String Cflag = RequestParasUtils.getJspStringParameters("Cflag", request);
			String cid = RequestParasUtils.getJspStringParameters("aid", request);
			
			CartoonanimatsBean cartoonanimatsBean = new CartoonanimatsBean();
			cartoonanimatsBean.setCauthor(Cauthor);
			cartoonanimatsBean.setCcont(Ccont);
			cartoonanimatsBean.setCflag(Integer.parseInt(Cflag));
			cartoonanimatsBean.setCimg(Cimg);
			cartoonanimatsBean.setCjianjie(Cjianjie);
			cartoonanimatsBean.setCpath(Cpath);
			cartoonanimatsBean.setCtitle(Ctitle);
			cartoonanimatsBean.setCid(Integer.parseInt(cid));
			
			List<CartoonanimatsBean> checkCartoons = cartoonanimatsService.checkCartoonanimats(cartoonanimatsBean);
			if(checkCartoons.size() == 0 || checkCartoons.size() == 1) {
				cartoonanimatsService.updateCartoonanimatsInfo(cartoonanimatsBean);
				return AdminBean.getJsonResult(200, "修改成功");
			}else {
				return AdminBean.getJsonResult(200, "该数据已经添加");
			}
		}else{ 
			return AdminBean.getJsonResult(200, "未登录");
		}
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
