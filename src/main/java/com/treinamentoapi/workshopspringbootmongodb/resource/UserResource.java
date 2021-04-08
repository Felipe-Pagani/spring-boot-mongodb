package com.treinamentoapi.workshopspringbootmongodb.resource;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.treinamentoapi.workshopspringbootmongodb.domain.User;
import com.treinamentoapi.workshopspringbootmongodb.dto.UserDTO;
import com.treinamentoapi.workshopspringbootmongodb.services.UserService;

@RestController
//Indicando o caminho do endpoint	
@RequestMapping(value = "/users")
public class UserResource {
	
	
	@Autowired
	private UserService userService;

	@RequestMapping(method = RequestMethod.GET) 
//	@GetMapping ou
	public ResponseEntity<List<UserDTO>> findAll() {
		List<User> list = userService.findAll();
		//Lista original -> função stream ->  Transforma a lista
		//em Stream que é uma coleção compativel com a expressão lambda, a partir do java 8 em diante.
		//metodo map -> pega cada object x da minha lista original e pra cada object eu retorno um new
		//UserDTO. passa o X como argumento, e depois volta essa stream para uma lista.
		//com o metodo collect(Collectors.toLitst().
		List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<UserDTO> findById(@PathVariable String id) {
		User obj = userService.findById(id);
		//Lista original -> função stream ->  Transforma a lista
		//em Stream que é uma coleção compativel com a expressão lambda, a partir do java 8 em diante.
		//metodo map -> pega cada object x da minha lista original e pra cada object eu retorno um new
		//UserDTO. passa o X como argumento, e depois volta essa stream para uma lista.
		//com o metodo collect(Collectors.toLitst().
		return ResponseEntity.ok().body(new UserDTO(obj));
	}
}
