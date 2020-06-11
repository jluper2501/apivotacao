package br.com.votacao.votacao.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.votacao.votacao.documents.Pautas;
import br.com.votacao.votacao.repositories.PautasRepository;
import br.com.votacao.votacao.services.PautasService;

@Service
public class PautasServiceImpl implements PautasService {
	
	@Autowired
	private PautasRepository pautasRespository;

	@Override
	public List<Pautas> listarTodas() {
		return this.pautasRespository.findAll();
	}

	@Override
	public Pautas listarPorId(String id) {
		return this.pautasRespository.findOne(id);
	}

	@Override
	public Pautas cadastrar(Pautas pautas) {
		return this.pautasRespository.save(pautas);
	}

	@Override
	public Pautas atualizar(Pautas pautas) {
		return this.pautasRespository.save(pautas);
	}

	@Override
	public void remover(String id) {
		this.pautasRespository.delete(id);
	}

}