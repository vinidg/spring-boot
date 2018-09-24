package br.com.vinicius.springboot.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = { "br.com.vinicius.springboot.controller", "br.com.vinicius.springboot.service" })
@EnableJpaRepositories("br.com.vinicius.springboot.repository")
@EntityScan("br.com.vinicius.springboot.domain")
public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
