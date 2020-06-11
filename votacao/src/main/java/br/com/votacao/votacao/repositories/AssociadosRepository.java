package br.com.votacao.votacao.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.votacao.votacao.documents.Associados;

public interface AssociadosRepository extends MongoRepository<Associados, String> {

}