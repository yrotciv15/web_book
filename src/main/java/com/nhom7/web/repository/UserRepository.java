package com.nhom7.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nhom7.web.entity.Account;
import com.nhom7.web.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	User findByName(String name);
	User findByAccount(Account account);
}
