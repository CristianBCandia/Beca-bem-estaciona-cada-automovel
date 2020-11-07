package br.com.everis.estacionamento.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Preco {

	@Id
	private String tipoVeiculo;
	
	private Double precoHora;
	
	private Double precoHoraFracao;

	public Preco() {
	}

	public String getTipoVeiculo() {
		return tipoVeiculo;
	}

	public void setTipoVeiculo(String tipoVeiculo) {
		this.tipoVeiculo = tipoVeiculo;
	}

	public Double getPrecoHora() {
		return precoHora;
	}

	public void setPrecoHora(Double precoHora) {
		this.precoHora = precoHora;
	}

	public Double getPrecoHoraFracao() {
		return precoHoraFracao;
	}

	public void setPrecoHoraFracao(Double precoHoraFracao) {
		this.precoHoraFracao = precoHoraFracao;
	}

}
