package com.academy.mailserver;

import com.academy.mailserver.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MailServerApplication {

	@Autowired
	public static void main(String[] args) {
		SpringApplication.run(MailServerApplication.class, args);
		System.out.println("http://localhost:9991/swagger-ui/");
		System.out.println("http://localhost:9991/h2-console");

	}

}
