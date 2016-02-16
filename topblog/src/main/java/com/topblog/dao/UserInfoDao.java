package com.topblog.dao;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.topblog.entity.*;
import com.topblog.mapper.*;

@Repository
public class UserInfoDao {
	@Autowired
	private UserInfoMapper userInfoMapper;
	
	public List<UserInfo> getAllList() {
		return userInfoMapper.getAll();
	}
	
	public UserInfo getAllById(int userId){
		return userInfoMapper.getAllById(userId);
	}
	
	public List<UserInfo> getAllList(Map<String, Object> map){
		return userInfoMapper.getAllList(map);
	}
	
	public void insertUserinfo(UserInfo userInfo){
		userInfoMapper.insertUserinfo(userInfo);
	}
}
