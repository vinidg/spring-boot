package br.com.vinicius.springboot.config;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@ComponentScan(basePackages = { "br.com.vinicius.springboot.controller", 
		"br.com.vinicius.springboot.service", "br.com.vinicius.springboot.config", "br.com.vinicius.springboot.security" })
@EnableMongoRepositories("br.com.vinicius.springboot.repositories")
@EntityScan("br.com.vinicius.springboot.domain")
public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	@PostConstruct
    public void run() throws Exception {
    }
}
