package com.topblog.action;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class IndexAction {
	
	@RequestMapping("/login")
	public ModelAndView login(@RequestParam("userId") String userId,@RequestParam("userName") String userName){
		
		Map<String, Object> context=new HashMap<String, Object>();
		
		context.put("id",userId);
		context.put("name",userName);
		
		ModelAndView view=new ModelAndView("../../sucess",context);
		return view;
	}
}
