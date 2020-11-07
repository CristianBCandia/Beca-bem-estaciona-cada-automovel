package br.com.everis.estacionamento.model;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Estacionado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate data_entrada;

	@JsonFormat(pattern = "HH:mm:ss")
	private LocalTime hora_entrada;

	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate data_saida;

	@JsonFormat(pattern = "HH:mm:ss")
	private LocalTime hora_saida;

	@OneToOne
	private Parque parque;
	
	@OneToOne
	private Veiculo veiculo;

	public Estacionado() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getData_entrada() {
		return data_entrada;
	}

	public void setData_entrada(LocalDate data_entrada) {
		this.data_entrada = data_entrada;
	}

	public LocalTime getHora_entrada() {
		return hora_entrada;
	}

	public void setHora_entrada(LocalTime hora_entrada) {
		this.hora_entrada = hora_entrada;
	}

	public LocalDate getData_saida() {
		return data_saida;
	}

	public void setData_saida(LocalDate data_saida) {
		this.data_saida = data_saida;
	}

	public LocalTime getHora_saida() {
		return hora_saida;
	}

	public void setHora_saida(LocalTime hora_saida) {
		this.hora_saida = hora_saida;
	}

	public Parque getParque() {
		return parque;
	}

	public void setParque(Parque parque) {
		this.parque = parque;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

}
