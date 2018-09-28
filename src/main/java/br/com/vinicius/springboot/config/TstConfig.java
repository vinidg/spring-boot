package br.com.vinicius.springboot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.vinicius.springboot.service.DbService;

@Configuration
@Profile("tst")
public class TstConfig {

	@Autowired
	private DbService dbService;
	
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String strategy;

	@Bean
	public boolean instantiateDatabase() {
		
		if (!"create".equals(strategy)) {
			return false;
		}
		
		dbService.instatiateTestDatabase();
		return true;
	}
	
}
