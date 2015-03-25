package com.topblog.mapper;

import com.topblog.entity.*;
import java.util.*;

public interface UserInfoMapper {
	
	public List<UserInfo> getAll();
	
	public UserInfo getAllById(int userId);
	
	public List<UserInfo> getAllList(Map<String, Object> map);
	
	public void insertUserinfo(UserInfo userInfo);
}
