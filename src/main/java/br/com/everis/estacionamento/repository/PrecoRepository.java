package br.com.everis.estacionamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.everis.estacionamento.model.Preco;

public interface PrecoRepository extends JpaRepository<Preco, String>{

}
