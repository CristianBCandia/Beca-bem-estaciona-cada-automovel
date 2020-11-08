package br.com.everis.estacionamento.endpoint;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.everis.estacionamento.model.Cliente;
import br.com.everis.estacionamento.model.Estacionado;
import br.com.everis.estacionamento.model.Veiculo;
import br.com.everis.estacionamento.service.ClienteService;
import br.com.everis.estacionamento.service.EstacionadoService;

@RestController
@RequestMapping("/cliente")
public class ClienteEndpoint {

	@Autowired
	private ClienteService clienteService;

	@PostMapping("cadastrar")
	public Cliente cadastrar(Cliente cliente) {
		return clienteService.salvar(cliente);
	}

	@GetMapping("buscar")
	public Cliente buscarPorId(Cliente cliente) {
		return clienteService.buscarPorId(cliente);
	}

	@DeleteMapping("deletar")
	public Cliente deletar(Cliente cliente) {
		return clienteService.deletar(cliente);
	}

	@GetMapping
	public ArrayList<Cliente> buscarTodos() {
		return (ArrayList<Cliente>) clienteService.buscarTodos();
	}
}
