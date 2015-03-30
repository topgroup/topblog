package com.topblog.action;

import java.util.HashMap;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.topblog.entity.UserInfo;
import com.topblog.service.UserInfoService;


@Controller
public class IndexAction {
	
	@Autowired
	private UserInfoService userInfoService;
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public ModelAndView login(@RequestParam("userId") String userId,@RequestParam("userName") String userName){
		
		Map<String, Object> context=new HashMap<String, Object>();
		
	    Subject subject = SecurityUtils.getSubject();  
	    UsernamePasswordToken token = new UsernamePasswordToken(userId, userName);  
	    token.setRememberMe(true);
	    ModelAndView view =new ModelAndView("../../index");
	    try {  
	        subject.login(token);  
	        
	        if(subject.isAuthenticated()){
	        	context.put("msg","登录成功");
	        	view=new ModelAndView("../../sucess",context);
	        }else{
	        	view.addObject("msg","登录失败");
	        }
	        
	    } catch (UnknownAccountException e) { 
	    	view.addObject("msg","未知用户名");
	    } catch (IncorrectCredentialsException e) {
	    	view.addObject("msg","密码错误");
		}catch(AuthenticationException e){
			view.addObject("msg","登录失败");
		}
	    
		return view;
	}
	
	@RequestMapping("/loginOut")
	public ModelAndView login(){
		
		Map<String, Object> context=new HashMap<String, Object>();
		
	    Subject subject = SecurityUtils.getSubject();  
	  
	    try {  
	    	
	        if(subject.isAuthenticated())  {
	        	subject.logout();
	        	context.put("msg","用户已注销");
	        }
	        else{
	        	context.put("msg","用户未登陆,不需要注销");
	        }
	    }catch(AuthenticationException e){
			context.put("msg",e);
		}
		
		ModelAndView view=new ModelAndView("../../sucess",context);
		return view;
	}
	
	@RequestMapping(value="/regeditUser")
	public ModelAndView regeditUser(){
		
		//userInfoService.InsertUserInfo();
		ModelAndView view = new ModelAndView("../../regeditUser");
		
		return view;
	}
	
	@RequestMapping(value="/regedit")
	public ModelAndView regeditUser(HttpServletRequest request,HttpServletResponse response ){
		
		//userInfoService.InsertUserInfo();
		ModelAndView view = new ModelAndView("../../regeditUser");
		
		UserInfo userinfo=new UserInfo();
		userinfo.setUserid(Integer.parseInt(request.getParameter("userId")));
		userinfo.setUsername(request.getParameter("userName").toString());
		userinfo.setUserno(Integer.parseInt(request.getParameter("userNo")));
		if("on".equals(request.getParameter("sexMan"))){
			userinfo.setSex(true);
		}
		else{
			userinfo.setSex(false);
		}
		userInfoService.insertUserinfo(userinfo);
		
		view.addObject("msg", "用户"+userinfo.getUsername()+"添加成功");
		
		return view;
	}
}
