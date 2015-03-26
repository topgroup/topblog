package com.topblog.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.topblog.entity.*;
import com.topblog.service.UserInfoService;


@Controller
@RequestMapping("/user")
public class UserAction {
	@Autowired
	private UserInfoService userInfoService;
	
	@RequestMapping
	public ModelAndView helloWorld() {
		
		ModelAndView view=new ModelAndView();
		
		view.addObject("str","hello world");
		view.setViewName("/user/userList");
		return view;
	}
	
	@RequestMapping(value="/userInfo/{id}")
	public ModelAndView getUserInfo(@PathVariable("id") int userId){
		
		//userInfoService.InsertUserInfo();
		ModelAndView view=new ModelAndView("/user/userInfo");
		
		UserInfo userinfo=userInfoService.getAllById(userId);
		
		view.addObject("user",userinfo);
		
		return view;
	}
	
	@RequestMapping(value="/userList")
	public ModelAndView getUserList(){
		
		//userInfoService.InsertUserInfo();
		ModelAndView view=new ModelAndView();
		
		List<UserInfo> userList= userInfoService.getAll();
		view.addObject("userList",userList);
		
		return view;
	}
	
	@RequestMapping(value="/userList/{id}")
	public ModelAndView getUserListById(@PathVariable("id") int userId){
		Map<String, Object> map=new HashMap<String, Object>();
		
		map.put("userId", userId);
		
		List<UserInfo> userList= userInfoService.getAllList(map);
		
		Map<String, Object> result=new HashMap<String, Object>();
		
		result.put("userList", userList);
		
		ModelAndView view=new ModelAndView("/user/userList",result);
		
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
