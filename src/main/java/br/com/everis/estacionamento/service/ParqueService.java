package br.com.everis.estacionamento.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.everis.estacionamento.excecoes.CapacidadeTotalException;
import br.com.everis.estacionamento.excecoes.EstacionamentoLotadoException;
import br.com.everis.estacionamento.model.Parque;
import br.com.everis.estacionamento.repository.ParqueRepository;

@Service
public class ParqueService {
	
	@Autowired
	ParqueRepository repository;
	
	public Parque registrarCapacidade(Parque parque) {
		return repository.save(parque);
	}
	
	public Parque buscarParque() {
		return repository.findAll().get(0);
	}
	
	/**
	 * @author Cristian Bittencourt Candia
	 * @return Diminui em uma vaga a capacidade do estacionamento ou 
	 * lança uma exceção caso o estacionamento esteja vazio.
	 */
	public Parque diminuirCapacidadeEmUm() {
		
		Parque parqueVindoDoBanco = repository.findAll().get(0);
		
		if(parqueVindoDoBanco.getId() == null) {
			throw new NullPointerException("Erro, id não encontrado.");
		}else if(parqueVindoDoBanco.getCapacidade() <= 0) {
			parqueVindoDoBanco.setCapacidade(0);
			throw new CapacidadeTotalException("CAPACIDADE TOTAL! Não é possivel reduzir a capacidade.");
		}
		parqueVindoDoBanco.setCapacidade(parqueVindoDoBanco.getCapacidade() - 1);
		return parqueVindoDoBanco;
	}
	
	/**
	 * @author Cristian Bittencourt Candia
	 * @return Aumenta em uma vaga a capacidade do estacionamento ou 
	 * lança uma exceção caso o estacionamento esteja lotado.
	 */
	public Parque aumentarCapacidadeEmUm() {
		
		Parque parqueVindoDoBanco = repository.findAll().get(0);
		
		if(parqueVindoDoBanco.getId() == null) {
			throw new NullPointerException("Erro, id não encontrado.");
		}else if(parqueVindoDoBanco.getCapacidade() <= 0) {
			parqueVindoDoBanco.setCapacidade(0);
			throw new EstacionamentoLotadoException("ESTACIONAMENTO LOTADO! Aguarde a saída de um veículo.");
		}
		parqueVindoDoBanco.setCapacidade(parqueVindoDoBanco.getCapacidade() + 1);
		return parqueVindoDoBanco;
	}
	
}
