package br.com.votacao.votacao.services;

import java.util.List;

import br.com.votacao.votacao.documents.Votos;

public interface VotosService<Votos> {
	
    List<Votos> listarTodos();
    
    Votos listarPorId(String id);
	
	Votos listarPorVoto(String voto);
	
	Votos cadastrar(Votos votos);
	
}