package br.com.votacao.votacao.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.votacao.votacao.documents.Votos;

public interface VotosRepository extends MongoRepository<Votos, String> {

}