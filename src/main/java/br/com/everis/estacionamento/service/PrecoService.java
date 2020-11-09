package br.com.everis.estacionamento.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.everis.estacionamento.model.Preco;
import br.com.everis.estacionamento.model.Veiculo;
import br.com.everis.estacionamento.repository.PrecoRepository;

@Service
public class PrecoService {
	
	@Autowired
	PrecoRepository precoRepository;
	
	public Preco salvar(Preco preco) {
		return precoRepository.save(preco);
	}
	
	
	public Preco buscar(Veiculo veiculo) {
		return precoRepository.findById(veiculo.getTipoVeiculo()).get();
	}
}
