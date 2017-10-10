package com.exoo.hgp.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.exoo.hgp.entity.News;
import com.exoo.hgp.entity.User;
import com.exoo.hgp.service.NewsService;
import com.exoo.hgp.service.UserService;

@Controller
public class IndexController {
	
	@Autowired
	private UserService userService;
	
	
	@RequestMapping("/index")
	public String index(Model model, Principal principal){
		String username = principal.getName();
		User user = userService.findByUsername(username);
		model.addAttribute("player", user);
		
		return "index";
	}
	
	
}
