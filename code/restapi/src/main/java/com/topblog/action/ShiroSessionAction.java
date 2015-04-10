package com.topblog.action;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.common.entity.ResultInfo;
import com.dao.entity.ShiroSession;
import com.topblog.service.ShiroSessionService;
import com.untils.JsonUtil;

@Controller
@RequestMapping("/session")
public class ShiroSessionAction {
	
	@Autowired
	ShiroSessionService sessionService;
	
	@RequestMapping(value="/insert",method=RequestMethod.POST,produces="text/json;charset=UTF-8")
	@ResponseStatus(value=HttpStatus.OK)
	@ResponseBody
	public String insert(HttpServletRequest request){
		
		ShiroSession  session=new ShiroSession();
		
		session.setSessionId(Integer.parseInt(request.getParameter("sessionId")));
		session.setSessionKey(request.getParameter("sessionKey"));
		session.setSessionValue(request.getParameter("sessionValue"));
		
		sessionService.insertSession(session);
		
		ResultInfo resultInfo=new ResultInfo();
		
		resultInfo.setErrorCode(0);
		resultInfo.setErrorMessage("ok");
		
		return JsonUtil.serialize(resultInfo);
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST,produces="text/json;charset=UTF-8")
	@ResponseStatus(value=HttpStatus.OK)
	@ResponseBody
	public String update(HttpServletRequest request){
		
		ShiroSession  session=new ShiroSession();
		
		session.setSessionId(Integer.parseInt(request.getParameter("sessionId")));
		session.setSessionKey(request.getParameter("sessionKey"));
		session.setSessionValue(request.getParameter("sessionValue"));
		
		sessionService.updateSessionById(session);
		
		ResultInfo resultInfo=new ResultInfo();
		resultInfo.setErrorCode(0);
		resultInfo.setErrorMessage("ok");
		
		return JsonUtil.serialize(resultInfo);
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.POST,produces="text/json;charset=UTF-8")
	@ResponseStatus(value=HttpStatus.OK)
	@ResponseBody
	public String delete(HttpServletRequest request){
		
		sessionService.deleteSessionById(Integer.parseInt(request.getParameter("sessionId")));
		
		ResultInfo resultInfo=new ResultInfo();
		resultInfo.setErrorCode(0);
		resultInfo.setErrorMessage("ok");
		
		return JsonUtil.serialize(resultInfo);
	}
	
	@RequestMapping(value="/getSessionByKey",produces="text/json;charset=UTF-8")
	@ResponseStatus(value=HttpStatus.OK)
	@ResponseBody
	public String getSessionByKey(HttpServletRequest request){
		
		String sessionKey=request.getParameter("sessionKey");
		
		ShiroSession session=sessionService.getBySessionKey(sessionKey);
		
		return JsonUtil.serialize(session);
	}
}
