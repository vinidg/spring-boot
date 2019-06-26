package br.com.vinicius.springboot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.vinicius.springboot.service.S3Service;

@SpringBootApplication
public class ApplicationDuarte implements CommandLineRunner {

	@Autowired
	private S3Service s3Service;

	public static void main(String[] args) {
		SpringApplication.run(ApplicationDuarte.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {

		s3Service.uploadFile("‪C:\\Users\\vduarteg\\Pictures\\print1.jpg");
	}

}
