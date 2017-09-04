package com.exoo.hgp.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exoo.hgp.entity.User;
import com.exoo.hgp.entity.VerificationToken;
import com.exoo.hgp.repository.UserRepository;
import com.exoo.hgp.repository.VerificationTokenRepository;

@Service
@Transactional
public class VerificationTokenService {
	
	//local
	private static String activationCommonURL = "http://localhost:8080/HomeGamePoker/login/accountActivation/";
	private static String forgotCommonURL = "http://localhost:8080/HomeGamePoker/forgot/";
	
	//for AMAZONE
	//private static String activationCommonURL = "http://sample-env.6menmecyms.eu-west-1.elasticbeanstalk.com/login/accountActivation";
	//private static String forgotCommonURL = "http://sample-env.6menmecyms.eu-west-1.elasticbeanstalk.com/forgot/";
	
	@Autowired
	private VerificationTokenRepository verificationTokenRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	private JavaMailSender javaMailSender;
	
	@Autowired
	public VerificationTokenService(JavaMailSender javaMailSender){
		this.javaMailSender = javaMailSender;
	}
	
	public void sendActivationMail(User user)throws MailException{
		//send email
		
		String userID = user.getId().toString();
		String token = user.getVerificationToken().getToken();
		String activationLink = activationCommonURL +userID+"/" + token+".html";
		
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy HH:mm a");
			Date expireDate = user.getVerificationToken().getExpiryDate();
			String expireDateString = sdf.format(expireDate);
		
		MimeMessage msg = javaMailSender.createMimeMessage();
		try {
			String msgHTML = "<b>Hi "+user.getUsername() + ".</b><br><br>Click the link to activate your Home Game Poker account:<br>" + activationLink+"<br><br><i>This link will expire: " + expireDateString+"</i>";
			MimeMessageHelper helper = new MimeMessageHelper(msg, true);
			helper.setSubject("Home Game Poker - Account activation");
			helper.setTo(user.getUserDetails().getEmail());
			helper.setText(msgHTML, true);
			javaMailSender.send(msg);
		}catch (MessagingException e) {
			e.printStackTrace();
		}
			
	}
	
	public void sendForgotMail(User user)throws MailException{
		//send email
		
		String userID = user.getId().toString();
		String token = user.getVerificationToken().getToken();
		String forgotLink = forgotCommonURL +userID+"/" + token+".html";
		
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy HH:mm a");
			Date expireDate = user.getVerificationToken().getExpiryDate();
			String expireDateString = sdf.format(expireDate);
		
		MimeMessage msg = javaMailSender.createMimeMessage();
		try {
			String msgHTML = "<b>Hi "+user.getUsername() + ".</b><br><br>Click the link to change your password:<br>" + forgotLink+"<br><br><i>This link will expire: " + expireDateString+"</i>";
			MimeMessageHelper helper = new MimeMessageHelper(msg, true);
			helper.setSubject("Home Game Poker - Forgot password ?");
			helper.setTo(user.getUserDetails().getEmail());
			helper.setText(msgHTML, true);
			javaMailSender.send(msg);
		}catch (MessagingException e) {
			e.printStackTrace();
		}
			
	}

	public User saveToken(User user) {
		//You generate a unique confirmation ID to your applicaiton. The easiest way is to use java.util.UUID.randomUUID().toString(). UUID is a random globally unique value.;
		UUID genID = UUID.randomUUID();
		
		//System.out.println("ID:" + genID);
					 
		//You store the ID (e.g. 0123)+account to the database for future use;
		VerificationToken vt = new VerificationToken();
			vt.setToken(genID.toString());
			vt.setUser(user);
			vt.setExpiryDate(null);
			
			Date currentDate = new Date();
			Date expiryDate = calculateExpiryDate(currentDate);
			vt.setExpiryDate(expiryDate);
			vt.setIsActive(true);
			
			verificationTokenRepository.save(vt);
			
			user.setVerificationToken(vt);
			userRepository.save(user);

			return user;
			
		
	}
	
	 private Date calculateExpiryDate(Date currentDate) {
		 Date expiryDate = new Date();
		 Calendar cal = Calendar.getInstance();
		 cal.setTime(expiryDate);
		 cal.add(Calendar.DATE, 1);
		 expiryDate = cal.getTime();
	      
		 return expiryDate; 
	  }

	public Boolean checkActivationData(Integer userID, String token) {

		VerificationToken vt = verificationTokenRepository.findBytoken(token);
		
		if(vt != null){
			Boolean isExpire = checkExpireDate(vt.getExpiryDate());
			if(vt.getIsActive()){
				if(!isExpire){
					if(vt.getUser().getId().equals(userID)){
						return true;
					}
				}
			}
			
		}
			
		return false;
		
		
	}

	private Boolean checkExpireDate(Date expiryDate) {
		Date now = new Date();
		if(now.after(expiryDate)){
			return true;
		}
		return false;
		
	}

	public void unActiveToken(String token) {
		VerificationToken vt = verificationTokenRepository.findBytoken(token);
		if(vt != null){
			vt.setIsActive(false);
			verificationTokenRepository.save(vt);
		}
		
	}

	
	

}
