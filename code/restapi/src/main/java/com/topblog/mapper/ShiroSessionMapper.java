package com.topblog.mapper;

import com.dao.entity.ShiroSession;
import java.util.*;

public interface ShiroSessionMapper {
	
	public List<ShiroSession> getAll();
	
	public ShiroSession getById(int sessionId);
	
	public ShiroSession getBySessionKey(String sessionKey);
	
	public void insertSession(ShiroSession session);
	
	public void updateSessionById(ShiroSession session);
	
	public void deleteSessionById(int sessionId);
}
