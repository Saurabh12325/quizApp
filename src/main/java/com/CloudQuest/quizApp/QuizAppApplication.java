package com.CloudQuest.quizApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication
public class QuizAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuizAppApplication.class, args);
	}

}
