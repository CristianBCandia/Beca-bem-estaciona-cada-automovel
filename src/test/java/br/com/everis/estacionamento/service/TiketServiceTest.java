package br.com.everis.estacionamento.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalTime;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class TiketServiceTest {
	
	
	//Variaveis úteis.
	LocalTime horaAgora = LocalTime.of(7, 40);
	LocalTime horaAntiga = LocalTime.of(7, 30);
	final Integer diferencaEntreHoras = horaAgora.getHour() - horaAntiga.getHour();
	final Integer diferencaEntreMinutos = horaAgora.getMinute() - horaAntiga.getMinute();
	
	
	
	@Test
	public void deveCalcularPeriodoEntreHoraSaidaEHoraEntrada() {
		assertEquals(0, diferencaEntreHoras);	
	}
	
	@Test
	public void deveCalcularADiferencaEntreMinutosDeEntradaESaida() {
		assertEquals(10,diferencaEntreMinutos);
	}
	
	@Test
	public void deveTestarSeClienteEstacionouPorMenosDeQuinzeMinutos() {
		if(diferencaEntreHoras == 0 && diferencaEntreMinutos > 0 && diferencaEntreMinutos <= 15) {
			throw new RuntimeException("Menos de 15 min de estacionamento. \nSaida livre!");
		}
		
	}
}
	
	
	