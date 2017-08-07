package com.exoo.hgp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.exoo.hgp.service.UserService;
import com.exoo.hgp.utility.UserRegistrationWrapper;

@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/login")
	public String showLoginForm(){
		return "login";
	}
	@ModelAttribute("userRegistrationForm")
	public UserRegistrationWrapper userRegistrationForm(){
		return new UserRegistrationWrapper();
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String doRegister(@ModelAttribute ("userRegistrationForm")UserRegistrationWrapper newUser, BindingResult result){	
		userService.save(newUser);
		return "redirect:login.html?registration=true";
		
	}
	
	@RequestMapping("/usernameAvailable")
	@ResponseBody
	public String usernameAvailable(@RequestParam String username){
		Boolean isAvailable = userService.findOne(username) == null;
		return isAvailable.toString();
	}
	
	@RequestMapping("/emailAvailable")
	@ResponseBody
	public String emailAvailable(@RequestParam String email){
		Boolean isAvailable = userService.findOneEmail(email) == null;
		return isAvailable.toString();
	}
	
	@RequestMapping("/emailAvailableForgot")
	@ResponseBody
	public String emailAvailableForgot(@RequestParam String email){
		Boolean isAvailable = userService.findOneEmail(email) != null;
		return isAvailable.toString();
	}
	
}
