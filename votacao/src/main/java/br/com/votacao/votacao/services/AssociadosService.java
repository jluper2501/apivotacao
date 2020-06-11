package br.com.votacao.votacao.services;

import java.util.List;

import br.com.votacao.votacao.documents.Associados;

public interface AssociadosService {
	
	List<Associados> listarTodos();
	
	Associados listarPorId(String id);
	
	Associados cadastrar(Associados associados);
	
	Associados atualizar(Associados associados);
	
	void remover(String id);

}