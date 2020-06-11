package br.com.votacao.votacao.services;

import java.util.List;

import br.com.votacao.votacao.documents.Associados;
import br.com.votacao.votacao.documents.SessaoVotacao;

public interface SessaoVotacaoService {
    List<SessaoVotacao> listarTodas();

    SessaoVotacao listarPorId(String id);

    SessaoVotacao listarPorStatus(String status);

    SessaoVotacao cadastrar(SessaoVotacao sessaovotacao);

    SessaoVotacao atualizar(SessaoVotacao sessaovotacao);
}
