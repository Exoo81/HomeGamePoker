package com.exoo.hgp.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exoo.hgp.entity.Role;
import com.exoo.hgp.entity.User;
import com.exoo.hgp.repository.RoleRepository;
import com.exoo.hgp.repository.UserDetailsRepository;
import com.exoo.hgp.repository.UserRepository;



@Service
public class InitDB {
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserDetailsRepository userDetailsRepository;
	
	
	@PostConstruct
	public void init(){
		//createDB();
	}
	
	private void createDB(){
		
		Role adminRole = new Role();
		adminRole.setRoleName("ROLE_ADMIN");
		roleRepository.save(adminRole);
		
		Role playerRole = new Role();
		playerRole.setRoleName("ROLE_PLAYER");
		roleRepository.save(playerRole);
		
		User adminUser = new User();
		adminUser.setUsername("exoodb");
		adminUser.setPassword("klocek123");
		List<Role> adminRolesList = new ArrayList<Role>();
			adminRolesList.add(adminRole);
			adminRolesList.add(playerRole);
		
		adminUser.setRoles(adminRolesList);
		userRepository.save(adminUser);
		
	}
}
