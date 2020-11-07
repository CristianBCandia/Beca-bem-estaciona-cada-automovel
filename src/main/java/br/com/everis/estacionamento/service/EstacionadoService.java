package br.com.everis.estacionamento.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.everis.estacionamento.model.Estacionado;
import br.com.everis.estacionamento.model.Tiket;
import br.com.everis.estacionamento.repository.EstacionadoRepository;

/**
 * 
 * @author Cristian Bittencourt Candia
 * @version 0.0.1
 * 
 */
@Service
public class EstacionadoService {
	
	@Autowired
	private EstacionadoRepository repository;
	
	@Autowired
	PrecoService precoService;
	
	@Autowired
	TiketService tiketService;
	
	@Autowired
	ParqueService parqueService;
	
	/**
	 * @author Cristian Bittencourt Candia
	 * @param estacionado
	 * @return Retorna um Objeto com registro de entrada de um veículo no estacionamento, 
	 * com id do registro, data e hora de entrata, id do parque e id do veículo.
	 */
	public Estacionado registrarEntrada(Estacionado estacionado) {
		
		estacionado.setData_entrada(LocalDate.now());
		estacionado.setHora_entrada(LocalTime.now());
		estacionado.setParque(parqueService.buscarParque());
		parqueService.diminuirCapacidadeEmUm();
		
		return repository.save(estacionado);
	}
	
	/**
	 * @author Cristian Bittencourt Candia
	 * @param estacionado
	 * @return Retorna um Objeto "cupom de pagamento" com os dados do cliente, data e hora de saida e entrada
	 * dados do veículo, preço por hora e hora fração e preço total a ser pago.
	 */
	public Tiket registrarSaida(Estacionado estacionado) {
		
		Estacionado estacionadoSaindo = repository.findById(estacionado.getId()).get();
		Estacionado estacionadoSaindoRegistrado = registrarHoraSaida(registrarDataSaida(estacionadoSaindo));
		
		repository.save(estacionadoSaindoRegistrado);
		
		parqueService.aumentarCapacidadeEmUm();
		
		return tiketService.gerarCupomPagamento(estacionadoSaindoRegistrado);
	}
	
	/**
	 * 
	 * @author Cristian Bittencourt Candia
	 * @param estacionado
	 * @return Retorna um Objeto de Estacionado com hora de saída registrada.
	 */
	public Estacionado registrarHoraSaida(Estacionado estacionado) {	
			estacionado.setHora_saida(LocalTime.now());
			
			return estacionado;
	}
	
	/**
	 * @author Cristian Bittencourt Candia
	 * @param estacionado
	 * @return Registra a hora de saida e retorna um Objeto com todos os demais registros de 
	 * estacionamento.
	 */
	public Estacionado registrarDataSaida(Estacionado estacionado) {
		
		estacionado.setData_saida(LocalDate.now());
		
		return estacionado;	
	}
	
	/**
	 * @author Cristian Bittencourt Candia
	 * @param estacionado
	 * @return Retorna um Objeto com o registro de estacionamento.
	 */
	public Estacionado buscarRegistroPorId(Estacionado estacionado) {
		return repository.findById(estacionado.getId()).get();
	}
	
	/**
	 * @author Cristian Bittencourt Candia
	 * @return Retorna uma lista com todos os registros de estacionamento.
	 */
	public List<Estacionado> buscarTodosRegistros(){
		return (List<Estacionado>) repository.findAll();
	}
}
