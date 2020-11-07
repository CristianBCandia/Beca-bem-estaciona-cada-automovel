package br.com.everis.estacionamento.excecoes;

@SuppressWarnings("serial")
public class CapacidadeTotalException extends RuntimeException{
	
	public CapacidadeTotalException(String msg) {
		super(msg);
	}
}
