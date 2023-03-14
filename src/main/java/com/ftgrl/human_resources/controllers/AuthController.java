package com.ftgrl.human_resources.controllers;

import javax.validation.Valid;

import com.ftgrl.human_resources.models.Employee;
import com.ftgrl.human_resources.models.HumanResourceUser;
import com.ftgrl.human_resources.services.interfaces.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth/")
public class AuthController {


	private AuthService authService;
	
	@Autowired
	public AuthController( AuthService authService) {
		this.authService = authService;
	}
	
	@PostMapping("register/employee")
	public ResponseEntity<String> register(@RequestBody @Valid Employee employee){
		this.authService.register(employee);
		
		return new ResponseEntity<String>("Employee kayıt işlemi başarılı", HttpStatus.CREATED);
	}
	
	@PostMapping("register/admin")
	public ResponseEntity<String> register(@RequestBody @Valid HumanResourceUser humanResourceUser){
		
		this.authService.register(humanResourceUser);
		
		return new ResponseEntity<String>("İnsan Kaynakları Yöneticisi kayıt işlemi başarılı", HttpStatus.CREATED);
	}
}
