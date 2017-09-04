package com.exoo.hgp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exoo.hgp.entity.Role;
import com.exoo.hgp.entity.User;
import com.exoo.hgp.entity.UserDetails;
import com.exoo.hgp.repository.RoleRepository;
import com.exoo.hgp.repository.UserDetailsRepository;
import com.exoo.hgp.repository.UserRepository;
import com.exoo.hgp.repository.VerificationTokenRepository;
import com.exoo.hgp.utility.UserRegistrationWrapper;

@Service
@Transactional
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserDetailsRepository userDetailsRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private VerificationTokenService verificationTokenService;
	
	public List<User> findAll(){
		return userRepository.findAll();
	}

	public User save(UserRegistrationWrapper newUser) {
		User user = new User();
			user.setUsername(newUser.getUsername());
			user.setPassword(newUser.getPassword());
			user.setEnabled(false);
			List<Role> userRoleList = new ArrayList<Role>();
				userRoleList.add(roleRepository.findByRoleName("ROLE_PLAYER"));
			user.setRoles(userRoleList);
		userRepository.save(user);
		
		UserDetails ud = new UserDetails();
			ud.setEmail(newUser.getEmail());
			ud.setUser(user);
		userDetailsRepository.save(ud);
		
		User userFull = userRepository.findByUsername(user.getUsername());
		UserDetails ud1 = userDetailsRepository.findByUser(userFull);
			userFull.setUserDetails(ud1);
		
		return userFull;
	}

	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	
	}

	public UserDetails findOneEmail(String email) {
		return userDetailsRepository.findByEmail(email);
	}


	public void enabledAccount(Integer userID) {
		User user = userRepository.findOne(userID);
		user.setEnabled(true);
		userRepository.save(user);
		
	}

	public User findUserByEmail(String email) {
		UserDetails userDetail = userDetailsRepository.findByEmail(email);
		/*System.out.println(userDetail.getUser().getUsername());
		System.out.println(userDetail.getUser().getPassword());
		System.out.println(userDetail.getFirstName());
		System.out.println(userDetail.getLastName());
		System.out.println(userDetail.getAddress());*/
		User user = userDetail.getUser();
		
		return user;
	}

	public User findByID(Integer userID) {
		User user = userRepository.findOne(userID);
		return user;
	}

	public void changePassword(String password, String repeatPassword,
			Integer userID) {
		
		User user = userRepository.findOne(userID);
		if(user != null){
			//check pass equal
			if(password.equals(repeatPassword)){
				user.setPassword(password);
				userRepository.save(user);
			}
		}
		
	}

}
