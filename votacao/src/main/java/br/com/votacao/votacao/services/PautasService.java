package br.com.votacao.votacao.services;

import java.util.List;

import br.com.votacao.votacao.documents.Pautas;

public interface PautasService {
	
	List<Pautas> listarTodas();
	
	Pautas listarPorId(String id);
	
	Pautas cadastrar(Pautas pautas);
	
	Pautas atualizar(Pautas pautas);
	
	void remover(String id);

}
