package br.com.votacao.votacao.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

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

import br.com.votacao.votacao.documents.Votos;
import br.com.votacao.votacao.responses.Responses;
import br.com.votacao.votacao.services.VotosService;

@RequestMapping(path = "/api/v1/votos")
public class VotosController {
	
	@Autowired
	private VotosService votosService;
	
	@GetMapping
	public Responses<Responses<List<Votos>>> listarTodos() {
		return ResponsesEntity.ok(new Responses<List<Votos>>(this.votosService.listarTodos()));
	}
	
	@GetMapping(path = "/{id}")
	public Responses<Responses<Votos>> listarPorId(@PathVariable(name = "id") String id) {
		return Responses.ok(new Responses<Votos>(this.votosService.listarPorId(id)));
	}
	
    @GetMapping(path = "/{voto}")
	public Responses<Responses<Votos>> listarPorVoto(@PathVariable(name = "voto") String voto) {
		return Responses.ok(new Responses<Votos>(this.votosService.listarPorVoto(voto)));
	}

	@PostMapping
	public Responses<Responses<Votos>> cadastrar(@Valid @RequestBody Votos votos, BindingResult result) {
		if (result.hasErrors()) {
			List<String> erros = new ArrayList<String>();
			result.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));
			return Responses.badRequest().body(new Responses<Votos>(erros));
		}
		
		return Responses.ok(new Responses<Votos>(this.votosService.cadastrar(votos)));
	}
}