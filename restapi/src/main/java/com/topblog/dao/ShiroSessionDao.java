package com.topblog.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dao.entity.ShiroSession;
import com.topblog.mapper.*;

@Repository
public class ShiroSessionDao {
	@Autowired
	private ShiroSessionMapper sessionMapper;
	
	public ShiroSession getById(Integer sessionId) {
		return sessionMapper.getById(sessionId);
	}
	
	public void insertSession(ShiroSession session){
		sessionMapper.insertSession(session);
	}
	
	public void updateSessionById(ShiroSession session){
		sessionMapper.updateSessionById(session);
	}
	
	public void deleteSessionById(Integer sessionId){
		sessionMapper.deleteSessionById(sessionId);
	}
	
	public ShiroSession getBySessionKey(String sessionKey) {
		return sessionMapper.getBySessionKey(sessionKey);
	}
}
