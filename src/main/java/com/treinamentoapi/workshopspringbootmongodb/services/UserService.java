package com.treinamentoapi.workshopspringbootmongodb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.treinamentoapi.workshopspringbootmongodb.domain.User;
import com.treinamentoapi.workshopspringbootmongodb.repository.UserRepository;


@Service
public class UserService {
	
	
	//Faz a instanciação de um objeto automaticamente
	@Autowired
	private UserRepository userRepository;

	
	public List<User> findAll(){
		return userRepository.findAll();
		
		
		
	}
	
	

}
