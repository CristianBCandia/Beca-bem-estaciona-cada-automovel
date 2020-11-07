package br.com.everis.estacionamento.endpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.everis.estacionamento.model.Estacionado;
import br.com.everis.estacionamento.model.Tiket;
import br.com.everis.estacionamento.service.EstacionadoService;

@RestController
@RequestMapping("/estacionado")
public class EstacionadoEndpoint {

	@Autowired
	EstacionadoService estacionadoService;

	@PostMapping("salvar")
	public Estacionado registrarEntradaNoEstacionamento(Estacionado estacionado) {
		return estacionadoService.registrarEntrada(estacionado);
	}

	@RequestMapping
	public Tiket registrarSaidaDoEstacionamento(Estacionado estacionado) {
		return estacionadoService.registrarSaida(estacionado);
	}

	@GetMapping("buscar")
	public List<Estacionado> buscarTodosRegisrosDeEstacionamento() {
		return estacionadoService.buscarTodosRegistros();
	}
}
