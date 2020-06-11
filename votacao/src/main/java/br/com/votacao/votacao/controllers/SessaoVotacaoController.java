package br.com.votacao.votacao.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import br.com.votacao.votacao.documents.SessaoVotacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.votacao.votacao.documents.SessaoVotacao;
import br.com.votacao.votacao.responses.Responses;
import br.com.votacao.votacao.services.SessaoVotacaoService;

@RequestMapping(path = "/api/v1/sessaovotacao")
public class SessaoVotacaoController {
    @Autowired
    private SessaoVotacaoService sessaovotacaoService;

    @GetMapping
    public Responses<Responses<List<SessaoVotacao>>> listarTodos() {
        return Responses.ok(new Responses<List<SessaoVotacao>>(this.sessaovotacaoService.listarTodos()));
    }

    @GetMapping(path = "/{id}")
    public Responses<Responses<SessaoVotacao>> listarPorId(@PathVariable(name = "id") String id) {
        return Responses.ok(new Responses<SessaoVotacao>(this.sessaovotacaoService.listarPorId(id)));
    }

    @GetMapping(path = "/{status}")
    public Responses<Responses<SessaoVotacao>> listarPorStatus(@PathVariable(name = "status") String status) {
        return Responses.ok(new Responses<SessaoVotacao>(this.sessaovotacaoService.listarPorStatus(status)));
    }

    @PostMapping
    public Responses<Responses<SessaoVotacao>> cadastrar(@Valid @RequestBody SessaoVotacao sessaovotacao, BindingResult result) {
        if (result.hasErrors()) {
            List<String> erros = new ArrayList<String>();
            result.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));
            return Responses.badRequest().body(new Responses<SessaoVotacao>(erros));
        }

        return Responses.ok(new Responses<SessaoVotacao>(this.sessaovotacaoService.cadastrar(votos)));
    }
}
