package br.com.votacao.votacao.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.votacao.votacao.documents.SessaoVotacao;

public interface SessaoVotacaoRepository extends MongoRepository<SessaoVotacao, String> {

}
