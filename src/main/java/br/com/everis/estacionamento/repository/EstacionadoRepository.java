package br.com.everis.estacionamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.everis.estacionamento.model.Estacionado;

public interface EstacionadoRepository extends JpaRepository<Estacionado, Long>{

}
