package br.inatel.labs.lab_rest_server.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class CursoNaoEncontradoException extends ResponseStatusException{
	
	private static final long serialVersionUID = -2503400944594581603L;

	public CursoNaoEncontradoException(Long cursoId) {
		super(HttpStatus.NOT_FOUND, String.format("Nenhum curso encontrado com o ID [%s]", cursoId));
	}

}
