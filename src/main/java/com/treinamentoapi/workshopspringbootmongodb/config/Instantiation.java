package com.treinamentoapi.workshopspringbootmongodb.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.treinamentoapi.workshopspringbootmongodb.domain.Post;
import com.treinamentoapi.workshopspringbootmongodb.domain.User;
import com.treinamentoapi.workshopspringbootmongodb.repository.PostRepository;
import com.treinamentoapi.workshopspringbootmongodb.repository.UserRepository;


@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "maria brown", "mariaBrown@hotmail.com");
		User alex = new User(null, "Alex souza", "alexSouza@gmail.com");
		User lucas = new User(null, "Lucas palloti", "lucasPalloti@ig.com");
		
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem!",
				"Vou viajar para São Paulo, Abraçõs", alex);
		Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia!", "Acordei feliz hoje!", maria);
		
		

		userRepository.saveAll(Arrays.asList(maria, alex, lucas));
		postRepository.saveAll(Arrays.asList(post1, post2));
		
		

		
	}

}
