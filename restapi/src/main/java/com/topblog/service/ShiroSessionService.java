package com.topblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.entity.ShiroSession;
import com.topblog.dao.ShiroSessionDao;

@Service
public class ShiroSessionService {
	@Autowired
	private ShiroSessionDao sessionDao;
	
	public ShiroSession getById(Integer sessionId) {
		return sessionDao.getById(sessionId);
	}
	
	public void insertSession(ShiroSession session){
		sessionDao.insertSession(session);
	}
	
	public void updateSessionById(ShiroSession session){
		sessionDao.updateSessionById(session);
	}
	
	public void deleteSessionById(Integer sessionId){
		sessionDao.deleteSessionById(sessionId);
	}
	
	public ShiroSession getBySessionKey(String sessionKey) {
		return sessionDao.getBySessionKey(sessionKey);
	}
}
