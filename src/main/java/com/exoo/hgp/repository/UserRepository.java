package com.exoo.hgp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exoo.hgp.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findByUsername(String username);



}
