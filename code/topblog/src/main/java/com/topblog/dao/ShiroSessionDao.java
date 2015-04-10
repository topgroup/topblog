package com.topblog.dao;

import java.io.Serializable;
import java.util.Collection;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.ValidatingSession;
import org.apache.shiro.session.mgt.eis.AbstractSessionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.topblog.common.SerializableUtils;
import com.topblog.entity.ShiroSession;
import com.topblog.mapper.ShiroSessionMapper;

@Repository
public class ShiroSessionDao extends  AbstractSessionDAO  {
	@Autowired
	private ShiroSessionMapper shiroSessionMapper;

	@Override
	public void update(Session session) throws UnknownSessionException {
		if(session instanceof ValidatingSession && !((ValidatingSession)session).isValid()) {
		    return; //如果会话过期/停止 没必要再更新了
		}
		try{
			ShiroSession shiroSession=shiroSessionMapper.getBySessionKey(session.getId().toString());
			if(null!=shiroSession){
				
				shiroSession.setSessionKey(session.getId().toString());
				shiroSession.setSessionValue(SerializableUtils.Serializa(session));
				
				shiroSessionMapper.updateSessionById(shiroSession);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Session session) {
		System.out.println("deleteSession");
		ShiroSession shiroSession=shiroSessionMapper.getBySessionKey(session.getId().toString());
		if(null!=shiroSession){
			this.shiroSessionMapper.deleteSessionById(shiroSession.getSessionId());
		}
	}

	@Override
	public Collection<Session> getActiveSessions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Serializable doCreate(Session session) {
		System.out.println("createSession");
		Serializable sessionId=generateSessionId(session);
		assignSessionId(session,sessionId);
		
		try{
			ShiroSession shiroSession=shiroSessionMapper.getBySessionKey(sessionId.toString());
			
			if(null==shiroSession){
				shiroSession=new ShiroSession();
				shiroSession.setSessionKey(sessionId.toString());
				shiroSession.setSessionValue(SerializableUtils.Serializa(session));
				
				shiroSessionMapper.insertSession(shiroSession);
			}else{
				shiroSession.setSessionKey(sessionId.toString());
				shiroSession.setSessionValue(SerializableUtils.Serializa(session));
				
				shiroSessionMapper.updateSessionById(shiroSession);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return sessionId;
	}

	@Override
	protected Session doReadSession(Serializable sessionId) {
		System.out.println("getSession:"+sessionId.toString());
		try{
			ShiroSession shiroSession=shiroSessionMapper.getBySessionKey(sessionId.toString());
			if(null!= shiroSession){
				Session session= (Session)SerializableUtils.DeSerializa(shiroSession.getSessionValue());
				return session;
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
}
