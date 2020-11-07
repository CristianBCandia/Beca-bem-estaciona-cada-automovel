package br.com.everis.estacionamento.model.response;

import java.time.LocalDate;

public class MensagemDeErro {

	private LocalDate data;
	private String mensagem;

	public MensagemDeErro() {
	}

	public MensagemDeErro(LocalDate data, String mensagem) {
		super();
		this.data = data;
		this.mensagem = mensagem;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

}
