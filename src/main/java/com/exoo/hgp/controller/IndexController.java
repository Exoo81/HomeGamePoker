package com.exoo.hgp.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	
	@RequestMapping("/index")
	public String index(Model model, Principal principal){
		String username = principal.getName();
		model.addAttribute("palyerName", username);
		return "index";
	}

}
