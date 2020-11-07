package br.com.everis.estacionamento.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.everis.estacionamento.model.Preco;
import br.com.everis.estacionamento.model.Veiculo;
import br.com.everis.estacionamento.service.PrecoService;

@RestController
@RequestMapping("/preco")
public class PrecoEndpoint {
	
	@Autowired
	PrecoService precoService;
	
	@PostMapping("salvar")
	public Preco salvar(Preco preco) {
		return precoService.salvar(preco);
	}
	
	@GetMapping("buscar")
	public Preco buscar(Veiculo veiculo){
		return precoService.buscar(veiculo);
	}
}
