package br.com.vinicius.springboot.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages={"br.com.vinicius.springboot.controller"})
public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
	
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String strategy;
	
	@Bean
	public boolean instantiateDatabase() throws ParseException {
		
		if (!"create".equals(strategy)) {
			return false;
		}
		
		return true;
	}
	
}
