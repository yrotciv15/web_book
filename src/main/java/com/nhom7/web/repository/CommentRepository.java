package com.nhom7.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nhom7.web.entity.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {
	
}

