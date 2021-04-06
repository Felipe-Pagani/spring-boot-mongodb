package com.treinamentoapi.workshopspringbootmongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.treinamentoapi.workshopspringbootmongodb.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{

}


