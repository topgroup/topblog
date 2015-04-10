package com.topblog.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.entity.UserInfo;
import com.topblog.dao.UserInfoDao;

@Service
public class UserInfoService {
	@Autowired
	private UserInfoDao userInfoDao;
	
	public List<UserInfo> getAll(){
		return userInfoDao.getAllList();
	}
	
	public List<UserInfo> getAllList() {
		return userInfoDao.getAllList();
	}
	
	public UserInfo getAllById(int userId){
		return userInfoDao.getAllById(userId);
	}
	
	public List<UserInfo> getAllList(Map<String, Object> map){
		return userInfoDao.getAllList(map);
	}
	
	public void insertUserinfo(UserInfo userInfo){
		userInfoDao.insertUserinfo(userInfo);
	}
}
