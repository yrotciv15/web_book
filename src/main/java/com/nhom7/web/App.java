package com.nhom7.web;

import javax.transaction.Transactional;

import com.nhom7.web.repository.UserRepository;
import com.nhom7.web.service.OrderService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RequiredArgsConstructor
public class App implements CommandLineRunner {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	private final UserRepository userRepository;
	private final OrderService orderService;
	
	@Override
	@Transactional
	public void run(String... args) throws Exception {
		
		
	}

}
