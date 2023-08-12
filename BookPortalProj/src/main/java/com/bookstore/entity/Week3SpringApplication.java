package com.bookstore.entity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication(
		exclude = {
		//HibernateJpaAutoConfiguration.class,
		//DataSourceAutoConfiguration.class,
		//SecurityAutoConfiguration.class
		//DataSourceTransactionManagerAutoConfiguration.class
        }
		)
public class Week3SpringApplication implements WebMvcConfigurer {
	public static void main(String[] args) {
		SpringApplication.run(Week3SpringApplication.class, args);
	}
}
