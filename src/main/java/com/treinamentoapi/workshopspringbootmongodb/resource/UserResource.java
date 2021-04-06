package com.treinamentoapi.workshopspringbootmongodb.resource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.treinamentoapi.workshopspringbootmongodb.entities.User;

@RestController
//Indicando o caminho do endpoint	
@RequestMapping(value = "/users")
public class UserResource {

//	@RequestMapping(method = RequestMethod.GET) ou
	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		User felipe = new User("1", "Felipe Pagani", "feh.pagani@gmail.com");
		User alex = new User("2", "Alex silva", "AlexSilva@gmail.com");
		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(felipe, alex));
		return ResponseEntity.ok().body(list);
	}
}
