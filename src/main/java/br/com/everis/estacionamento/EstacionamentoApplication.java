package br.com.everis.estacionamento;

import java.time.LocalTime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EstacionamentoApplication {

	public static void main(String[] args) {
		SpringApplication.run(EstacionamentoApplication.class, args);
		
		LocalTime intervalo = LocalTime.parse("22:10").minusHours(LocalTime.parse("20:30").getHour()).minusMinutes(30);
		
		
		
		Double totalAPagarPorHoras = intervalo.getHour() * 5.0;
		Double totalApagarPorMinutos = (intervalo.getMinute()/ 30) * 3.0;
		
		
		System.out.println("Intervalo de tempo "+intervalo +"\n Total: "+ totalAPagarPorHoras + totalApagarPorMinutos);
	}
}
