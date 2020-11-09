package br.com.everis.estacionamento.endpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.everis.estacionamento.model.Veiculo;
import br.com.everis.estacionamento.service.VeiculoService;

@RestController
@RequestMapping("/veiculo")
public class VeiculoEndpoint {
	
	@Autowired
	private VeiculoService veiculoService;
	
	@PostMapping("salvar")
	public Veiculo salvar(Veiculo veiculo) {
		return veiculoService.salvar(veiculo);
	}
	
	@GetMapping("buscar")
	public List<Veiculo> buscar() {
		return veiculoService.buscarTodos();
	}
	
	@GetMapping
	public Veiculo buscarPorId(Veiculo veiculo) {
		return veiculoService.buscarPorId(veiculo);
	}
}
