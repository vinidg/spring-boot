package br.com.vinicius.springboot.config;

import javax.annotation.PostConstruct;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = { "br.com.vinicius.springboot.controller", 
		"br.com.vinicius.springboot.service", "br.com.vinicius.springboot.config", "br.com.vinicius.springboot.security" })
@EnableJpaRepositories("br.com.vinicius.springboot.repository")
@EntityScan("br.com.vinicius.springboot.domain")
public class App {
	private static final Logger LOGGER = LogManager.getLogger(App.class);
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	@PostConstruct
    public void run() throws Exception {
		LOGGER.debug("Debugging log");
		LOGGER.info("Info log");
		LOGGER.warn("Hey, This is a warning!");
		LOGGER.error("Oops! We have an Error. OK");
		LOGGER.fatal("Damn! Fatal error. Please fix me.");
    }
}
