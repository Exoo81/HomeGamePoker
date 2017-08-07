package com.exoo.hgp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exoo.hgp.entity.UserDetails;

public interface UserDetailsRepository extends JpaRepository<UserDetails, Integer> {

	UserDetails findByEmail(String email);

	

}
