package com.exoo.hgp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exoo.hgp.entity.User;
import com.exoo.hgp.entity.UserDetails;
import com.exoo.hgp.repository.UserDetailsRepository;
import com.exoo.hgp.repository.UserRepository;
import com.exoo.hgp.utility.UserRegistrationWrapper;

@Service
@Transactional
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserDetailsRepository userDetailsRepository;
	
	public List<User> findAll(){
		return userRepository.findAll();
	}

	public void save(UserRegistrationWrapper newUser) {
		System.out.println("new user !!");
		
	}

	public User findOne(String username) {
		return userRepository.findByUsername(username);
	
	}

	public UserDetails findOneEmail(String email) {
		return userDetailsRepository.findByEmail(email);
	}

}
