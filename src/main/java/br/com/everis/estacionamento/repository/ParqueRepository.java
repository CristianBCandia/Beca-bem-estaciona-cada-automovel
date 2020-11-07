package br.com.everis.estacionamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.everis.estacionamento.model.Parque;

public interface ParqueRepository extends JpaRepository<Parque, Long>{

}
