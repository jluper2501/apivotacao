package br.com.votacao.votacao.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.votacao.votacao.documents.Votos;
import br.com.votacao.votacao.repositories.VotosRepository;
import br.com.votacao.votacao.services.VotosService;

public class VotosServiceImpl implements VotosService {
	
	@Autowired
	private VotosRepository votosRespository;

	@Override
	public List<Votos> listarTodos() {
		return this.votosRespository.findAll();
	}

	@Override
	public Votos listarPorId(String id) {
		return this.votosRespository.findOne(id);
    }
    
    @Override
	public Votos listarPorVoto(String voto) {
		return this.votosRespository.findOne(voto);
	}

	@Override
	public Votos cadastrar(Votos votos) {
		return this.votosRespository.save(votos);
	}

}