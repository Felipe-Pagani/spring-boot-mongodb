package com.treinamentoapi.workshopspringbootmongodb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.treinamentoapi.workshopspringbootmongodb.domain.User;
import com.treinamentoapi.workshopspringbootmongodb.repository.UserRepository;
import com.treinamentoapi.workshopspringbootmongodb.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	// Faz a instanciação de um objeto automaticamente
	@Autowired
	private UserRepository userRepository;

	public List<User> findAll() {
		return userRepository.findAll();
	}

	public User findById(String id) {
		Optional<User> obj = userRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
		}
}
