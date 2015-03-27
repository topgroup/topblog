package com.topblog.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.topblog.entity.UserInfo;
import com.topblog.service.UserInfoService;


@Controller
public class IndexAction {
	
	@Autowired
	private UserInfoService userInfoService;
	
	@RequestMapping("/login")
	public ModelAndView login(@RequestParam("userId") String userId,@RequestParam("userName") String userName){
		
		Map<String, Object> context=new HashMap<String, Object>();
		
	    //3、得到Subject及创建用户名/密码身份验证Token（即用户身份/凭证）  
	    Subject subject = SecurityUtils.getSubject();  
	    System.out.println(subject);
	    UsernamePasswordToken token = new UsernamePasswordToken(userId, userName);  
	  
	    try {  
	        //4、登录，即身份验证  
	        subject.login(token);  
	        
	        if(subject.isAuthenticated()){
	        	context.put("msg","登录成功");
	        }else{
	        	context.put("msg","登录失败");
	        }
	        
	    } catch (UnknownAccountException e) {  
	    	context.put("msg","未知用户名");
	    } catch (IncorrectCredentialsException e) {
	    	context.put("msg","密码错误");
		}catch(AuthenticationException e){
			context.put("msg","登录失败");
		}
		
		ModelAndView view=new ModelAndView("../../sucess",context);
		return view;
	}
	
	@RequestMapping("/loginOut")
	public ModelAndView login(){
		
		Map<String, Object> context=new HashMap<String, Object>();
		
	    Subject subject = SecurityUtils.getSubject();  
	  
	    try {  
	        //4、登录，即身份验证  
	        subject.logout();
	        
	        context.put("msg","用户已注销");
	        
	    }catch(AuthenticationException e){
			context.put("msg",e);
		}
		
		ModelAndView view=new ModelAndView("../../sucess",context);
		return view;
	}
	
	@RequestMapping(value="/regeditUser")
	public ModelAndView regeditUser(){
		
		ModelAndView view=new ModelAndView("/user/regeditUser");
		
		return view;
	}
	
	@RequestMapping(value="/regedit")
	public ModelAndView regeditUser(HttpServletRequest request,HttpServletResponse response ){
		
		//userInfoService.InsertUserInfo();
		ModelAndView view=new ModelAndView("redirect:/user/userList");
		
		UserInfo userinfo=new UserInfo();
		userinfo.setUserid(Integer.parseInt(request.getParameter("userId")));
		userinfo.setUsername(request.getParameter("userName").toString());
		userinfo.setUserno(Integer.parseInt(request.getParameter("userNo")));
		userinfo.setSex(Boolean.parseBoolean(request.getParameter("sexMan")));
		
		userInfoService.insertUserinfo(userinfo);
		
		List<UserInfo> userList= userInfoService.getAll();
		view.addObject("userList",userList);
		
		return view;
	}
}
