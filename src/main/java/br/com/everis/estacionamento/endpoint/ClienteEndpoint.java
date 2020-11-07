package br.com.everis.estacionamento.endpoint;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.everis.estacionamento.model.Cliente;
import br.com.everis.estacionamento.service.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteEndpoint {
	
	@Autowired
	private ClienteService clienteService;
	
	
	@PostMapping("salvar")
	public Cliente salvar(Cliente cliente) {
		return clienteService.salvar(cliente);
	}
	
	@GetMapping("buscar")
	public Cliente buscarPorId(Cliente cliente) {
		return clienteService.buscarPorId(cliente);
	}
	
	@DeleteMapping("deletar")
	public Cliente deletar(Cliente cliente){
		return clienteService.deletar(cliente);
	}
	
	@GetMapping
	public ArrayList<Cliente> buscarTodos() {
		return (ArrayList<Cliente>) clienteService.buscarTodos();
	}
}
