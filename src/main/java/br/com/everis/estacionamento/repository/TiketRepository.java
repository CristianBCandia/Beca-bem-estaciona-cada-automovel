package br.com.everis.estacionamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.everis.estacionamento.model.Tiket;

public interface TiketRepository extends JpaRepository<Tiket, Long>{

}
