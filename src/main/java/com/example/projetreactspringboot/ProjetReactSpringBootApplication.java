package com.example.projetreactspringboot;

import com.example.projetreactspringboot.controller.ContentRestController;
import com.example.projetreactspringboot.controller.UserRestController;
import com.example.projetreactspringboot.model.Content;
import com.example.projetreactspringboot.model.User;
import com.example.projetreactspringboot.repository.ContentRepository;
import com.example.projetreactspringboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjetReactSpringBootApplication implements CommandLineRunner {

	@Autowired
	private UserRestController userRestController;

	@Autowired
	private ContentRestController contentRestController;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ContentRepository contentRepository;


	public static void main(String[] args) {
		SpringApplication.run(ProjetReactSpringBootApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

//		User user1 = new User("Steeve","0123456789","steeve@monmail.com");
//		User user2 = new User("Nicolas","0123456789","nicolas@monmail.com");
//		User user3 = new User("Julie","0123456789","julie@monmail.com");
//
//
//		userRepository.save(user1);
//		userRepository.save(user2);
//		userRepository.save(user3);
//
//
////		userRestController.add(user1);
////		userRestController.add(user2);
////		userRestController.add(user3);
//
//		Content content1= new Content("content1");
//		Content content2= new Content("content2");
//		Content content3= new Content("content3");
//
//		contentRepository.save(content1);
//		contentRepository.save(content2);
//		contentRepository.save(content3);
//
//
////		contentRestController.add(content1);
////		contentRestController.add(content2);
////		contentRestController.add(content3);
//
//

	}
}
