package com.lmig.gfc.invoicify.services;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lmig.gfc.invoicify.models.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByUsername(String username);
}
