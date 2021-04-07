package com.treinamentoapi.workshopspringbootmongodb.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.treinamentoapi.workshopspringbootmongodb.domain.User;
import com.treinamentoapi.workshopspringbootmongodb.repository.UserRepository;


@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		
		
		userRepository.deleteAll();

		User maria = new User(null, "maria brown", "mariaBrown@hotmail.com");
		User alex = new User(null, "Alex souza", "alexSouza@gmail.com");
		User lucas = new User(null, "Lucas palloti", "lucasPalloti@ig.com");

		userRepository.saveAll(Arrays.asList(maria, alex, lucas));

	}

}
