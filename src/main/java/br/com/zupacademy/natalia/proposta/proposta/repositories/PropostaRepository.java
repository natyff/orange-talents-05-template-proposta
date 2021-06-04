package br.com.zupacademy.natalia.proposta.proposta.repositories;

import br.com.zupacademy.natalia.proposta.proposta.entities.Proposta;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PropostaRepository extends CrudRepository<Proposta, Long> {

   Optional<Proposta> findByDocumento(String documento);
}
