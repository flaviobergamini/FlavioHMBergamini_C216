package br.inatel.labs.labrest_client;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import br.inatel.labs.labrest_client.model.Curso;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CursoControllerTest {
	
	@Autowired
	private WebTestClient webTestClient;
	
	@Test
	void deveListarCursos() {
		webTestClient.get()
		.uri("/curso")
		.exchange()
		.expectStatus()
		.isOk()
		.expectBody()
		.returnResult();
	}

	@Test
	void dadoCursoIdValido_quandoGetCursoPeloId_entaoResponseComCursoCValido() {
		Long cursoIdValido = 1L;
		
		Curso cursoRespondido = webTestClient.get()
				.uri("/curso/" + cursoIdValido)
				.exchange()
				.expectStatus().isOk()
				.expectBody(Curso.class)
				.returnResult()
				.getResponseBody();
		
		assertNotNull(cursoRespondido);
		assertEquals(cursoRespondido.getId(), cursoIdValido);
	}
	
	@Test
	void dadoCursoIdValido_quandoGetCursoPeloId_entaoResponseComStatusNotFound() {
		Long cursoIdValido = 99L;
		
		Curso cursoRespondido = (Curso) webTestClient.get()
				.uri("/curso/" + cursoIdValido)
				.exchange()
				.expectStatus().isNotFound();
	}
	
	@Test
	void dadoCursoIdValido_quandoGetCursoPeloId_entaoResponseComStatusCreatedCursoValido() {
		Curso novoCurso = new Curso();
		novoCurso.setDescricao("Testando REST com Spring WebFlux");
		novoCurso.setCargaHoraria(120);
		
		Curso cursoRespondido = webTestClient.post()
				.bodyValue(novoCurso)
				.exchange()
				.expectStatus()
				.isCreated()
				.expectBody(Curso.class)
				.returnResult()
				.getResponseBody();
		
		assertThat(cursoRespondido).isNotNull();
		assertThat(cursoRespondido.getId()).isNotNull();
	}
	
	@Test
	void dadoCursoIdValido_quandoPutCurso_entaoResponseComStatusAccepted() {
		Curso cursoExistente = new Curso();
		cursoExistente.setId(1L);
		cursoExistente.setDescricao("Nova descrição para atualização");
		cursoExistente.setCargaHoraria(123);
		
		webTestClient.put()
		.uri("/curso")
		.bodyValue(cursoExistente)
		.exchange()
		.expectStatus()
		.isAccepted()
		.expectBody()
		.isEmpty();
	}
	
	@Test
	void dadoCursoIdValido_quandoDeleteCursoPeloId_entaoResponseComStatusNoContent() {
		Long cursoIdValido = 2L;
		
		webTestClient.delete()
		.uri("/curso/" + cursoIdValido)
		.exchange()
		.expectStatus()
		.isNoContent()
		.expectBody()
		.isEmpty();
	}
	
	@Test
	void dadoCursoIdValido_quandoDeleteCursoPeloId_entaoResponseComStatusNotFound() {
		Long cursoIdValido = 99L;
		
		webTestClient.delete()
		.uri("/curso/" + cursoIdValido)
		.exchange()
		.expectStatus()
		.isNotFound();
	}
}
