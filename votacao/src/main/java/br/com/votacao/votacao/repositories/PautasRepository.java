package br.com.votacao.votacao.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.votacao.votacao.documents.Pautas;

public interface PautasRepository extends MongoRepository<Pautas, String> {

}