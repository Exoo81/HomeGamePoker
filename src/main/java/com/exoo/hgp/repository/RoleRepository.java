package com.exoo.hgp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exoo.hgp.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

	Role findByRoleName(String string);

}
