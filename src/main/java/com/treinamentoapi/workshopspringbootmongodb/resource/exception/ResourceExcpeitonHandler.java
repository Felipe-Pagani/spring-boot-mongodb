package com.treinamentoapi.workshopspringbootmongodb.resource.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.treinamentoapi.workshopspringbootmongodb.services.exception.ObjectNotFoundException;


//essa classe e responsavel para tratar possiveis erros nas minhas requisições
@ControllerAdvice
public class ResourceExcpeitonHandler {
	
	
	//indentifica a exception e fazer o tratamento a baixo
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> ObjectNotFound(ObjectNotFoundException e, HttpServletRequest request){
		
		//tratando erros.
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(System.currentTimeMillis(), status.value(), "Não encontrado",
				e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	
	}
	
	
	

}
