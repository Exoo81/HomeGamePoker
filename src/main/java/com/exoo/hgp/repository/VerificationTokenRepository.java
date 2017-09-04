package com.exoo.hgp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exoo.hgp.entity.VerificationToken;

public interface VerificationTokenRepository  extends JpaRepository<VerificationToken, Long>{

	VerificationToken findBytoken(String token);

}
