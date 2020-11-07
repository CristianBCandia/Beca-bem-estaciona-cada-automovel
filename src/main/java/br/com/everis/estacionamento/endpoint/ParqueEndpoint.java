package br.com.everis.estacionamento.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.everis.estacionamento.model.Parque;
import br.com.everis.estacionamento.service.ParqueService;

@RestController
@RequestMapping("/parque")
public class ParqueEndpoint {

	@Autowired
	ParqueService parqueService;

	@PostMapping("salvar")
	public Parque salvar(Parque parque) {
		return parqueService.registrarCapacidade(parque);
	}

}
