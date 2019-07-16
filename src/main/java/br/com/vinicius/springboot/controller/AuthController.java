package br.com.vinicius.springboot.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.vinicius.springboot.dto.UserDTO;
import br.com.vinicius.springboot.security.JWTUtil;
import br.com.vinicius.springboot.security.UserSS;
import br.com.vinicius.springboot.service.AuthService;
import br.com.vinicius.springboot.service.UserService;

@RestController
@RequestMapping(value = "/auth")
public class AuthController {

	@Autowired
	private JWTUtil jwtUtil;
	
	@Autowired
	private AuthService service;

	@RequestMapping(value = "/refresh_token", method = RequestMethod.POST)
	public ResponseEntity<Void> refreshToken(HttpServletResponse response) {
		UserSS user = UserService.authenticated();
		String token = jwtUtil.generateToken(user.getUsername());
		response.addHeader("Authorization", "Bearer " + token);
		response.addHeader("access-control-expose-headers", "Authorization");
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/forgot", method = RequestMethod.POST)
	public ResponseEntity<Void> forgot(@RequestBody UserDTO dto) {
		service.sendNewPassword(dto.getUser());
		return ResponseEntity.noContent().build();
	}	

}
