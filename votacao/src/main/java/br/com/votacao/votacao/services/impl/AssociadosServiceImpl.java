package br.com.votacao.votacao.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.votacao.votacao.documents.Associados;
import br.com.votacao.votacao.repositories.AssociadosRepository;
import br.com.votacao.votacao.services.AssociadosService;

@Service
public class AssociadosServiceImpl implements AssociadosService {
	
	@Autowired
	private AssociadosRepository associadosRespository;

	@Override
	public List<Associados> listarTodos() {
		return this.associadosRespository.findAll();
	}

	@Override
	public Associados listarPorId(String id) {
		return this.associadosRespository.findOne(id);
	}

	@Override
	public Associados cadastrar(Associados associados) {
		return this.associadosRespository.save(associados);
	}

	@Override
	public Associados atualizar(Associados associados) {
		return this.associadosRespository.save(associados);
	}

	@Override
	public void remover(String id) {
		this.associadosRespository.delete(id);
	}

}