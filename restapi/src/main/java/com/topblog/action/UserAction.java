package com.topblog.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.dao.entity.UserInfo;
import com.topblog.service.UserInfoService;
import com.untils.JsonUtil;


@Controller
@RequestMapping("/user")
public class UserAction {
	@Autowired
	private UserInfoService userInfoService;
	
	@RequestMapping(value="/userInfo",method=RequestMethod.POST,produces="text/json;charset=UTF-8")
	@ResponseStatus(value=HttpStatus.OK)
	@ResponseBody
	public String getUserInfo(HttpServletRequest request){
		
		String userId=request.getParameter("id");
		
		if(null == userId)
			return "userid is null";
		
		UserInfo userinfo=userInfoService.getAllById(Integer.parseInt(userId));
		JSON.toJSONString(userinfo);
		return JsonUtil.serialize(userinfo);
	}
	
	@RequestMapping(value="/userList",method=RequestMethod.POST,produces="text/json;charset=UTF-8")
	@ResponseStatus(value=HttpStatus.OK)
	@ResponseBody
	public String getUserList(HttpServletRequest request){
		
		List<UserInfo> userList= userInfoService.getAll();
		return JsonUtil.serialize(userList);
	}
}
