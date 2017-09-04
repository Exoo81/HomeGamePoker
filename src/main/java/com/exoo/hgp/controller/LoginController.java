package com.exoo.hgp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.exoo.hgp.entity.User;
import com.exoo.hgp.service.UserService;
import com.exoo.hgp.service.VerificationTokenService;
import com.exoo.hgp.utility.UserRegistrationWrapper;

@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private VerificationTokenService verificationTokenService;
	
	@RequestMapping("/login")
	public String showLoginForm(){
		return "login";
	}
	@ModelAttribute("userRegistrationForm")
	public UserRegistrationWrapper userRegistrationForm(){
		return new UserRegistrationWrapper();
	}

	//TODO zmienic /login na /register
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String doRegister(@ModelAttribute ("userRegistrationForm")UserRegistrationWrapper newUser, BindingResult result){
		
		User user = userService.save(newUser);
			if(user == null) return "redirect:login.html?registration=101";
		
		user = verificationTokenService.saveToken(user);
			if(user == null) return "redirect:login.html?registration=102";
		
	
		try{
			verificationTokenService.sendActivationMail(user);
			
		}catch(MailException ex){
			System.err.println(ex.getMessage());
			return "redirect:login.html?registration=103";
		}
		 
		return "redirect:login.html?registration=true";
		
	}
	
	@RequestMapping(value="/login/accountActivation/{userID}/{token}", method = RequestMethod.GET)
	public String accountActivation(@PathVariable Integer userID, @PathVariable String token){
		
		Boolean tokenExist = verificationTokenService.checkActivationData(userID, token);
		if(!tokenExist){
			return "redirect:../../../login.html?activation=false";
		}
		
		userService.enabledAccount(userID);
		
		verificationTokenService.unActiveToken(token); 
		
		return "redirect:../../../login.html?activation=true";
		
	}
	
	//open new pass view
	@RequestMapping(value="/forgot/{userID}/{token}", method= RequestMethod.GET)
	public String showNewPasswordView(@PathVariable Integer userID, @PathVariable String token, Model model){
		
		User user = userService.findByID(userID);
		
		//System.out.println("redirect to change_password");
		
		model.addAttribute("user", user);
	    model.addAttribute("token", token);

		return "change_password";
	}
	
	//Send forgot mail
	@RequestMapping(value="/forgot", method = RequestMethod.POST)
	public String forgotPass(@RequestParam String email){
		
		//find user for email
		User user = userService.findUserByEmail(email);
			if(user == null) return "redirect:login.html?forgot=false";
		
		//save verification token
		user = verificationTokenService.saveToken(user);
		
		try{
			verificationTokenService.sendForgotMail(user);
			
		}catch(MailException ex){
			System.err.println(ex.getMessage());
			return "redirect:login.html?forgot=false";
		}
		
		return "redirect:login.html?forgot=true";
	}
	
	///change password
	@RequestMapping(value="/change_password/{userID}/{token}", method = RequestMethod.POST)
	public String changePass(@RequestParam String password, @RequestParam String repeatPassword, @PathVariable Integer userID, @PathVariable String token){
		
		//check token if expired
		Boolean tokenExist = verificationTokenService.checkActivationData(userID, token);
		if(!tokenExist){
			return "redirect:../../login.html?changePass=false";
		}
		//save new pass
		userService.changePassword(password, repeatPassword, userID);
		
		//unactive token
		verificationTokenService.unActiveToken(token);
		
		return "redirect:../../login.html?changePass=true";
	}
	
	@RequestMapping("/usernameAvailable")
	@ResponseBody
	public String usernameAvailable(@RequestParam String username){
		Boolean isAvailable = userService.findByUsername(username) == null;
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
