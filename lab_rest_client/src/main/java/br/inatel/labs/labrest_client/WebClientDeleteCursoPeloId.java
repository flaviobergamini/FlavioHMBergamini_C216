package br.inatel.labs.labrest_client;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.reactive.function.client.WebClient;

public class WebClientDeleteCursoPeloId {
	public static void main(String[] args) {
		ResponseEntity<Void> responseEntity = WebClient.create("http://localhost:8080")
				.delete()
				.uri("/curso")
				.retrieve()
				.toBodilessEntity()
				.block();
		
		HttpStatus statusCode = responseEntity.getStatusCode();
		
		System.out.println("Curso removido. Status da resposta: " + statusCode);
	}
}
