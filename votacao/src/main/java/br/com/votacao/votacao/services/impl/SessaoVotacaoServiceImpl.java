package br.com.votacao.votacao.services.impl;

import java.util.List;

import br.com.votacao.votacao.documents.Votos;
import br.com.votacao.votacao.repositories.VotosRepository;
import br.com.votacao.votacao.services.SessaoVotacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.votacao.votacao.documents.SessaoVotacao;
import br.com.votacao.votacao.repositories.SessaoVotacaoRepository;
import br.com.votacao.votacao.services.SessaoVotacaoService;

public class SessaoVotacaoServiceImpl implements SessaoVotacaoService {
    @Autowired
    private SessaoVotacaoRepository sessaovotacaoRespository;

    @Override
    public List<SessaoVotacao> listarTodas() {
        return this.sessaovotacaoRespository.findAll();
    }

    @Override
    public SessaoVotacao listarPorId(String id) {
        return this.sessaovotacaoRespository.findOne(id);
    }

    @Override
    public SessaoVotacao listarPorStatus(String status) {
        return this.sessaovotacaoRespository.findOne(status);
    }

    @Override
    public SessaoVotacao cadastrar(SessaoVotacao sessaovotacao) {
        return this.sessaovotacaoRespository.save(sessaovotacao);
    }
}
