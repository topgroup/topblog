package com.topblog.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
}
