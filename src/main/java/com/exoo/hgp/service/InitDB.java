package com.exoo.hgp.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exoo.hgp.entity.Role;
import com.exoo.hgp.entity.User;
import com.exoo.hgp.entity.UserDetails;
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
		createDB();
	}
	
	private void createDB(){
		
		/*ROLE*/
		Role adminRole = new Role();
		adminRole.setRoleName("ROLE_ADMIN");
		roleRepository.save(adminRole);
		
		Role playerRole = new Role();
		playerRole.setRoleName("ROLE_PLAYER");
		roleRepository.save(playerRole);
		
		/*USER*/
		User adminUser = new User();
		adminUser.setUsername("exoo");
		adminUser.setPassword("klocek12");
		adminUser.setEnabled(true);
		List<Role> adminRolesList = new ArrayList<Role>();
			adminRolesList.add(adminRole);
			adminRolesList.add(playerRole);
		
		adminUser.setRoles(adminRolesList);
		userRepository.save(adminUser);
		
		/*USER DETAILS */
		UserDetails adminUserDetails = new UserDetails();
		adminUserDetails.setFirstName("Marcin");
		adminUserDetails.setLastName("P");
		adminUserDetails.setAddress("52 Coill Clocha, Oranmore, Galway");
		adminUserDetails.setEmail("exoodus81@gmail.com");
		adminUserDetails.setPhotoURL("");					//TODO setpgoto in db
		adminUserDetails.setUser(adminUser);
		userDetailsRepository.save(adminUserDetails);
		
	}
}
