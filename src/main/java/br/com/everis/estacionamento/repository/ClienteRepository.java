package br.com.everis.estacionamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.everis.estacionamento.model.Cliente;
import br.com.everis.estacionamento.model.Veiculo;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

	
}
