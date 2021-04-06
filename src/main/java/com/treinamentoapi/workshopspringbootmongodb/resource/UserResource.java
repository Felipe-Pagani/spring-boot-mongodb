package com.treinamentoapi.workshopspringbootmongodb.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.treinamentoapi.workshopspringbootmongodb.domain.User;
import com.treinamentoapi.workshopspringbootmongodb.services.UserService;

@RestController
//Indicando o caminho do endpoint	
@RequestMapping(value = "/users")
public class UserResource {
	
	
	@Autowired
	private UserService userService;

//	@RequestMapping(method = RequestMethod.GET) ou
	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		List<User> list = userService.findAll();
		return ResponseEntity.ok().body(list);
	}
}
