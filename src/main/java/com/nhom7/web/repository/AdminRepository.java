package com.nhom7.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nhom7.web.entity.Account;
import com.nhom7.web.entity.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {
	Admin findByAccount(Account account);
}
