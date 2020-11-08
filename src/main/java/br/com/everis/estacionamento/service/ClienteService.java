package br.com.everis.estacionamento.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.everis.estacionamento.model.Cliente;
import br.com.everis.estacionamento.model.Veiculo;
import br.com.everis.estacionamento.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;

	public Cliente salvar(Cliente cliente) {
		return repository.save(cliente);
	}

	public Cliente buscarPorId(Cliente cliente) {
		return repository.findById(cliente.getId()).get();
	}

	public ArrayList<Cliente> buscarTodos() {
		return (ArrayList<Cliente>) repository.findAll();
	}

	public Cliente deletar(Cliente cliente) {
		repository.delete(cliente);
		return cliente;
	}

	public void verificaSeClienteExiste(Cliente cliente) {
		if (repository.findById(cliente.getId()).isEmpty()) {
			throw new NoSuchElementException("Cliente não encontrado para o id: " + cliente.getId());
		}
	}

}
