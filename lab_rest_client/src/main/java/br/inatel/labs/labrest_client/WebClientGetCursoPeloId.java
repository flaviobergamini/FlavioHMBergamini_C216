package br.inatel.labs.labrest_client;

import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import br.inatel.labs.labrest_client.model.Curso;
import reactor.core.publisher.Mono;

public class WebClientGetCursoPeloId {
	
	public static void main(String[] args) {
		
		try {
			Mono<Curso> monoCurso = WebClient.create("http://localhost:8080")
					.get()
					.uri("/curso/1")
					.retrieve()
					.bodyToMono(Curso.class);
			
			monoCurso.subscribe();
			
			Curso curso = monoCurso.block(); //Para bloquear Objetos mono
			
			System.out.println("Curso Encontrados: ");
			System.out.println(curso);
		}catch(WebClientResponseException e) {
			System.out.println("Status Code: " + e.getStatusCode());
		}
	}
}
