package br.com.everis.estacionamento.endpoint;


import static io.restassured.module.mockmvc.RestAssuredMockMvc.standaloneSetup;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import br.com.everis.estacionamento.service.ClienteService;


@SpringBootTest
public class ClienteEndpointTest {
	
	@Autowired
	private ClienteEndpoint clienteEndpoint;
	
	@MockBean
	private ClienteService clienteService;
	
	@BeforeEach
	public void configuracao() {
		standaloneSetup(this.clienteEndpoint);
	}
	
	
	
	@Test
	public void deveRetornarClientes(){
		
		
	}

}
